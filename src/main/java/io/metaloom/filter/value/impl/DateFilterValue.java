package io.metaloom.filter.value.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.TemporalFilterValue;

public class DateFilterValue implements TemporalFilterValue {

	private Instant instant;

	private LocalDateTime dateTime;
	private LocalDate date;
	private LocalTime time;

	public DateFilterValue(Instant instant) {
		this.instant = instant;
	}

	public DateFilterValue(LocalTime time) {
		this.time = time;
	}

	public DateFilterValue(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public DateFilterValue(LocalDate date) {
		this.date = date;
	}

	public Instant getInstant() {
		return instant;
	}

	public LocalDate getDate() {
		return date;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public LocalTime getTime() {
		return time;
	}

	public static DateFilterValue create(String val) {
		try {
			LocalDate date = LocalDate.parse(val);
			return new DateFilterValue(date);
		} catch (Exception e) {

		}
		try {
			LocalTime time = LocalTime.parse(val);
			return new DateFilterValue(time);
		} catch (Exception e) {

		}
		try {
			LocalDateTime dateTime = LocalDateTime.parse(val);
			return new DateFilterValue(dateTime);
		} catch (Exception e) {

		}
		try {
			Instant instant = Instant.parse(val);
			return new DateFilterValue(instant);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a time, date, date+time or ISO8601 UTC", e);
		}
	}

}
