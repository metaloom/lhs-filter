package io.metaloom.filter.key.impl;

import java.time.LocalTime;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;

public class LocalTimeFilterKey extends AbstractFilterKey {

	public LocalTimeFilterKey(String key) {
		super(key);
	}

	@Override
	public LocalTimeFilterValue createValue(String op, String valueStr) {
		return LocalTimeFilterValue.create(valueStr);
	}

	public EqualsFilter eq(LocalTime time) {
		return new EqualsFilter(this, new LocalTimeFilterValue(time));
	}

	public GreaterFilter gte(LocalTime time) {
		return new GreaterFilter(this, new LocalTimeFilterValue(time));
	}

	public LesserFilter lte(LocalTime time) {
		return new LesserFilter(this, new LocalTimeFilterValue(time));
	}

	public AfterFilter after(LocalTime time) {
		return new AfterFilter(this, new LocalTimeFilterValue(time));
	}

	public BeforeFilter before(LocalTime date) {
		return new BeforeFilter(this, new LocalTimeFilterValue(date));
	}

}
