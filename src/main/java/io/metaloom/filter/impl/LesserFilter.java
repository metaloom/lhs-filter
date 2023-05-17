package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.operation.FilterOperation;
import io.metaloom.filter.value.NumericFilterValue;

public class LesserFilter<T extends NumericFilterValue> extends AbstractFilter<T> {

	public LesserFilter(FilterKey<T> key, T value) {
		super(key, value);
	}

	@Override
	public FilterOperation getOperationKey() {
		return () -> "lte";
	}

}
