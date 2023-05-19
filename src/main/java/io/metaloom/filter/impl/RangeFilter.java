package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.Operation;
import io.metaloom.filter.value.FilterValue;

public class RangeFilter extends AbstractFilter {

	public RangeFilter(FilterKey key, FilterValue value) {
		super(key, Operation.RANGE, value);
	}

	public static RangeFilter parse(FilterKey filterKey, String op, String val) {
		FilterValue filterVal = filterKey.createValue(op, val);
		return new RangeFilter(filterKey, filterVal);
	}

}
