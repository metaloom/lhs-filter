package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.operation.FilterOperation;
import io.metaloom.filter.value.TemporalFilterValue;

public class AfterFilter<T extends TemporalFilterValue> extends AbstractFilter<T> {

	public AfterFilter(FilterKey<T> key, T value) {
		super(key, value);
	}

	@Override
	public FilterOperation getOperationKey() {
		return () -> "after";
	}

}
