package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public interface FilterKey {

	String id();

	FilterValue createValue(String operation, String value);

}
