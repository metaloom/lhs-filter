package io.metaloom.filter.value.impl;

import java.time.LocalTime;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.NumericFilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

public class LocalTimeFilterValue implements TemporalFilterValue, NumericFilterValue {

	private LocalTime time;

	public LocalTimeFilterValue(LocalTime time) {
		this.time = time;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public String toString() {
		return getTime().toString();
	}

	public static LocalTimeFilterValue create(String val) {
		try {
			LocalTime time = LocalTime.parse(val);
			return new LocalTimeFilterValue(time);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a time.", e);
		}
	}

}
