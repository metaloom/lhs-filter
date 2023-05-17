package io.metaloom.filter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.AbstractFilterTest;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;

public class GreaterFilterTest extends AbstractFilterTest {

	@Override
	public void testStringFilterValue() {
		// Does not apply
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		GreaterFilter<DurationFilterValue> filter = TestFilterKey.VIDEO_DURATION.gte(Duration.of(10, ChronoUnit.MINUTES));
		assertEquals(10, filter.value().getDuration().toMinutes());

		GreaterFilter<DurationFilterValue> parsedFilter = assertParsedFilter("duration[gte]=PT10M", filter);
		assertEquals(10, parsedFilter.value().getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		GreaterFilter<SizeFilterValue> filter = TestFilterKey.FILE_SIZE.gte("10GB");
		assertEquals(10L * 1024 * 1024 * 1024, filter.value().getNumber());

		GreaterFilter<SizeFilterValue> parsedFilter = assertParsedFilter("size[gte]=10GB", filter);
		assertEquals(10L * 1024 * 1024 * 1024, parsedFilter.value().getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		GreaterFilter<NumberFilterValue> filter = TestFilterKey.ARTICLE_PRICE.gte(42);
		assertEquals(42, filter.value().getNumber());

		GreaterFilter<NumberFilterValue> parsedFilter = assertParsedFilter("price[gte]=42", filter);
		assertEquals(42, parsedFilter.value().getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		GreaterFilter<LocalTimeFilterValue> filter = TestFilterKey.DUE_TIME.gte(LocalTime.parse("13:37"));
		assertEquals("13:37", filter.value().getTime().toString());

		GreaterFilter<LocalTimeFilterValue> parsedFilter = assertParsedFilter("due_time[gte]=13:37", filter);
		assertEquals("13:37", parsedFilter.value().getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		GreaterFilter<LocalDateTimeFilterValue> filter = TestFilterKey.DUE.gte(LocalDateTime.parse("1970-12-20T13:37"));
		assertEquals("1970-12-20T13:37", filter.value().getDateTime().toString());

		GreaterFilter<LocalDateTimeFilterValue> parsedFilter = assertParsedFilter("due[gte]=1970-12-20T13:37", filter);
		assertEquals("1970-12-20T13:37", parsedFilter.value().getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		GreaterFilter<LocalDateFilterValue> filter = TestFilterKey.DUE_DATE.gte(LocalDate.parse("1970-12-20"));
		assertEquals("1970-12-20", filter.value().getDate().toString());

		GreaterFilter<LocalDateFilterValue> parsedFilter = assertParsedFilter("due_date[gte]=1970-12-20", filter);
		assertEquals("1970-12-20", parsedFilter.value().getDate().toString());
	}
}
