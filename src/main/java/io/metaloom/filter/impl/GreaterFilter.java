package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.NumericFilterValue;

public class GreaterFilter<T extends NumericFilterValue> extends AbstractFilter<T> {

	public static final String OPERATION_KEY = "gte";

	public GreaterFilter(FilterKey<T> key, T value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
