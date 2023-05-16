package io.metaloom.filter.key.impl;

import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.NumberFilterValue;

public class NumberFilterKey extends AbstractFilterKey<NumberFilterValue> {

	public NumberFilterKey(String key) {
		super(key);
	}

	@Override
	public NumberFilterValue createValue(String valueStr) {
		return NumberFilterValue.create(valueStr);
	}

}
