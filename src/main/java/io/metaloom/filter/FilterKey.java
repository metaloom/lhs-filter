package io.metaloom.filter;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.value.StringFilterValue;

public interface FilterKey {

	String key();

	default Filter eq(String value) {
		return new EqualsFilter(this, new StringFilterValue(value));
	}
	

}
