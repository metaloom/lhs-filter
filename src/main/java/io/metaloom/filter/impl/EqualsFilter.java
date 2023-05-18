package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class EqualsFilter extends AbstractFilter {

	public EqualsFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return "eq";
	}

	public static EqualsFilter parse(FilterKey key, String op, String val) {
		FilterValue filterVal = key.createValue(op, val);
		return new EqualsFilter(key, filterVal);
	}


}
