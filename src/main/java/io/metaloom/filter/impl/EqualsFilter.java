package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class EqualsFilter<T extends FilterValue> extends AbstractFilter<T> {

	public static final String OPERATION_KEY = "eq";

	public EqualsFilter(FilterKey<T> key, T value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
