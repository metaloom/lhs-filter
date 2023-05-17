package io.metaloom.filter.value.impl;

import io.metaloom.filter.value.FilterValue;

public class StringFilterValue implements FilterValue {

	private String val;

	public StringFilterValue(String val) {
		this.val = val;
	}

	public String getText() {
		return val;
	}

	@Override
	public String toString() {
		return val.toString();
	}

	public static StringFilterValue create(String val) {
		return new StringFilterValue(val);
	}
}
