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
import io.metaloom.filter.value.impl.StringFilterValue;

public class EqualsFilterTest extends AbstractFilterTest {

	@Test
	@Override
	public void testStringFilterValue() {
		EqualsFilter<StringFilterValue> filter = TestFilterKey.USER_USERNAME.eq("joedoe");
		assertEquals("joedoe", filter.value().getText());

		EqualsFilter<StringFilterValue> parsedFilter = assertParsedFilter("username[eq]=joedoe", filter);
		assertEquals("joedoe", parsedFilter.value().getText());
	}

	@Test
	@Override
	public void testDurationFilterValue() {
		EqualsFilter<DurationFilterValue> filter = TestFilterKey.VIDEO_DURATION.eq(Duration.of(10, ChronoUnit.MINUTES));
		assertEquals(10, filter.value().getDuration().toMinutes());

		EqualsFilter<DurationFilterValue> parsedFilter = assertParsedFilter("duration[eq]=PT10M", filter);
		assertEquals(10, parsedFilter.value().getDuration().toMinutes());
	}

	@Test
	@Override
	public void testSizeFilterValue() {
		EqualsFilter<SizeFilterValue> filter = TestFilterKey.FILE_SIZE.eq("10GB");
		assertEquals(10L * 1024 * 1024 * 1024, filter.value().getNumber());

		EqualsFilter<SizeFilterValue> parsedFilter = assertParsedFilter("size[eq]=10GB", filter);
		assertEquals(10L * 1024 * 1024 * 1024, parsedFilter.value().getNumber().longValue());
	}

	@Test
	@Override
	public void testNumberFilterValue() {
		EqualsFilter<NumberFilterValue> filter = TestFilterKey.ARTICLE_PRICE.eq(42);
		assertEquals(42, filter.value().getNumber());

		EqualsFilter<NumberFilterValue> parsedFilter = assertParsedFilter("price[eq]=42", filter);
		assertEquals(42, parsedFilter.value().getNumber().longValue());
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		EqualsFilter<LocalTimeFilterValue> filter = TestFilterKey.DUE_TIME.eq(LocalTime.parse("13:37"));
		assertEquals("13:37", filter.value().getTime().toString());

		EqualsFilter<LocalTimeFilterValue> parsedFilter = assertParsedFilter("due_time[eq]=13:37", filter);
		assertEquals("13:37", parsedFilter.value().getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		EqualsFilter<LocalDateTimeFilterValue> filter = TestFilterKey.DUE.eq(LocalDateTime.parse("1970-12-20T13:37"));
		assertEquals("1970-12-20T13:37", filter.value().getDateTime().toString());

		EqualsFilter<LocalDateTimeFilterValue> parsedFilter = assertParsedFilter("due[eq]=1970-12-20T13:37", filter);
		assertEquals("1970-12-20T13:37", parsedFilter.value().getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		EqualsFilter<LocalDateFilterValue> filter = TestFilterKey.DUE_DATE.eq(LocalDate.parse("1970-12-20"));
		assertEquals("1970-12-20", filter.value().getDate().toString());

		EqualsFilter<LocalDateFilterValue> parsedFilter = assertParsedFilter("due_date[eq]=1970-12-20", filter);
		assertEquals("1970-12-20", parsedFilter.value().getDate().toString());
	}

}
