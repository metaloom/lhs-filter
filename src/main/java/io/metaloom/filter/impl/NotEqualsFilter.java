package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class NotEqualsFilter extends AbstractFilter {

	public static final String KEY = "ne";

	public NotEqualsFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return KEY;
	}

	public static NotEqualsFilter parse(FilterKey key, String op, String val) {
		FilterValue filterVal = key.createValue(op, val);
		return new NotEqualsFilter(key, filterVal);
	}
}
