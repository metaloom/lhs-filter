package io.metaloom.filter.key;

import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilterKey<T extends FilterValue> implements FilterKey<T> {

	private String key;

	public AbstractFilterKey(String key) {
		this.key = key;
	}

	@Override
	public String key() {
		return key;
	}

}
