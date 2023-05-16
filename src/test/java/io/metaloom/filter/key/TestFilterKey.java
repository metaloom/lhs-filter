package io.metaloom.filter.key;

import io.metaloom.filter.FilterKey;
import io.metaloom.filter.key.impl.DurationFilterKey;
import io.metaloom.filter.key.impl.NumberFilterKey;
import io.metaloom.filter.key.impl.SizeFilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;
import io.metaloom.filter.value.FilterValue;

public enum TestFilterKey {

	USER_USERNAME(new StringFilterKey("username")),

	ARTICLE_PRICE(new NumberFilterKey("price")),

	FILE_SIZE(new SizeFilterKey("size")),

	VIDEO_DURATION(new DurationFilterKey("duration"));

	private FilterKey<?> key;

	<T extends FilterValue> TestFilterKey(FilterKey<?> key) {
		this.key = key;
	}

	public FilterKey<?> getKey() {
		return key;
	}

	public static FilterKey<?> fromKey(String key) {
		for (TestFilterKey v : values()) {
			if (v.getKey().key().equals(key)) {
				return v.getKey();
			}
		}
		return null;
	}

}
