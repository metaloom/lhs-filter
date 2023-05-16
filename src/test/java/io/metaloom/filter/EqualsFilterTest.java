package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.StringFilterValue;

public class EqualsFilterTest {

	
	@Test
	public void testFilter() {
		EqualsFilter<StringFilterValue> filter = TestFilterKey.USER_USERNAME.getKey().eq("joedoe");
		assertEquals(filter.getClass(), EqualsFilter.class);
		String line = filter.toString();

		System.out.println(line);

		List<Filter<?>> parsedFilter = Filter.parse(line, TestFilterKey::fromKey);
		assertEquals(1, parsedFilter.size());
		assertEquals(parsedFilter.get(0).getClass(), EqualsFilter.class);
		Filter<?> parsedEqFilter = parsedFilter.get(0);
		assertEquals(TestFilterKey.USER_USERNAME, parsedEqFilter.filterKey());
		assertEquals("joedoe", parsedEqFilter.value().toString());
	}
}
