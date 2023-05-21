package io.metaloom.filter.key.impl;

import java.time.Duration;

import io.metaloom.filter.Operation;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.range.DurationRangeFilterValue;

public class DurationFilterKey extends AbstractFilterKey<DurationFilterKey, DurationRangeFilterValue> {

	public DurationFilterKey(String key) {
		super(key);
	}

	@Override
	public DurationFilterValue createValue(String op, String valueStr) {
		return DurationFilterValue.create(valueStr);
	}

	public ValueFilter eq(Duration dur) {
		return new ValueFilter(this, Operation.EQUALS, new DurationFilterValue(dur));
	}

	public ValueFilter ne(Duration dur) {
		return new ValueFilter(this, Operation.NOT_EQUALS, new DurationFilterValue(dur));
	}

	public ValueFilter gte(Duration dur) {
		return new ValueFilter(this, Operation.GREATER, new DurationFilterValue(dur));
	}

	public ValueFilter lte(Duration dur) {
		return new ValueFilter(this, Operation.GREATER, new DurationFilterValue(dur));
	}

	public RangeFilter range(Duration from, Duration to) {
		return new RangeFilter(this, new DurationRangeFilterValue(from, to));
	}

	@Override
	protected DurationFilterKey self() {
		return this;
	}
}
