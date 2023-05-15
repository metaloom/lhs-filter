package io.metaloom.filter.value;

public class StringFilterValue implements FilterValue {

	private String val;

	public StringFilterValue(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return val.toString();
	}
}
