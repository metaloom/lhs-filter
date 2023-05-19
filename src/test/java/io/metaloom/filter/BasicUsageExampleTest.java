package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.key.impl.LocalTimeFilterKey;
import io.metaloom.filter.key.impl.SizeFilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;
import io.metaloom.filter.parser.LHSFilterParser;
import io.metaloom.filter.value.impl.StringFilterValue;

public class BasicUsageExampleTest {

	@Test
	public void testExample() {
		// SNIPPET START example
		// Define the filter keys
		StringFilterKey USER_USERNAME = new StringFilterKey("username", (filterkey, filter, value) -> {
			System.out.println("Mapper " + value.getClass());
			System.out.println("Mapper " + filter);
			System.out.println("Mapper " + filterkey.key());
			return "action result";
		});
		LocalTimeFilterKey CREATE_DATE = new LocalTimeFilterKey("created");
		SizeFilterKey FILE_SIZE = new SizeFilterKey("size");

		// Construct a filter
		EqualsFilter filter1 = USER_USERNAME.eq("joedoe");
		assertEquals("username[eq]=joedoe", filter1.toString());

		AfterFilter filter2 = CREATE_DATE.after(LocalTime.parse("13:37"));
		assertEquals("created[after]=13:37", filter2.toString());

		GreaterFilter filter3 = FILE_SIZE.gte("12 GB");
		assertEquals("size[gte]=12GB", filter3.toString());

		// Register the keys in the parser
		LHSFilterParser.getInstance().register(USER_USERNAME);
		LHSFilterParser.getInstance().register(CREATE_DATE);
		LHSFilterParser.getInstance().register(FILE_SIZE);

		// Parse a filter string
		String queryLine = "username[eq]=joedoe,size[range]=1GB_42GB";
		List<Filter> parsedFilters = LHSFilterParser.getInstance().parse(queryLine);
		for (Filter filter : parsedFilters) {
			String result = filter.invoke();
			System.out.println("Result: " + result);
		}
		Filter parsedFilter = parsedFilters.get(0);
		assertEquals(USER_USERNAME, parsedFilter.filterKey());
		StringFilterValue value = parsedFilter.value();
		assertEquals("joedoe", value.toString());
		// SNIPPET END example
	}
}
