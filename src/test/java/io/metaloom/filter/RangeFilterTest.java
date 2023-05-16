package io.metaloom.filter;

import static io.metaloom.filter.value.RangeFilterValue.RANGE_SEPERATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.NumberRangeFilterValue;

public class RangeFilterTest extends AbstractFilterTest {

	@Test
	public void testRangeFilter() {
		RangeFilter<NumberRangeFilterValue> filter = TestFilterKey.ARTICLE_PRICE.getKey().range(12.42d, 24.56d);
		assertEquals("price[range]=12.42" + RANGE_SEPERATOR + "24.56", filter.toString());
		assertEquals("12.42" + RANGE_SEPERATOR + "24.56", filter.value().toString());
		assertEquals(24.56d, filter.value().getTo());
		
		RangeFilter<NumberRangeFilterValue> parsedFilter = assertParsedFilter("price[range]=12.42_24.56", filter);
		assertEquals(24.56d, parsedFilter.value().getTo());
	}
}
