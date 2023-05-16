package io.metaloom.filter.value.impl;

import java.time.LocalDate;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.TemporalFilterValue;

public class DateFilterValue implements TemporalFilterValue {

	private LocalDate date;

	public DateFilterValue(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public static DateFilterValue create(String val) {
		try {
			LocalDate date = LocalDate.parse(val);
			return new DateFilterValue(date);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a date", e);
		}
	}

}
