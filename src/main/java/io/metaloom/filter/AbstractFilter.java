package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilter implements Filter {

	private FilterKey key;
	private FilterValue value;
	private String operation;

	public AbstractFilter(FilterKey key, String operation, FilterValue value) {
		this.key = key;
		this.value = value;
		this.operation = operation;
	}

	@Override
	public String toString() {
		// LHS brackets format
		return key.id() + "[" + getOperationKey() + "]=" + value();
	}

	@Override
	public FilterKey filterKey() {
		return key;
	}

	@Override
	public String getOperationKey() {
		return operation;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends FilterValue> T value() {
		return (T) value;
	}
}
