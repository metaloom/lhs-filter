package io.metaloom.filter;

import java.time.Duration;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.NumberRangeFilterValue;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;

public interface FilterKey {

	String key();

	// Equals

	default EqualsFilter<StringFilterValue> eq(String value) {
		return new EqualsFilter<>(this, new StringFilterValue(value));
	}

	// Range

	default RangeFilter<NumberRangeFilterValue> range(double from, double to) {
		return new RangeFilter<>(this, new NumberRangeFilterValue(from, to));
	}

	// Greater

	default GreaterFilter<SizeFilterValue> gte(String value) {
		return new GreaterFilter<>(this, new SizeFilterValue(value));
	}

	default GreaterFilter<NumberFilterValue> gte(Number number) {
		return new GreaterFilter<>(this, new NumberFilterValue(number));
	}

	default GreaterFilter<DurationFilterValue> gte(Duration dur) {
		return new GreaterFilter<>(this, new DurationFilterValue(dur));
	}

	// Lesss

	default LesserFilter<SizeFilterValue> lte(String value) {
		return new LesserFilter<>(this, new SizeFilterValue(value));
	}

	default LesserFilter<NumberFilterValue> lte(Number number) {
		return new LesserFilter<>(this, new NumberFilterValue(number));
	}

	default LesserFilter<DurationFilterValue> lte(Duration dur) {
		return new LesserFilter<>(this, new DurationFilterValue(dur));
	}

}
