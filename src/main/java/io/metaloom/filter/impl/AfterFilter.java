package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class AfterFilter extends AbstractFilter {

	public static final String OPERATION_KEY = "after";

	public AfterFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return OPERATION_KEY;
	}

}
