package io.metaloom.filter.key.impl;

import static io.metaloom.filter.Operation.AFTER;
import static io.metaloom.filter.Operation.BEFORE;
import static io.metaloom.filter.Operation.EQUALS;
import static io.metaloom.filter.Operation.GREATER;
import static io.metaloom.filter.Operation.LESSER;
import static io.metaloom.filter.Operation.NOT_EQUALS;

import java.time.LocalTime;

import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.TemporalFilterValue;
import io.metaloom.filter.value.impl.time.LocalTimeFilterValue;

public class LocalTimeFilterKey extends AbstractFilterKey<LocalTimeFilterKey, TemporalFilterValue> {

	public LocalTimeFilterKey(String key) {
		super(key);
	}

	@Override
	public LocalTimeFilterValue createValue(String op, String valueStr) {
		return LocalTimeFilterValue.create(valueStr);
	}

	public ValueFilter eq(LocalTime time) {
		return new ValueFilter(this, EQUALS, new LocalTimeFilterValue(time));
	}

	public ValueFilter ne(LocalTime time) {
		return new ValueFilter(this, NOT_EQUALS, new LocalTimeFilterValue(time));
	}

	public ValueFilter gte(LocalTime time) {
		return new ValueFilter(this, GREATER, new LocalTimeFilterValue(time));
	}

	public ValueFilter lte(LocalTime time) {
		return new ValueFilter(this, LESSER, new LocalTimeFilterValue(time));
	}

	public ValueFilter after(LocalTime time) {
		return new ValueFilter(this, AFTER, new LocalTimeFilterValue(time));
	}

	public ValueFilter before(LocalTime date) {
		return new ValueFilter(this, BEFORE, new LocalTimeFilterValue(date));
	}

	@Override
	protected LocalTimeFilterKey self() {
		return this;
	}
}
