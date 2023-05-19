package io.metaloom.filter;

import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilter implements Filter {

	private FilterKey key;
	private FilterValue value;

	public AbstractFilter(FilterKey key, FilterValue value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		// LHS brackets format
		return key.key() + "[" + getOperationKey() + "]=" + value();
	}

	@Override
	public FilterKey filterKey() {
		return key;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends FilterValue> T value() {
		return (T) value;
	}

	@Override
	public Object invoke() {
		return key.invoke(this);
	}

}
