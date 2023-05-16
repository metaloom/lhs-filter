package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.TemporalFilterValue;

public class BeforeFilter extends AbstractFilter<TemporalFilterValue> {

	public static final String OPERATION_KEY = "before";

	public BeforeFilter(FilterKey key, TemporalFilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
