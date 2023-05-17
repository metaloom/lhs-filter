package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.TemporalFilterValue;

public class BeforeFilter<T extends TemporalFilterValue> extends AbstractFilter<T> {

	public static final String OPERATION_KEY = "before";

	public BeforeFilter(FilterKey<T> key, T value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
