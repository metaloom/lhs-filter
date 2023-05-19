package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public interface Filter {

	FilterKey filterKey();

	<T extends FilterValue> T value();

	String getOperationKey();

	<K> K invoke();

}
