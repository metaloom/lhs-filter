package io.metaloom.filter.key.impl;

import java.time.LocalDateTime;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;

public class LocalDateTimeFilterKey extends AbstractFilterKey {

	public LocalDateTimeFilterKey(String key) {
		super(key);
	}

	@Override
	public LocalDateTimeFilterValue createValue(String op, String valueStr) {
		return LocalDateTimeFilterValue.create(valueStr);
	}

	public EqualsFilter   eq(LocalDateTime date) {
		return new EqualsFilter(this, new LocalDateTimeFilterValue(date));
	}

	public GreaterFilter gte(LocalDateTime date) {
		return new GreaterFilter(this, new LocalDateTimeFilterValue(date));
	}

	public LesserFilter lte(LocalDateTime date) {
		return new LesserFilter(this, new LocalDateTimeFilterValue(date));
	}

	public AfterFilter after(LocalDateTime date) {
		return new AfterFilter(this, new LocalDateTimeFilterValue(date));
	}

	public BeforeFilter before(LocalDateTime date) {
		return new BeforeFilter(this, new LocalDateTimeFilterValue(date));
	}
}
