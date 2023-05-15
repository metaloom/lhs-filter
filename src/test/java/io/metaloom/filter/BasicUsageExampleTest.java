package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicUsageExampleTest {

	@Test
	public void testExample() {
		// SNIPPET START example
		// Construct a filter
		Filter filter = ExampleFilterKey.USER_USERNAME.eq("joedoe");
		assertEquals("username[eq]=joedoe", filter.toString());

		// Parse a filter
		Filter parsedFilter = Filter.parse("username[eq]=joedoe", ExampleFilterKey::fromKey);
		assertEquals(ExampleFilterKey.USER_USERNAME, parsedFilter.key());
		assertEquals("joedoe", parsedFilter.value());
		// SNIPPET END example
	}

	// SNIPPET START key
	enum ExampleFilterKey implements FilterKey {

		USER_USERNAME("username", String.class);

		private String name;
		private Class<String> clazz;

		ExampleFilterKey(String name, Class<String> clazz) {
			this.name = name;
			this.clazz = clazz;
		}

		@Override
		public String key() {
			return name;
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
