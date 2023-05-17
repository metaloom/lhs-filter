package io.metaloom.filter.value.impl.range;

import java.time.Duration;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.RangeFilterValue;

public class DurationRangeFilterValue implements RangeFilterValue {

	private final Duration from;
	private final Duration to;

	public DurationRangeFilterValue(Duration from, Duration to) {
		this.from = from;
		this.to = to;
	}

	public Duration getFrom() {
		return from;
	}

	public Duration getTo() {
		return to;
	}

	@Override
	public String toString() {
		return from.toString() + RANGE_SEPERATOR + to.toString();
	}

	public static DurationRangeFilterValue create(String val) {
		String[] parts = val.split(RANGE_SEPERATOR);
		if (parts.length != 2) {
			throw new FilterException("The value " + val + " could did not contain two values with a colon seperator.");
		}
		try {
			Duration from = Duration.parse(parts[0]);
			Duration to = Duration.parse(parts[1]);
			return new DurationRangeFilterValue(from, to);
		} catch (Exception e) {
			throw new FilterException("Failed to parse " + val + " into number range", e);
		}
	}
}
