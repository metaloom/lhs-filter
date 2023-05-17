package io.metaloom.filter.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.AbstractFilterTest;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.time.LocalDateFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;

public class AfterFilterTest extends AbstractFilterTest {

	@Override
	public void testStringFilterValue() {
		// Does not apply
	}

	@Override
	public void testDurationFilterValue() {
		// Does not apply
	}

	@Override
	public void testSizeFilterValue() {
		// Does not apply
	}

	@Override
	public void testNumberFilterValue() {
		// Does not apply
	}

	@Test
	@Override
	public void testLocalTimeFilterValue() {
		AfterFilter<LocalTimeFilterValue> filter = TestFilterKey.DUE_TIME.after(LocalTime.parse("13:37"));
		assertEquals("13:37", filter.value().getTime().toString());

		AfterFilter<LocalTimeFilterValue> parsedFilter = assertParsedFilter("due_time[after]=13:37", filter);
		assertEquals("13:37", parsedFilter.value().getTime().toString());
	}

	@Test
	@Override
	public void testLocalDateTimeFilterValue() {
		AfterFilter<LocalDateTimeFilterValue> filter = TestFilterKey.DUE.after(LocalDateTime.parse("1970-12-20T13:37"));
		assertEquals("1970-12-20T13:37", filter.value().getDateTime().toString());

		AfterFilter<LocalDateTimeFilterValue> parsedFilter = assertParsedFilter("due[after]=1970-12-20T13:37", filter);
		assertEquals("1970-12-20T13:37", parsedFilter.value().getDateTime().toString());
	}

	@Test
	@Override
	public void testLocalDateFilterValue() {
		AfterFilter<LocalDateFilterValue> filter = TestFilterKey.DUE_DATE.after(LocalDate.parse("1970-12-20"));
		assertEquals("1970-12-20", filter.value().getDate().toString());

		AfterFilter<LocalDateFilterValue> parsedFilter = assertParsedFilter("due_date[after]=1970-12-20", filter);
		assertEquals("1970-12-20", parsedFilter.value().getDate().toString());
	}

}
