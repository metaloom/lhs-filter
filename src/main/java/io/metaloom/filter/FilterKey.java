package io.metaloom.filter;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.value.NumberRangeFilterValue;
import io.metaloom.filter.value.StringFilterValue;

public interface FilterKey {

	String key();

	default EqualsFilter eq(String value) {
		return new EqualsFilter(this, new StringFilterValue(value));
	}

	default RangeFilter range(double from, double to) {
		return new RangeFilter(this, new NumberRangeFilterValue(from, to));
	}

}
