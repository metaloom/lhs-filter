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

public class LesserFilterTest extends AbstractFilterTest {

	@Override
	public void testStringFilterValue() {
		// Does not apply
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		LesserFilter filter = TestFilterKey.VIDEO_DURATION.lte(Duration.of(10, ChronoUnit.MINUTES));
		DurationFilterValue value = filter.value();
		assertEquals(10, value.getDuration().toMinutes());

		LesserFilter parsedFilter = assertParsedFilter("duration[lte]=PT10M", filter);
		DurationFilterValue parsedValue = parsedFilter.value();
		assertEquals(10, parsedValue.getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		LesserFilter filter = TestFilterKey.FILE_SIZE.lte("10GB");
		SizeFilterValue value = filter.value();
		assertEquals(10L * 1024 * 1024 * 1024, value.getNumber());

		LesserFilter parsedFilter = assertParsedFilter("size[lte]=10GB", filter);
		SizeFilterValue parsedValue = parsedFilter.value();
		assertEquals(10L * 1024 * 1024 * 1024, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		LesserFilter filter = TestFilterKey.ARTICLE_PRICE.lte(42);
		NumberFilterValue value = filter.value();
		assertEquals(42, value.getNumber());

		LesserFilter parsedFilter = assertParsedFilter("price[lte]=42", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(42, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		LesserFilter filter = TestFilterKey.DUE_TIME.lte(LocalTime.parse("13:37"));
		LocalTimeFilterValue value = filter.value();
		assertEquals("13:37", value.getTime().toString());

		LesserFilter parsedFilter = assertParsedFilter("due_time[lte]=13:37", filter);
		LocalTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("13:37", parsedValue.getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		LesserFilter filter = TestFilterKey.DUE.lte(LocalDateTime.parse("1970-12-20T13:37"));
		LocalDateTimeFilterValue value = filter.value();
		assertEquals("1970-12-20T13:37", value.getDateTime().toString());

		LesserFilter parsedFilter = assertParsedFilter("due[lte]=1970-12-20T13:37", filter);
		LocalDateTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20T13:37", parsedValue.getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		LesserFilter filter = TestFilterKey.DUE_DATE.lte(LocalDate.parse("1970-12-20"));
		LocalDateFilterValue value = filter.value();
		assertEquals("1970-12-20", value.getDate().toString());

		LesserFilter parsedFilter = assertParsedFilter("due_date[lte]=1970-12-20", filter);
		LocalDateFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20", parsedValue.getDate().toString());
	}

}
