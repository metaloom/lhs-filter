package io.metaloom.filter.key.impl;

import java.time.LocalDate;

import io.metaloom.filter.action.FilterAction;
import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.NotEqualsFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.TemporalFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateFilterValue;

public class LocalDateFilterKey extends AbstractFilterKey<LocalDateFilterKey, TemporalFilterValue> {

	public LocalDateFilterKey(String key) {
		super(key);
	}

	public LocalDateFilterKey(String key, FilterAction<LocalDateFilterKey, TemporalFilterValue> action) {
		super(key, action);
	}

	@Override
	public LocalDateFilterValue createValue(String op, String valueStr) {
		return LocalDateFilterValue.create(valueStr);
	}

	public EqualsFilter eq(LocalDate date) {
		return new EqualsFilter(this, new LocalDateFilterValue(date));
	}

	public NotEqualsFilter ne(LocalDate date) {
		return new NotEqualsFilter(this, new LocalDateFilterValue(date));
	}

	public GreaterFilter gte(LocalDate date) {
		return new GreaterFilter(this, new LocalDateFilterValue(date));
	}

	public LesserFilter lte(LocalDate date) {
		return new LesserFilter(this, new LocalDateFilterValue(date));
	}

	public AfterFilter after(LocalDate date) {
		return new AfterFilter(this, new LocalDateFilterValue(date));
	}

	public BeforeFilter before(LocalDate date) {
		return new BeforeFilter(this, new LocalDateFilterValue(date));
	}

	@Override
	protected LocalDateFilterKey self() {
		return this;
	}
}
