package io.metaloom.filter.key.impl;

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

}
