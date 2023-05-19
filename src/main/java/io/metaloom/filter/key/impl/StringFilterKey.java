package io.metaloom.filter.key.impl;

import io.metaloom.filter.action.FilterAction;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.NotEqualsFilter;
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

	public EqualsFilter eq(String value) {
		return new EqualsFilter(this, new StringFilterValue(value));
	}

	public NotEqualsFilter ne(String value) {
		return new NotEqualsFilter(this, new StringFilterValue(value));
	}

	@Override
	protected StringFilterKey self() {
		return this;
	}

}