package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilter<T extends FilterValue> implements Filter<T> {

	private FilterKey<T> key;
	private T value;

	public AbstractFilter(FilterKey<T> key,  T value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		// LHS brackets format
		return key.key() + "[" + getOperationKey().id() + "]=" + value();
	}

	@Override
	public FilterKey<T> filterKey() {
		return key;
	}

	@Override
	public T value() {
		return value;
	}

}
