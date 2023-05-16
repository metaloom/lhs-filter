package io.metaloom.filter.key.impl;

import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.StringFilterValue;

public class StringFilterKey extends AbstractFilterKey<StringFilterValue> {

	public StringFilterKey(String key) {
		super(key);
	}

	@Override
	public StringFilterValue createValue(String valueStr) {
		return StringFilterValue.create(valueStr);
	}

}