package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;

public class LesserFilterTest extends AbstractFilterTest {

	@Test
	public void testDurationFilter() {
		LesserFilter<DurationFilterValue> filter = TestFilterKey.VIDEO_DURATION.getKey().lte(Duration.of(10, ChronoUnit.MINUTES));
		assertEquals(10, filter.value().getDuration().toMinutes());

		LesserFilter<DurationFilterValue> parsedFilter = assertParsedFilter("duration[lte]=PT10M", filter);
		assertEquals(10, parsedFilter.value().getDuration().toMinutes());
	}

	@Test
	public void testNumberFilter() {
		LesserFilter<NumberFilterValue> filter = TestFilterKey.FILE_SIZE.getKey().lte(42);
		assertEquals(42, filter.value().getNumber());

		LesserFilter<NumberFilterValue> parsedFilter = assertParsedFilter("size[lte]=42", filter);
		assertEquals(42, parsedFilter.value().getNumber().longValue());
	}

}
