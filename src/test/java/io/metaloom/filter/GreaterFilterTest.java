package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.SizeFilterValue;

public class GreaterFilterTest extends AbstractFilterTest {

	@Test
	public void testDurationFilter() {
		GreaterFilter<DurationFilterValue> filter = TestFilterKey.VIDEO_DURATION.gte(Duration.of(10, ChronoUnit.MINUTES));
		assertEquals(10, filter.value().getDuration().toMinutes());

		GreaterFilter<DurationFilterValue> parsedFilter = assertParsedFilter("duration[gte]=PT10M", filter);
		assertEquals(10, parsedFilter.value().getDuration().toMinutes());
	}

	@Test
	public void testSizeValueFilter() {
		GreaterFilter<SizeFilterValue> filter = TestFilterKey.FILE_SIZE.gte("42GB");
		assertEquals(42L * 1024 * 1024 * 1024, filter.value().getSizeInBytes());

		GreaterFilter<SizeFilterValue> bogusFilter = TestFilterKey.FILE_SIZE.gte("blar");
		assertNull(bogusFilter.value().getSizeInBytes());
	}

	@Test
	public void testNumberFilter() {
		GreaterFilter<NumberFilterValue> filter = TestFilterKey.ARTICLE_PRICE.gte(42);
		assertEquals(42, filter.value().getNumber());

		GreaterFilter<NumberFilterValue> parsedFilter = assertParsedFilter("size[gte]=42", filter);
		assertEquals(42, parsedFilter.value().getNumber().longValue());
	}

}
