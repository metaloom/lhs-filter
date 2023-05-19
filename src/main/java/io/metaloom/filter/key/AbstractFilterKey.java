package io.metaloom.filter.key;

import io.metaloom.filter.Filter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.action.FilterAction;

public abstract class AbstractFilterKey<K extends FilterKey> implements FilterKey {

	private String key;
	private FilterAction<K, ?> action;

	public AbstractFilterKey(String key) {
		this(key, null);
	}

	public AbstractFilterKey(String key, FilterAction<K, ?> action) {
		this.key = key;
		this.action = action;
	}

	@Override
	public <K> K invoke(Filter filter) {
		if (action != null) {
			return (K) action.invoke(self(), filter, filter.value());
		}
		return null;
	}

	@Override
	public String key() {
		return key;
	}

	abstract protected K self();

}
