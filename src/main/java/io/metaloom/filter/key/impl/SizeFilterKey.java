package io.metaloom.filter.key.impl;

import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.SizeFilterValue;

public class SizeFilterKey extends AbstractFilterKey<SizeFilterValue> {

	public SizeFilterKey(String key) {
		super(key);
	}

	@Override
	public SizeFilterValue createValue(String valueStr) {
		return SizeFilterValue.create(valueStr);
	}

}
