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

	@Override
	public String toString() {
		String valueLine = ConvertUtils.toHumanSize(getNumber().longValue());
		return valueLine.replaceAll("\s", "");
	}

	public static SizeFilterValue create(String val) {
		return new SizeFilterValue(val);
	}

}
