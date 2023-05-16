package io.metaloom.filter;

import java.time.Duration;

import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.value.FilterValue;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;

public enum TestFilterKey implements FilterKey {

	USER_USERNAME("username", StringFilterValue.class),

	ARTICLE_PRICE("price", NumberFilterValue.class),

	FILE_SIZE("size", SizeFilterValue.class),

	VIDEO_DURATION("duration", DurationFilterValue.class);

	private final String key;
	private final Class<? extends FilterValue> clazz;

	<T extends FilterValue> TestFilterKey(String key, Class<T> clazz) {
		this.key = key;
		this.clazz = clazz;
	}

	@Override
	public String key() {
		return key;
	}

	static FilterKey fromKey(String key) {
		for (FilterKey v : values()) {
			if (v.key().equals(key)) {
				return v;
			}
		}
		return null;
	}

	

}
