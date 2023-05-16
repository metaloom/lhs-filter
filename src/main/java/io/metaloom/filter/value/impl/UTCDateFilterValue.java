package io.metaloom.filter.value.impl;

import java.time.Instant;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.TemporalFilterValue;

public class UTCDateFilterValue implements TemporalFilterValue {

	private Instant instant;

	public UTCDateFilterValue(Instant instant) {
		this.instant = instant;
	}

	public Instant getInstant() {
		return instant;
	}

	public static UTCDateFilterValue create(String val) {
		try {
			Instant instant = Instant.parse(val);
			return new UTCDateFilterValue(instant);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a ISO8601 UTC time", e);
		}
	}

}
