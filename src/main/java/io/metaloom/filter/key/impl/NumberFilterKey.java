package io.metaloom.filter.key.impl;

import static io.metaloom.filter.Operation.EQUALS;
import static io.metaloom.filter.Operation.GREATER;
import static io.metaloom.filter.Operation.LESSER;
import static io.metaloom.filter.Operation.NOT_EQUALS;

import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.NumberFilterValueVariant;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.range.NumberRangeFilterValue;

public class NumberFilterKey extends AbstractFilterKey<NumberFilterKey, NumberFilterValueVariant> {

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

	public ValueFilter eq(Number number) {
		return new ValueFilter(this, EQUALS, new NumberFilterValue(number));
	}

	public ValueFilter ne(Number number) {
		return new ValueFilter(this, NOT_EQUALS, new NumberFilterValue(number));
	}

	public RangeFilter range(double from, double to) {
		return new RangeFilter(this, new NumberRangeFilterValue(from, to));
	}

	public ValueFilter lte(Number number) {
		return new ValueFilter(this, LESSER, new NumberFilterValue(number));
	}

	public ValueFilter gte(Number number) {
		return new ValueFilter(this, GREATER, new NumberFilterValue(number));
	}

	@Override
	protected NumberFilterKey self() {
		return this;
	}

}
