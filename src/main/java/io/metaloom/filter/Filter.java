package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public interface Filter {

	FilterKey filterKey();

	<T extends FilterValue> T value();

	default <T extends FilterValue> String valueStr() {
		T value = value();
		if (value == null) {
			return null;
		}
		return value.toString();
	}

	String getOperationKey();

}
