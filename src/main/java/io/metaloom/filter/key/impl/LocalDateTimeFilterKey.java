package io.metaloom.filter.key.impl;

import java.time.LocalDateTime;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.operation.FilterOperation;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;

public class LocalDateTimeFilterKey extends AbstractFilterKey<LocalDateTimeFilterValue> {

	public LocalDateTimeFilterKey(String key) {
		super(key);
	}

	@Override
	public LocalDateTimeFilterValue createValue(FilterOperation op, String valueStr) {
		return LocalDateTimeFilterValue.create(valueStr);
	}

	public EqualsFilter<LocalDateTimeFilterValue> eq(LocalDateTime date) {
		return new EqualsFilter<>(this, new LocalDateTimeFilterValue(date));
	}

	public GreaterFilter<LocalDateTimeFilterValue> gte(LocalDateTime date) {
		return new GreaterFilter<>(this, new LocalDateTimeFilterValue(date));
	}

	public LesserFilter<LocalDateTimeFilterValue> lte(LocalDateTime date) {
		return new LesserFilter<>(this, new LocalDateTimeFilterValue(date));
	}

	public AfterFilter<LocalDateTimeFilterValue> after(LocalDateTime date) {
		return new AfterFilter<>(this, new LocalDateTimeFilterValue(date));
	}

	public BeforeFilter<LocalDateTimeFilterValue> before(LocalDateTime date) {
		return new BeforeFilter<>(this, new LocalDateTimeFilterValue(date));
	}
}
