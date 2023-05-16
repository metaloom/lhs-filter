package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.key.impl.StringFilterKey;
import io.metaloom.filter.value.impl.StringFilterValue;

public class BasicUsageExampleTest {

	@Test
	public void testExample() {
		// SNIPPET START example
		// Construct a filter
		EqualsFilter<StringFilterValue> filter = ExampleFilterKey.USER_USERNAME.eq("joedoe");
		assertEquals("username[eq]=joedoe", filter.toString());

		// Parse a filter
		List<Filter<?>> parsedFilters = Filter.parse("username[eq]=joedoe", ExampleFilterKey::fromKey);
		Filter<?> parsedFilter = parsedFilters.get(0);
		assertEquals(ExampleFilterKey.USER_USERNAME, parsedFilter.filterKey());
		assertEquals("joedoe", parsedFilter.value());
		// SNIPPET END example
	}

	// SNIPPET START key
	final class ExampleFilterKey {

		public static final StringFilterKey USER_USERNAME = new StringFilterKey("username");

		static FilterKey<?> fromKey(String key) {
			for (FilterKey<?> v : Arrays.asList(USER_USERNAME)) {
				if (v.key().equals(key)) {
					return v;
				}
			}
			return null;
		}
	}
	// SNIPPET END key
}
