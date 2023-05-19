package io.metaloom.filter.key;

import io.metaloom.filter.Filter;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.action.FilterAction;
import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilterKey<K extends FilterKey, V extends FilterValue> implements FilterKey {

	private String key;
	private FilterAction<K, V> action;

	public AbstractFilterKey(String key) {
		this(key, null);
	}

	public AbstractFilterKey(String key, FilterAction<K, V> action) {
		this.key = key;
		this.action = action;
	}

	@Override
	public Object invoke(Filter filter) {
		if (action != null) {
			return action.invoke(self(), filter, filter.value());
		}
		return null;
	}

	@Override
	public String key() {
		return key;
	}

	abstract protected K self();

}
