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
		GreaterFilter filter = TestFilterKey.VIDEO_DURATION.gte(Duration.of(10, ChronoUnit.MINUTES));
		DurationFilterValue value = filter.value();
		assertEquals(10, value.getDuration().toMinutes());

		GreaterFilter parsedFilter = assertParsedFilter("duration[gte]=PT10M", filter);
		DurationFilterValue parsedValue = parsedFilter.value();
		assertEquals(10, parsedValue.getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		GreaterFilter filter = TestFilterKey.FILE_SIZE.gte("10GB");
		SizeFilterValue value = filter.value();
		assertEquals(10L * 1024 * 1024 * 1024, value.getNumber());

		GreaterFilter parsedFilter = assertParsedFilter("size[gte]=10GB", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(10L * 1024 * 1024 * 1024, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		GreaterFilter filter = TestFilterKey.ARTICLE_PRICE.gte(42);
		NumberFilterValue value = filter.value();
		assertEquals(42, value.getNumber());

		GreaterFilter parsedFilter = assertParsedFilter("price[gte]=42", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(42, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		GreaterFilter filter = TestFilterKey.DUE_TIME.gte(LocalTime.parse("13:37"));
		LocalTimeFilterValue value = filter.value();
		assertEquals("13:37", value.getTime().toString());

		GreaterFilter parsedFilter = assertParsedFilter("due_time[gte]=13:37", filter);
		LocalTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("13:37", parsedValue.getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		GreaterFilter filter = TestFilterKey.DUE.gte(LocalDateTime.parse("1970-12-20T13:37"));
		LocalDateTimeFilterValue value = filter.value();
		assertEquals("1970-12-20T13:37", value.getDateTime().toString());

		GreaterFilter parsedFilter = assertParsedFilter("due[gte]=1970-12-20T13:37", filter);
		LocalDateTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20T13:37", parsedValue.getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		GreaterFilter filter = TestFilterKey.DUE_DATE.gte(LocalDate.parse("1970-12-20"));
		LocalDateFilterValue value = filter.value();
		assertEquals("1970-12-20", value.getDate().toString());

		GreaterFilter parsedFilter = assertParsedFilter("due_date[gte]=1970-12-20", filter);
		LocalDateFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20", parsedValue.getDate().toString());
	}
}
