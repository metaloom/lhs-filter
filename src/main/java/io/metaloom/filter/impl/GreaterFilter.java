package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.NumericFilterValue;

public class GreaterFilter extends AbstractFilter<NumericFilterValue> {

	public static final String OPERATION_KEY = "gte";

	public GreaterFilter(FilterKey key, NumericFilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
