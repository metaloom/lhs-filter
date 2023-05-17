package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.FilterValue;

public class FilterTest {

	@Test
	public void testMultipleFilters() {
		String line = IntStream.range(0, 3).boxed().map(i -> {
			return TestFilterKey.USER_USERNAME.eq("joedoe_" + i).toString();
		}).collect(Collectors.joining(","));

		System.out.println(line);

		List<Filter<FilterValue>> parsedFilter = Filter.parse(line, TestFilterKey::fromKey);
		assertEquals(3, parsedFilter.size());
		assertEquals("joedoe_2", parsedFilter.get(2).value().toString());
	}

}
