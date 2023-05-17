package io.metaloom.filter.value.impl.time;

import java.time.LocalDate;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.NumericFilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

public class LocalDateFilterValue implements TemporalFilterValue, NumericFilterValue {

	private LocalDate date;

	public LocalDateFilterValue(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return getDate().toString();
	}

	public static LocalDateFilterValue create(String val) {
		try {
			LocalDate date = LocalDate.parse(val);
			return new LocalDateFilterValue(date);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a date", e);
		}
	}

}
