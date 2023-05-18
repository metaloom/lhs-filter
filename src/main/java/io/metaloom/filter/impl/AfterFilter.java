package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

public class AfterFilter extends AbstractFilter {

	public AfterFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return "after";
	}
	
	public static AfterFilter parse(FilterKey filterKey, String op, String val) {
		TemporalFilterValue tempValue = FilterValue.createTemporal(val);
		return new AfterFilter(filterKey, tempValue);
	}

}
