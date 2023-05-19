package io.metaloom.filter.key.impl;

import static io.metaloom.filter.Operation.AFTER;
import static io.metaloom.filter.Operation.BEFORE;
import static io.metaloom.filter.Operation.EQUALS;
import static io.metaloom.filter.Operation.GREATER;
import static io.metaloom.filter.Operation.LESSER;
import static io.metaloom.filter.Operation.NOT_EQUALS;

import java.time.LocalDateTime;

import io.metaloom.filter.action.FilterAction;
import io.metaloom.filter.impl.ValueFilter;
import io.metaloom.filter.key.AbstractFilterKey;
import io.metaloom.filter.value.TemporalFilterValue;
import io.metaloom.filter.value.impl.time.LocalDateTimeFilterValue;

public class LocalDateTimeFilterKey extends AbstractFilterKey<LocalDateTimeFilterKey, TemporalFilterValue> {

	public LocalDateTimeFilterKey(String key) {
		super(key);
	}

	public LocalDateTimeFilterKey(String key, FilterAction<LocalDateTimeFilterKey, TemporalFilterValue> action) {
		super(key, action);
	}

	@Override
	public LocalDateTimeFilterValue createValue(String op, String valueStr) {
		return LocalDateTimeFilterValue.create(valueStr);
	}

	public ValueFilter eq(LocalDateTime date) {
		return new ValueFilter(this, EQUALS, new LocalDateTimeFilterValue(date));
	}

	public ValueFilter ne(LocalDateTime date) {
		return new ValueFilter(this, NOT_EQUALS, new LocalDateTimeFilterValue(date));
	}

	public ValueFilter gte(LocalDateTime date) {
		return new ValueFilter(this, GREATER, new LocalDateTimeFilterValue(date));
	}

	public ValueFilter lte(LocalDateTime date) {
		return new ValueFilter(this, LESSER, new LocalDateTimeFilterValue(date));
	}

	public ValueFilter after(LocalDateTime date) {
		return new ValueFilter(this, AFTER, new LocalDateTimeFilterValue(date));
	}

	public ValueFilter before(LocalDateTime date) {
		return new ValueFilter(this, BEFORE, new LocalDateTimeFilterValue(date));
	}

	@Override
	protected LocalDateTimeFilterKey self() {
		return this;
	}
}
