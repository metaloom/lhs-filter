package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class GreaterFilter extends AbstractFilter {

	public static final String KEY = "gte";

	public GreaterFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return KEY;
	}

	public static GreaterFilter parse(FilterKey filterKey, String op, String val) {
		FilterValue filterVal = filterKey.createValue(op, val);
		return new GreaterFilter(filterKey, filterVal);
	}

}
