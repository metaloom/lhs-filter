package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class RangeFilter extends AbstractFilter {

	public static final String KEY = "range";

	public RangeFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return KEY;
	}

	public static RangeFilter parse(FilterKey filterKey, String op, String val) {
		FilterValue filterVal = filterKey.createValue(op, val);
		return new RangeFilter(filterKey, filterVal);
	}

}
