package io.metaloom.filter.value.impl;

import java.time.Duration;

import io.metaloom.filter.value.NumericFilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

public class DurationFilterValue implements TemporalFilterValue, NumericFilterValue {

	private Duration duration;

	public DurationFilterValue(Duration duration) {
		this.duration = duration;
	}

	/**
	 * Create a duration filter value using the provided string. The value must be a formatted ISO8601 duration. For example, "P3Y6M4DT12H30M5S" represents a
	 * duration of "three years, six months, four days, twelve hours, thirty minutes, and five seconds".
	 * 
	 * @param iso8601Duration
	 * @return
	 */
	public static DurationFilterValue create(String iso8601Duration) {
		Duration dur = Duration.parse(iso8601Duration);
		return new DurationFilterValue(dur);
	}

	public Duration getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		if (duration == null) {
			return null;
		} else {
			return duration.toString();
		}
	}
}
