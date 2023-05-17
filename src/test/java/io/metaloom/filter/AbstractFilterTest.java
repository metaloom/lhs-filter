package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilterTest implements FilterTestCases {

	public <F extends Filter<V>, V extends FilterValue> F assertParsedFilter(String expectedFilterStr, F filter) {
		String filterStr = filter.toString();
		assertEquals(expectedFilterStr, filterStr, "The serialized filter did not match up");

		List<Filter<FilterValue>> parsedFilters = Filter.parse(filterStr, TestFilterKey::fromKey);
		assertEquals(1, parsedFilters.size(), "There should only be one filter");
		Filter<?> parsedFilter = parsedFilters.get(0);
		assertEquals(filter.getClass(), parsedFilter.getClass(), "The filter type did not match up.");
		assertEquals(filter.value().getClass(), parsedFilter.value().getClass(), "The filter value did not match up");
		return (F) parsedFilter;
	}

}
