package io.metaloom.filter.value.impl;

import io.metaloom.utils.ConvertUtils;

public class SizeFilterValue extends NumberFilterValue {

	public SizeFilterValue(String humanReadableSize) {
		super(ConvertUtils.fromHumanSize(humanReadableSize));
	}

	public Long getSizeInBytes() {
		Number number = getNumber();
		if (number == null) {
			return null;
		}
		return getNumber().longValue();
	}

	public static SizeFilterValue create(String val) {
		return new SizeFilterValue(val);
	}

}
