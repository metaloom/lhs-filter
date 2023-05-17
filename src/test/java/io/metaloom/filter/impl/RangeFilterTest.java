package io.metaloom.filter.impl;

import static io.metaloom.filter.value.RangeFilterValue.RANGE_SEPERATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.AbstractFilterTest;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.range.DurationRangeFilterValue;
import io.metaloom.filter.value.impl.range.NumberRangeFilterValue;
import io.metaloom.filter.value.impl.range.SizeRangeFilterValue;

public class RangeFilterTest extends AbstractFilterTest {

	@Test
	@Override
	public void testNumberFilterValue() {
		RangeFilter<NumberRangeFilterValue> filter = TestFilterKey.ARTICLE_PRICE.range(12.42d, 24.56d);
		assertEquals("price[range]=12.42" + RANGE_SEPERATOR + "24.56", filter.toString());
		assertEquals("12.42" + RANGE_SEPERATOR + "24.56", filter.value().toString());
		assertEquals(12.42d, filter.value().getFrom());
		assertEquals(24.56d, filter.value().getTo());

		RangeFilter<NumberRangeFilterValue> parsedFilter = assertParsedFilter("price[range]=12.42_24.56", filter);
		assertEquals(12.42d, parsedFilter.value().getFrom());
		assertEquals(24.56d, parsedFilter.value().getTo());
	}

	@Override
	public void testDurationFilterValue() {
		RangeFilter<DurationRangeFilterValue> filter = TestFilterKey.VIDEO_DURATION.range(Duration.of(10, ChronoUnit.MINUTES),
			Duration.of(20, ChronoUnit.MINUTES));
		assertEquals(10, filter.value().getFrom().toMinutes());
		assertEquals(20, filter.value().getTo().toMinutes());

		RangeFilter<DurationRangeFilterValue> parsedFilter = assertParsedFilter("duration[eq]=PT10M", filter);
		assertEquals(10, parsedFilter.value().getFrom().toMinutes());
		assertEquals(20, parsedFilter.value().getTo().toMinutes());

	}

	@Test
	@Override
	public void testSizeFilterValue() {
		RangeFilter<SizeRangeFilterValue> filter = TestFilterKey.FILE_SIZE.range("12GB", "200GB");
		assertEquals(12L * 1024 * 1024 * 1024, filter.value().getFrom());
		assertEquals(200L * 1024 * 1024 * 1024, filter.value().getTo());

		RangeFilter<SizeRangeFilterValue> parsedFilter = assertParsedFilter("size[range]=12GB_200GB", filter);
		assertEquals(12L * 1024 * 1024 * 1024, parsedFilter.value().getFrom());
		assertEquals(200L * 1024 * 1024 * 1024, parsedFilter.value().getTo());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		fail("Not yet implemented");
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		fail("Not yet implemented");

	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		fail("Not yet implemented");

	}

	@Override
	public void testStringFilterValue() {
		// Does not apply
	}
}
