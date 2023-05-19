package io.metaloom.filter.key.impl;

import io.metaloom.filter.Operation;
import io.metaloom.filter.action.FilterAction;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.StringFilterValue;

public class StringFilterKey extends AbstractFilterKey<StringFilterKey, StringFilterValue> {

	public StringFilterKey(String key) {
		super(key);
	}

	public StringFilterKey(String key, FilterAction<StringFilterKey, StringFilterValue> action) {
		super(key, action);
	}

	@Override
	public StringFilterValue createValue(String range, String valueStr) {
		return StringFilterValue.create(valueStr);
	}

	public ValueFilter eq(String value) {
		return new ValueFilter(this, Operation.EQUALS, new StringFilterValue(value));
	}

	public ValueFilter ne(String value) {
		return new ValueFilter(this, Operation.NOT_EQUALS, new StringFilterValue(value));
	}

	@Override
	protected StringFilterKey self() {
		return this;
	}

}