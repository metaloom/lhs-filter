package io.metaloom.filter.key.impl;

import java.time.Duration;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.range.DurationRangeFilterValue;

public class DurationFilterKey extends AbstractFilterKey {

	public DurationFilterKey(String key) {
		super(key);
	}

	@Override
	public DurationFilterValue createValue(String op, String valueStr) {
		return DurationFilterValue.create(valueStr);
	}

	public EqualsFilter eq(Duration dur) {
		return new EqualsFilter(this, new DurationFilterValue(dur));
	}

	public GreaterFilter gte(Duration dur) {
		return new GreaterFilter(this, new DurationFilterValue(dur));
	}

	public LesserFilter lte(Duration dur) {
		return new LesserFilter(this, new DurationFilterValue(dur));
	}

	public RangeFilter range(Duration from, Duration to) {
		return new RangeFilter(this, new DurationRangeFilterValue(from, to));
	}

}
