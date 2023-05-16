package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.RangeFilterValue;

public class RangeFilter<T extends RangeFilterValue> extends AbstractFilter<T> {

	public static final String OPERATION_KEY = "range";

	public RangeFilter(FilterKey key, T value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
