package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.key.impl.LocalTimeFilterKey;
import io.metaloom.filter.key.impl.SizeFilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;
import io.metaloom.filter.parser.LHSFilterParser;
import io.metaloom.filter.value.FilterValue;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;

public class BasicUsageExampleTest {

	@Test
	public void testExample() {
		// SNIPPET START example
		// Construct a filter
		EqualsFilter filter = ExampleFilterKey.USER_USERNAME.eq("joedoe");
		assertEquals("username[eq]=joedoe", filter.toString());

		AfterFilter filter2 = ExampleFilterKey.CREATE_DATE.after(LocalTime.parse("13:37"));
		assertEquals("created[after]=13:37", filter2.toString());

		GreaterFilter filter3 = ExampleFilterKey.FILE_SIZE.gte("12 GB");
		assertEquals("size[gte]=12GB", filter3.toString());

		// Parse a filter
		List<Filter> parsedFilters = LHSFilterParser.getInstance().parse("username[eq]=joedoe");
		Filter parsedFilter = parsedFilters.get(0);
		assertEquals(ExampleFilterKey.USER_USERNAME, parsedFilter.filterKey());
		assertEquals("joedoe", parsedFilter.value().toString());
		// SNIPPET END example
	}

	// SNIPPET START key
	final class ExampleFilterKey {

		public static final StringFilterKey USER_USERNAME = new StringFilterKey("username");

		public static final LocalTimeFilterKey CREATE_DATE = new LocalTimeFilterKey("created");

		public static final SizeFilterKey FILE_SIZE = new SizeFilterKey("size");

		static {
			LHSFilterParser.getInstance().register(USER_USERNAME);
			LHSFilterParser.getInstance().register(CREATE_DATE);
			LHSFilterParser.getInstance().register(FILE_SIZE);
		}
	}
	// SNIPPET END key
}
