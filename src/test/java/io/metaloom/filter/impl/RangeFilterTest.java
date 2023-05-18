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
		RangeFilter filter = TestFilterKey.ARTICLE_PRICE.range(12.42d, 24.56d);
		assertEquals("price[range]=12.42" + RANGE_SEPERATOR + "24.56", filter.toString());
		assertEquals("12.42" + RANGE_SEPERATOR + "24.56", filter.value().toString());
		NumberRangeFilterValue value = filter.value();
		assertEquals(12.42d, value.getFrom());
		assertEquals(24.56d, value.getTo());

		RangeFilter parsedFilter = assertParsedFilter("price[range]=12.42_24.56", filter);
		NumberRangeFilterValue parsedValue = parsedFilter.value();
		assertEquals(12.42d, parsedValue.getFrom());
		assertEquals(24.56d, parsedValue.getTo());
	}

	@Override
	public void testDurationFilterValue() {
		RangeFilter filter = TestFilterKey.VIDEO_DURATION.range(Duration.of(10, ChronoUnit.MINUTES),
			Duration.of(20, ChronoUnit.MINUTES));
		DurationRangeFilterValue value = filter.value();
		assertEquals(10, value.getFrom().toMinutes());
		assertEquals(20, value.getTo().toMinutes());

		RangeFilter parsedFilter = assertParsedFilter("duration[eq]=PT10M", filter);
		DurationRangeFilterValue parsedValue = parsedFilter.value();
		assertEquals(10, parsedValue.getFrom().toMinutes());
		assertEquals(20, parsedValue.getTo().toMinutes());

	}

	@Test
	@Override
	public void testSizeFilterValue() {
		RangeFilter filter = TestFilterKey.FILE_SIZE.range("12GB", "200GB");
		SizeRangeFilterValue value = filter.value();
		assertEquals(12L * 1024 * 1024 * 1024, value.getFrom());
		assertEquals(200L * 1024 * 1024 * 1024, value.getTo());

		RangeFilter parsedFilter = assertParsedFilter("size[range]=12GB_200GB", filter);
		SizeRangeFilterValue parsedValue = parsedFilter.value();
		assertEquals(12L * 1024 * 1024 * 1024, parsedValue.getFrom());
		assertEquals(200L * 1024 * 1024 * 1024, parsedValue.getTo());
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
