package io.metaloom.filter.key.impl;

import java.time.LocalDate;

import io.metaloom.filter.Operation;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.TemporalFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateFilterValue;

public class LocalDateFilterKey extends AbstractFilterKey<LocalDateFilterKey, TemporalFilterValue> {

	public LocalDateFilterKey(String key) {
		super(key);
	}

	@Override
	public LocalDateFilterValue createValue(String op, String valueStr) {
		return LocalDateFilterValue.create(valueStr);
	}

	public ValueFilter eq(LocalDate date) {
		return new ValueFilter(this, Operation.EQUALS, new LocalDateFilterValue(date));
	}

	public ValueFilter ne(LocalDate date) {
		return new ValueFilter(this, Operation.NOT_EQUALS, new LocalDateFilterValue(date));
	}

	public ValueFilter gte(LocalDate date) {
		return new ValueFilter(this, Operation.GREATER, new LocalDateFilterValue(date));
	}

	public ValueFilter lte(LocalDate date) {
		return new ValueFilter(this, Operation.LESSER, new LocalDateFilterValue(date));
	}

	public ValueFilter after(LocalDate date) {
		return new ValueFilter(this, Operation.AFTER, new LocalDateFilterValue(date));
	}

	public ValueFilter before(LocalDate date) {
		return new ValueFilter(this, Operation.BEFORE, new LocalDateFilterValue(date));
	}

	@Override
	protected LocalDateFilterKey self() {
		return this;
	}
}
