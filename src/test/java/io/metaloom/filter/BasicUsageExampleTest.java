package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		EqualsFilter<StringFilterValue> filter = ExampleFilterKey.USER_USERNAME.getKey().eq("joedoe");
		assertEquals("username[eq]=joedoe", filter.toString());

		// Parse a filter
		List<Filter<?>> parsedFilters = Filter.parse("username[eq]=joedoe", ExampleFilterKey::fromKey);
		Filter<?> parsedFilter = parsedFilters.get(0);
		assertEquals(ExampleFilterKey.USER_USERNAME, parsedFilter.filterKey());
		assertEquals("joedoe", parsedFilter.value());
		// SNIPPET END example
	}

	// SNIPPET START key
	enum ExampleFilterKey {

		USER_USERNAME(new StringFilterKey("username"));

		private FilterKey<?> key;

		ExampleFilterKey(FilterKey<?> key) {
			this.key = key;
		}

		public FilterKey<?> getKey() {
			return key;
		}

		static FilterKey<?> fromKey(String key) {
			for (ExampleFilterKey v : values()) {
				if (v.getKey().key().equals(key)) {
					return v.getKey();
				}
			}
			return null;
		}
	}
	// SNIPPET END key
}
