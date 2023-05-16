package io.metaloom.filter.key.impl;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.SizeFilterValue;

public class SizeFilterKey extends AbstractFilterKey<SizeFilterValue> {

	public SizeFilterKey(String key) {
		super(key);
	}

	@Override
	public SizeFilterValue createValue(String valueStr) {
		return SizeFilterValue.create(valueStr);
	}

	public EqualsFilter<SizeFilterValue> eq(String value) {
		return new EqualsFilter<>(this, new SizeFilterValue(value));
	}

	public GreaterFilter<SizeFilterValue> gte(String value) {
		return new GreaterFilter<>(this, new SizeFilterValue(value));
	}

	public LesserFilter<SizeFilterValue> lte(String value) {
		return new LesserFilter<>(this, new SizeFilterValue(value));
	}

}
