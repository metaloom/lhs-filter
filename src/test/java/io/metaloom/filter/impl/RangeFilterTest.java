package io.metaloom.filter.impl;

import static io.metaloom.filter.value.RangeFilterValue.RANGE_SEPERATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.AbstractFilterTest;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.NumberRangeFilterValue;

public class RangeFilterTest extends AbstractFilterTest {

	@Test
	@Override
	public void testNumberFilterValue() {
		RangeFilter<NumberRangeFilterValue> filter = TestFilterKey.ARTICLE_PRICE.range(12.42d, 24.56d);
		assertEquals("price[range]=12.42" + RANGE_SEPERATOR + "24.56", filter.toString());
		assertEquals("12.42" + RANGE_SEPERATOR + "24.56", filter.value().toString());
		assertEquals(24.56d, filter.value().getTo());

		RangeFilter<NumberRangeFilterValue> parsedFilter = assertParsedFilter("price[range]=12.42_24.56", filter);
		assertEquals(24.56d, parsedFilter.value().getTo());
	}

	@Test
	@Override
	public void testStringFilterValue() {
		// Does not apply
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		// TODO Auto-generated method stub

	}

	@Test
	@Override
	public void testSizeFilterValue() {
		// TODO Auto-generated method stub

	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		// TODO Auto-generated method stub

	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		// TODO Auto-generated method stub

	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		// TODO Auto-generated method stub

	}

}
