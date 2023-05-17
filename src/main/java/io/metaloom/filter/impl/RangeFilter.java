package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.operation.FilterOperation;
import io.metaloom.filter.value.RangeFilterValue;

public class RangeFilter<T extends RangeFilterValue> extends AbstractFilter<T> {

	public RangeFilter(FilterKey<T> key, T value) {
		super(key, value);
	}

	@Override
	public FilterOperation getOperationKey() {
		return () -> "range";
	}

}
