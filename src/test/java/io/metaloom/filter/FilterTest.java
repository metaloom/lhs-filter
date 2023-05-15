package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.EqualsFilter;

public class FilterTest {

	@Test
	public void testFilter() {
		Filter filter = TestFilterKey.USER_USERNAME.eq("joedoe");
		assertEquals(filter.getClass(), EqualsFilter.class);
		String line = filter.toString();

		System.out.println(line);

		Filter parsedFilter = Filter.parse(line, TestFilterKey::fromKey);
		assertEquals(parsedFilter.getClass(), EqualsFilter.class);
		EqualsFilter parsedEqFilter = (EqualsFilter) parsedFilter;
		assertEquals(TestFilterKey.USER_USERNAME, parsedEqFilter.key());
		assertEquals("joedoe", parsedEqFilter.value());
	}

	@Test
	public void testRangeFilter() {
		Filter filter = TestFilterKey.USER_USERNAME.eq("joedoe");
	}
}
