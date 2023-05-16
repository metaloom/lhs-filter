package io.metaloom.filter.value.impl;

import java.time.LocalTime;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.TemporalFilterValue;

public class TimeFilterValue implements TemporalFilterValue {

	private LocalTime time;

	public TimeFilterValue(LocalTime time) {
		this.time = time;
	}

	public LocalTime getTime() {
		return time;
	}

	public static TimeFilterValue create(String val) {
		try {
			LocalTime time = LocalTime.parse(val);
			return new TimeFilterValue(time);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a time.", e);
		}
	}

}
