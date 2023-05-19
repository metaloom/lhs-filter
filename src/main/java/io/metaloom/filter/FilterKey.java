package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public interface FilterKey {

	String key();

	FilterValue createValue(String operation, String value);

	Object invoke(Filter filter);

}
