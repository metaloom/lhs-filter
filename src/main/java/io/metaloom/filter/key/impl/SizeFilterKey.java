package io.metaloom.filter.key.impl;

import static io.metaloom.filter.operation.DefaultFilterOperation.RANGE;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.operation.DefaultFilterOperation;
import io.metaloom.filter.operation.FilterOperation;
import io.metaloom.filter.value.impl.SizeFilterValue;
import io.metaloom.filter.value.impl.range.SizeRangeFilterValue;

public class SizeFilterKey extends AbstractFilterKey<SizeFilterValue> {

	public SizeFilterKey(String key) {
		super(key);
	}

	@Override
	public SizeFilterValue createValue(FilterOperation op, String valueStr) {
		switch (op) {
		case RANGE:
			return SizeRangeFilterValue.create(valueStr);
		default:
			return SizeFilterValue.create(valueStr);
		}
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

	public RangeFilter<SizeRangeFilterValue> range(String from, String to) {
		return new RangeFilter(this, new SizeRangeFilterValue(from, to));
	}

}
