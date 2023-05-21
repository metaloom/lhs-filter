package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.impl.LocalTimeFilterKey;
import io.metaloom.filter.key.impl.SizeFilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;
import io.metaloom.filter.parser.LHSFilterParser;
import io.metaloom.filter.parser.impl.LHSFilterParserImpl;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;
import io.metaloom.filter.value.impl.range.SizeRangeFilterValue;

public class BasicUsageExampleTest {

	@Test
	public void testExample() {
		// SNIPPET START example
		// Define the filter keys
		StringFilterKey USER_USERNAME = new StringFilterKey("username");
		LocalTimeFilterKey CREATE_DATE = new LocalTimeFilterKey("created");
		SizeFilterKey FILE_SIZE = new SizeFilterKey("size");

		// Construct a filter
		ValueFilter filter1 = USER_USERNAME.eq("joedoe");
		assertEquals("username[eq]=joedoe", filter1.toString());

		ValueFilter filter2 = CREATE_DATE.after(LocalTime.parse("13:37"));
		assertEquals("created[after]=13:37", filter2.toString());

		ValueFilter filter3 = FILE_SIZE.gte("12 GB");
		assertEquals("size[gte]=12GB", filter3.toString());

		// Register the keys in the parser
		LHSFilterParser parser = new LHSFilterParserImpl();
		parser.register(USER_USERNAME);
		parser.register(CREATE_DATE);
		parser.register(FILE_SIZE);

		// Parse a filter string
		String queryLine = "username[eq]=joedoe,size[range]=1GB_42GB";
		List<Filter> parsedFilters = parser.parse(queryLine);
		for (Filter filter : parsedFilters) {
			FilterKey key = filter.filterKey();
			if (key == USER_USERNAME) {
				System.out.println("Filter by username: " + filter.valueStr());
			} else if (key == FILE_SIZE && filter instanceof RangeFilter r && r.value() instanceof SizeRangeFilterValue rv) {
				System.out.println("Filter by size range: " + rv.getFrom() + " to " + rv.getTo() + " bytes");
			} else {
				throw new RuntimeException("Unknown filter " + filter.filterKey().id());
			}

			if (filter.matches(USER_USERNAME, Operation.EQUALS)) {
				String result = filter.apply(StringFilterValue.class, sv -> {
					return "blub";
				});
				System.out.println("Result: " + result);
			}
		}
		Filter parsedFilter = parsedFilters.get(0);
		assertEquals(USER_USERNAME, parsedFilter.filterKey());
		StringFilterValue value = parsedFilter.value();
		assertEquals("joedoe", value.toString());
		// SNIPPET END example
	}
}
