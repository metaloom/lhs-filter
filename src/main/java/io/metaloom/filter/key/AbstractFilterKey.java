package io.metaloom.filter.key;

import io.metaloom.filter.FilterKey;
import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilterKey<K extends FilterKey, V extends FilterValue> implements FilterKey {

	private String id;

	public AbstractFilterKey(String id) {
		this.id = id;
	}

	@Override
	public String id() {
		return id;
	}

	abstract protected K self();

}
