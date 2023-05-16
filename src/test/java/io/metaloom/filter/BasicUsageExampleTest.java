package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BasicUsageExampleTest {

	@Test
	public void testExample() {
		// SNIPPET START example
		// Construct a filter
		Filter filter = ExampleFilterKey.USER_USERNAME.eq("joedoe");
		assertEquals("username[eq]=joedoe", filter.toString());

		// Parse a filter
		List<Filter> parsedFilters = Filter.parse("username[eq]=joedoe", ExampleFilterKey::fromKey);
		Filter parsedFilter = parsedFilters.get(0);
		assertEquals(ExampleFilterKey.USER_USERNAME, parsedFilter.filterKey());
		assertEquals("joedoe", parsedFilter.value());
		// SNIPPET END example
	}

	// SNIPPET START key
	enum ExampleFilterKey implements FilterKey {

		USER_USERNAME("username", String.class);

		private String key;
		private Class<String> clazz;

		ExampleFilterKey(String key, Class<String> clazz) {
			this.key = key;
			this.clazz = clazz;
		}

		@Override
		public String key() {
			return key;
		}

		static FilterKey fromKey(String key) {
			for (FilterKey v : values()) {
				if (v.key().equals(key)) {
					return v;
				}
			}
			return null;
		}
	}
	// SNIPPET END key
}
