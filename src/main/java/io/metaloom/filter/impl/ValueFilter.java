package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class ValueFilter extends AbstractFilter {

	public ValueFilter(FilterKey key, String operation, FilterValue value) {
		super(key, operation, value);
	}

	public static ValueFilter parse(FilterKey key, String op, String val) {
		FilterValue filterVal = key.createValue(op, val);
		return new ValueFilter(key, op, filterVal);
	}
}
