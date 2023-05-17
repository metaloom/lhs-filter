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
import io.metaloom.filter.value.impl.LocalDateFilterValue;
import io.metaloom.filter.value.impl.LocalDateTimeFilterValue;
import io.metaloom.filter.value.impl.LocalTimeFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.SizeFilterValue;

public class LesserFilterTest extends AbstractFilterTest {

	@Override
	public void testStringFilterValue() {
		// Does not apply
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		LesserFilter<DurationFilterValue> filter = TestFilterKey.VIDEO_DURATION.lte(Duration.of(10, ChronoUnit.MINUTES));
		assertEquals(10, filter.value().getDuration().toMinutes());

		LesserFilter<DurationFilterValue> parsedFilter = assertParsedFilter("duration[lte]=PT10M", filter);
		assertEquals(10, parsedFilter.value().getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		LesserFilter<SizeFilterValue> filter = TestFilterKey.FILE_SIZE.lte("10GB");
		assertEquals(10L * 1024 * 1024 * 1024, filter.value().getNumber());

		LesserFilter<SizeFilterValue> parsedFilter = assertParsedFilter("size[lte]=10GB", filter);
		assertEquals(10L * 1024 * 1024 * 1024, parsedFilter.value().getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		LesserFilter<NumberFilterValue> filter = TestFilterKey.ARTICLE_PRICE.lte(42);
		assertEquals(42, filter.value().getNumber());

		LesserFilter<NumberFilterValue> parsedFilter = assertParsedFilter("price[lte]=42", filter);
		assertEquals(42, parsedFilter.value().getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		LesserFilter<LocalTimeFilterValue> filter = TestFilterKey.DUE_TIME.lte(LocalTime.parse("13:37"));
		assertEquals("13:37", filter.value().getTime().toString());

		LesserFilter<LocalTimeFilterValue> parsedFilter = assertParsedFilter("due_time[lte]=13:37", filter);
		assertEquals("13:37", parsedFilter.value().getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		LesserFilter<LocalDateTimeFilterValue> filter = TestFilterKey.DUE.lte(LocalDateTime.parse("1970-12-20T13:37"));
		assertEquals("1970-12-20T13:37", filter.value().getDateTime().toString());

		LesserFilter<LocalDateTimeFilterValue> parsedFilter = assertParsedFilter("due[lte]=1970-12-20T13:37", filter);
		assertEquals("1970-12-20T13:37", parsedFilter.value().getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		LesserFilter<LocalDateFilterValue> filter = TestFilterKey.DUE_DATE.lte(LocalDate.parse("1970-12-20"));
		assertEquals("1970-12-20", filter.value().getDate().toString());

		LesserFilter<LocalDateFilterValue> parsedFilter = assertParsedFilter("due_date[lte]=1970-12-20", filter);
		assertEquals("1970-12-20", parsedFilter.value().getDate().toString());
	}

}
