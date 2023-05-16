package io.metaloom.filter.key.impl;

import java.time.Duration;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.DurationFilterValue;

public class DurationFilterKey extends AbstractFilterKey<DurationFilterValue> {

	public DurationFilterKey(String key) {
		super(key);
	}

	@Override
	public DurationFilterValue createValue(String valueStr) {
		return DurationFilterValue.create(valueStr);
	}

	
	public EqualsFilter<DurationFilterValue> eq(Duration dur) {
		return new EqualsFilter<>(this, new DurationFilterValue(dur));
	}

	public GreaterFilter<DurationFilterValue> gte(Duration dur) {
		return new GreaterFilter<>(this, new DurationFilterValue(dur));
	}

	public LesserFilter<DurationFilterValue> lte(Duration dur) {
		return new LesserFilter<>(this, new DurationFilterValue(dur));
	}
}
