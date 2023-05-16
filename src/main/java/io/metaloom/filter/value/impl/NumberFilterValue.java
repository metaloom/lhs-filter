package io.metaloom.filter.value.impl;

import java.text.NumberFormat;
import java.text.ParseException;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.NumericFilterValue;

public class NumberFilterValue implements NumericFilterValue {

	private Number number;

	public NumberFilterValue(Number number) {
		this.number = number;
	}

	public Number getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return number.toString();
	}

	public static NumberFilterValue create(String val) {
		Number number;
		try {
			number = NumberFormat.getInstance().parse(val);
			return new NumberFilterValue(number);
		} catch (ParseException e) {
			throw new FilterException("Failed to parse value " + val + " into number.", e);
		}
	}
}
