package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.NumericFilterValue;

public class LesserFilter<T extends NumericFilterValue> extends AbstractFilter<T> {

	public static final String OPERATION_KEY = "lte";

	public LesserFilter(FilterKey key, T value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
