package io.metaloom.filter.key.impl;

import static io.metaloom.filter.Operation.EQUALS;
import static io.metaloom.filter.Operation.GREATER;
import static io.metaloom.filter.Operation.LESSER;
import static io.metaloom.filter.Operation.NOT_EQUALS;

import io.metaloom.filter.action.FilterAction;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.SizeFilterValueVariant;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.range.SizeRangeFilterValue;

public class SizeFilterKey extends AbstractFilterKey<SizeFilterKey, SizeFilterValueVariant> {

	public SizeFilterKey(String key) {
		super(key);
	}

	public SizeFilterKey(String key, FilterAction<SizeFilterKey, SizeFilterValueVariant> action) {
		super(key, action);
	}

	@Override
	public SizeFilterValueVariant createValue(String op, String valueStr) {
		if (op.equals("range")) {
			return SizeRangeFilterValue.create(valueStr);
		}
		return SizeFilterValue.create(valueStr);
	}

	public ValueFilter eq(String value) {
		return new ValueFilter(this, EQUALS, new SizeFilterValue(value));
	}

	public ValueFilter ne(String value) {
		return new ValueFilter(this, NOT_EQUALS, new SizeFilterValue(value));
	}

	public ValueFilter gte(String value) {
		return new ValueFilter(this, GREATER, new SizeFilterValue(value));
	}

	public ValueFilter lte(String value) {
		return new ValueFilter(this, LESSER, new SizeFilterValue(value));
	}

	public RangeFilter range(String from, String to) {
		return new RangeFilter(this, new SizeRangeFilterValue(from, to));
	}

	@Override
	protected SizeFilterKey self() {
		return this;
	}
}
