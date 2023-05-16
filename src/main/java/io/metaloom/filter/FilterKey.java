package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public interface FilterKey<T extends FilterValue> {

	String key();

	T createValue(String valueStr);

}
