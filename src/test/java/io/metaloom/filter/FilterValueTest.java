package io.metaloom.filter;

import static io.metaloom.filter.value.RangeFilterValue.RANGE_SEPERATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.value.FilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;
import io.metaloom.filter.value.impl.range.DateRangeFilterValue;
import io.metaloom.filter.value.impl.range.NumberRangeFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;
import io.metaloom.filter.value.impl.InstantFilterValue;

public class FilterValueTest {

	@Test
	public void testDateFilterValue() {
		assertNotNull(LocalDateFilterValue.create("2020-07-10"));
	}

	@Test
	public void testDateTimeFilterValue() {
		assertNotNull(LocalDateTimeFilterValue.create("2020-07-10T15:00:00"));
	}

	@Test
	public void testTimeFilterValue() {
		assertNotNull(LocalTimeFilterValue.create("15:00:00"));
	}

	@Test
	public void testUTCDateFilterValue() {
		InstantFilterValue value = InstantFilterValue.create("2020-07-10T15:00:00Z");
		assertNotNull(value);
		assertNotNull(value.getInstant());
	}

	@Test
	public void testStringFilterValue() {
		StringFilterValue value = StringFilterValue.create("ABCD");
		assertEquals("ABCD", value.toString());
	}

	@Test
	public void testNumberFilterValue() {
		assertNotNull(NumberFilterValue.create("42"));
		assertNotNull(NumberFilterValue.create("1"));
		assertNotNull(NumberFilterValue.create(String.valueOf(Long.MAX_VALUE)));

		NumberFilterValue value = NumberFilterValue.create("42.01");
		assertEquals(42.01d, value.getNumber().doubleValue());
	}

	@Test
	public void testNumberRangeFilterValue() {
		assertNotNull(NumberRangeFilterValue.create("42" + RANGE_SEPERATOR + "21"));
		assertNotNull(NumberRangeFilterValue.create("1" + RANGE_SEPERATOR + "1"));
	}

	@Test
	public void testCreationViaFilterValue() {
		assertEquals(NumberFilterValue.class, FilterValue.create("42.0").getClass());
		assertEquals(StringFilterValue.class, FilterValue.create("helloWorld").getClass());

		assertEquals(NumberRangeFilterValue.class, FilterValue.createRange("42.0" + RANGE_SEPERATOR + "21").getClass());
		assertEquals(DateRangeFilterValue.class, FilterValue.createRange("12:24" + RANGE_SEPERATOR + "21:16").getClass());
	}
}
