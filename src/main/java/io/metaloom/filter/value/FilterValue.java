package io.metaloom.filter.value;

public interface FilterValue {

	static FilterValue valueOf(String val) {
		return new StringFilterValue(val);
	}

}
