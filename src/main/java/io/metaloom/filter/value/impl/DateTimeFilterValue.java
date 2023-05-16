package io.metaloom.filter.value.impl;

import java.time.LocalDateTime;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.TemporalFilterValue;

public class DateTimeFilterValue implements TemporalFilterValue {

	private LocalDateTime dateTime;

	public DateTimeFilterValue(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public static DateTimeFilterValue create(String val) {
		try {
			LocalDateTime dateTime = LocalDateTime.parse(val);
			return new DateTimeFilterValue(dateTime);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a time+time.", e);
		}
	}

}
