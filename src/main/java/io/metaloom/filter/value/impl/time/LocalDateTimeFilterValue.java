package io.metaloom.filter.value.impl.time;

import java.time.LocalDateTime;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.NumericFilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

public class LocalDateTimeFilterValue implements TemporalFilterValue, NumericFilterValue {

	private LocalDateTime dateTime;

	public LocalDateTimeFilterValue(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	@Override
	public String toString() {
		return getDateTime().toString();
	}

	public static LocalDateTimeFilterValue create(String val) {
		try {
			LocalDateTime dateTime = LocalDateTime.parse(val);
			return new LocalDateTimeFilterValue(dateTime);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a time+time.", e);
		}
	}

}
