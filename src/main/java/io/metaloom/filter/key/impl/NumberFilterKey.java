package io.metaloom.filter.key.impl;

import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.NumberFilterValueVariant;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.range.NumberRangeFilterValue;

public class NumberFilterKey extends AbstractFilterKey {

	public NumberFilterKey(String key) {
		super(key);
	}

	@Override
	public NumberFilterValueVariant createValue(String op, String valueStr) {
		if (op.equals("range")) {
			return NumberRangeFilterValue.create(valueStr);
		}
		return NumberFilterValue.create(valueStr);
	}

	public EqualsFilter eq(Number number) {
		return new EqualsFilter(this, new NumberFilterValue(number));
	}

	public RangeFilter range(double from, double to) {
		return new RangeFilter(this, new NumberRangeFilterValue(from, to));
	}

	public LesserFilter lte(Number number) {
		return new LesserFilter(this, new NumberFilterValue(number));
	}

	public GreaterFilter gte(Number number) {
		return new GreaterFilter(this, new NumberFilterValue(number));
	}

}
