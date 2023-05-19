package io.metaloom.filter.action;

import io.metaloom.filter.Filter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

@FunctionalInterface
public interface FilterAction<K extends FilterKey, V extends FilterValue> {

	Object invoke(K key, Filter filter, V value);

}
