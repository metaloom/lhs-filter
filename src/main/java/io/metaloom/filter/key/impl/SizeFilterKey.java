package io.metaloom.filter.key.impl;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.SizeFilterValueVariant;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.range.SizeRangeFilterValue;

public class SizeFilterKey extends AbstractFilterKey {

	public SizeFilterKey(String key) {
		super(key);
	}

	@Override
	public SizeFilterValueVariant createValue(String op, String valueStr) {
		if (op.equals("range")) {
			return SizeRangeFilterValue.create(valueStr);
		}
		return SizeFilterValue.create(valueStr);
	}

	public EqualsFilter eq(String value) {
		return new EqualsFilter(this, new SizeFilterValue(value));
	}

	public GreaterFilter gte(String value) {
		return new GreaterFilter(this, new SizeFilterValue(value));
	}

	public LesserFilter lte(String value) {
		return new LesserFilter(this, new SizeFilterValue(value));
	}

	public RangeFilter range(String from, String to) {
		return new RangeFilter(this, new SizeRangeFilterValue(from, to));
	}

}
