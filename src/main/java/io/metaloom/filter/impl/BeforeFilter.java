package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class BeforeFilter extends AbstractFilter {

	public BeforeFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return "before";
	}

	// TemporalFilterValue tempValue = FilterValue.createTemporal(val);
	

	public static BeforeFilter parse(FilterKey filterKey, String op, String val) {
		FilterValue filterVal = filterKey.createValue(op, val);
		return new BeforeFilter(filterKey, filterVal);
	}
}
