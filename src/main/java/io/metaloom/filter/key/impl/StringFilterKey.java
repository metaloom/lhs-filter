package io.metaloom.filter.key.impl;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.operation.FilterOperation;
import io.metaloom.filter.value.impl.StringFilterValue;

public class StringFilterKey extends AbstractFilterKey<StringFilterValue> {

	public StringFilterKey(String key) {
		super(key);
	}

	@Override
	public StringFilterValue createValue(FilterOperation range, String valueStr) {
		return StringFilterValue.create(valueStr);
	}

	public EqualsFilter<StringFilterValue> eq(String value) {
		return new EqualsFilter<>(this, new StringFilterValue(value));
	}

}