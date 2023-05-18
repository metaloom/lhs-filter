package io.metaloom.filter.impl;

import io.metaloom.filter.AbstractFilter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public class LesserFilter extends AbstractFilter {

	public LesserFilter(FilterKey key, FilterValue value) {
		super(key, value);
	}

	@Override
	public String getOperationKey() {
		return "lte";
	}

	public static LesserFilter parse(FilterKey filterKey, String op, String val) {
		FilterValue filterVal = filterKey.createValue(op, val);
		return new LesserFilter(filterKey, filterVal);
	}

}
