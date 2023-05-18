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
import io.metaloom.filter.value.impl.StringFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;

public class EqualsFilterTest extends AbstractFilterTest {

	@Test
	@Override
	public void testStringFilterValue() {
		EqualsFilter filter = TestFilterKey.USER_USERNAME.eq("joedoe");
		StringFilterValue value = filter.value();
		assertEquals("joedoe", value.getText());

		EqualsFilter parsedFilter = assertParsedFilter("username[eq]=joedoe", filter);
		StringFilterValue parsedValue = parsedFilter.value();
		assertEquals("joedoe", parsedValue.getText());
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		EqualsFilter filter = TestFilterKey.VIDEO_DURATION.eq(Duration.of(10, ChronoUnit.MINUTES));
		DurationFilterValue value = filter.value();
		assertEquals(10, value.getDuration().toMinutes());

		EqualsFilter parsedFilter = assertParsedFilter("duration[eq]=PT10M", filter);
		DurationFilterValue parsedValue = parsedFilter.value();
		assertEquals(10, parsedValue.getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		EqualsFilter filter = TestFilterKey.FILE_SIZE.eq("10GB");
		SizeFilterValue value = filter.value();
		assertEquals(10L * 1024 * 1024 * 1024, value.getNumber());

		EqualsFilter parsedFilter = assertParsedFilter("size[eq]=10GB", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(10L * 1024 * 1024 * 1024, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		EqualsFilter filter = TestFilterKey.ARTICLE_PRICE.eq(42);
		NumberFilterValue value = filter.value();
		assertEquals(42, value.getNumber());

		EqualsFilter parsedFilter = assertParsedFilter("price[eq]=42", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(42, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		EqualsFilter filter = TestFilterKey.DUE_TIME.eq(LocalTime.parse("13:37"));
		LocalTimeFilterValue value = filter.value();
		assertEquals("13:37", value.getTime().toString());

		EqualsFilter parsedFilter = assertParsedFilter("due_time[eq]=13:37", filter);
		LocalTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("13:37", parsedValue.getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		EqualsFilter filter = TestFilterKey.DUE.eq(LocalDateTime.parse("1970-12-20T13:37"));
		LocalDateTimeFilterValue value = filter.value();
		assertEquals("1970-12-20T13:37", value.getDateTime().toString());

		EqualsFilter parsedFilter = assertParsedFilter("due[eq]=1970-12-20T13:37", filter);
		LocalDateTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20T13:37", parsedValue.getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		EqualsFilter filter = TestFilterKey.DUE_DATE.eq(LocalDate.parse("1970-12-20"));
		LocalDateFilterValue value = filter.value();
		assertEquals("1970-12-20", value.getDate().toString());

		EqualsFilter parsedFilter = assertParsedFilter("due_date[eq]=1970-12-20", filter);
		LocalDateFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20", parsedValue.getDate().toString());
	}

}
