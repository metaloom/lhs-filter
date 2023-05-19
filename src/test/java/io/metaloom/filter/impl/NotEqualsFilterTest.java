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

public class NotEqualsFilterTest extends AbstractFilterTest {

	@Test
	@Override
	public void testStringFilterValue() {
		NotEqualsFilter filter = TestFilterKey.USER_USERNAME.ne("joedoe");
		StringFilterValue value = filter.value();
		assertEquals("joedoe", value.getText());

		NotEqualsFilter parsedFilter = assertParsedFilter("username[ne]=joedoe", filter);
		StringFilterValue parsedValue = parsedFilter.value();
		assertEquals("joedoe", parsedValue.getText());
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		NotEqualsFilter filter = TestFilterKey.VIDEO_DURATION.ne(Duration.of(10, ChronoUnit.MINUTES));
		DurationFilterValue value = filter.value();
		assertEquals(10, value.getDuration().toMinutes());

		NotEqualsFilter parsedFilter = assertParsedFilter("duration[ne]=PT10M", filter);
		DurationFilterValue parsedValue = parsedFilter.value();
		assertEquals(10, parsedValue.getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		NotEqualsFilter filter = TestFilterKey.FILE_SIZE.ne("10GB");
		SizeFilterValue value = filter.value();
		assertEquals(10L * 1024 * 1024 * 1024, value.getNumber());

		NotEqualsFilter parsedFilter = assertParsedFilter("size[ne]=10GB", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(10L * 1024 * 1024 * 1024, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		NotEqualsFilter filter = TestFilterKey.ARTICLE_PRICE.ne(42);
		NumberFilterValue value = filter.value();
		assertEquals(42, value.getNumber());

		NotEqualsFilter parsedFilter = assertParsedFilter("price[ne]=42", filter);
		NumberFilterValue parsedValue = parsedFilter.value();
		assertEquals(42, parsedValue.getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		NotEqualsFilter filter = TestFilterKey.DUE_TIME.ne(LocalTime.parse("13:37"));
		LocalTimeFilterValue value = filter.value();
		assertEquals("13:37", value.getTime().toString());

		NotEqualsFilter parsedFilter = assertParsedFilter("due_time[ne]=13:37", filter);
		LocalTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("13:37", parsedValue.getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		NotEqualsFilter filter = TestFilterKey.DUE.ne(LocalDateTime.parse("1970-12-20T13:37"));
		LocalDateTimeFilterValue value = filter.value();
		assertEquals("1970-12-20T13:37", value.getDateTime().toString());

		NotEqualsFilter parsedFilter = assertParsedFilter("due[ne]=1970-12-20T13:37", filter);
		LocalDateTimeFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20T13:37", parsedValue.getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		NotEqualsFilter filter = TestFilterKey.DUE_DATE.ne(LocalDate.parse("1970-12-20"));
		LocalDateFilterValue value = filter.value();
		assertEquals("1970-12-20", value.getDate().toString());

		NotEqualsFilter parsedFilter = assertParsedFilter("due_date[ne]=1970-12-20", filter);
		LocalDateFilterValue parsedValue = parsedFilter.value();
		assertEquals("1970-12-20", parsedValue.getDate().toString());
	}

}
