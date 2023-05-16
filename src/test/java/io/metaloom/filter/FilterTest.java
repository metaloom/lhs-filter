package io.metaloom.filter;

import static io.metaloom.filter.value.RangeFilterValue.RANGE_SEPERATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.value.impl.NumberRangeFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;

public class FilterTest {

	@Test
	public void testFilter() {
		EqualsFilter<StringFilterValue> filter = TestFilterKey.USER_USERNAME.eq("joedoe");
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

	@Test
	public void testMultipleFilters() {
		String line = IntStream.range(0, 3).boxed().map(i -> {
			return TestFilterKey.USER_USERNAME.eq("joedoe_" + i).toString();
		}).collect(Collectors.joining(","));

		System.out.println(line);

		List<Filter<?>> parsedFilter = Filter.parse(line, TestFilterKey::fromKey);
		assertEquals(3, parsedFilter.size());
		assertEquals("joedoe_2", parsedFilter.get(2).value().toString());
	}

	@Test
	public void testRangeFilter() {
		RangeFilter<NumberRangeFilterValue> filter = TestFilterKey.ARTICLE_PRICE.range(12.42d, 24.56d);
		assertEquals("price[range]=12.42" + RANGE_SEPERATOR + "24.56", filter.toString());
		assertEquals("12.42" + RANGE_SEPERATOR + "24.56", filter.value().toString());
		assertEquals(24.56d, filter.value().getTo());
	}
}
