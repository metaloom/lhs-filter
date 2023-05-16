package io.metaloom.filter.value;

public class NumberFilterValue implements FilterValue {

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
}
