package io.metaloom.filter.value;

public class NumberRangeFilterValue implements FilterValue {

	private final Number from;
	private final Number to;

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
		return from.toString() + ":" + to.toString();
	}

}
