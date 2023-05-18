package io.metaloom.filter.key;

import io.metaloom.filter.FilterKey;

public abstract class AbstractFilterKey implements FilterKey {

	private String key;

	public AbstractFilterKey(String key) {
		this.key = key;
	}

	@Override
	public String key() {
		return key;
	}

}
