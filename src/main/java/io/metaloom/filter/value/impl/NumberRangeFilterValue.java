package io.metaloom.filter.value.impl;

import java.text.NumberFormat;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.RangeFilterValue;

public class NumberRangeFilterValue implements RangeFilterValue {

	private final Number from;
	private final Number to;
	private static final NumberFormat FORMAT = NumberFormat.getInstance();

	public NumberRangeFilterValue(Number from, Number to) {
		this.from = from;
		this.to = to;
	}

	public Number getFrom() {
		return from;
	}

	public Number getTo() {
		return to;
	}

	@Override
	public String toString() {
		return from.toString() + RANGE_SEPERATOR + to.toString();
	}

	public static NumberRangeFilterValue create(String val) {
		String[] parts = val.split(RANGE_SEPERATOR);
		if (parts.length != 2) {
			throw new FilterException("The value " + val + " could did not contain two values with a colon seperator.");
		}
		try {
			Number from = FORMAT.parse(parts[0]);
			Number to = FORMAT.parse(parts[1]);
			return new NumberRangeFilterValue(from, to);
		} catch (Exception e) {
			throw new FilterException("Failed to parse " + val + " into number range", e);
		}
	}

}
