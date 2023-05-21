package io.metaloom.filter;

import java.util.function.Function;

import io.metaloom.filter.value.FilterValue;

public interface Filter {

	FilterKey filterKey();

	<T extends FilterValue> T value();

	default <T extends FilterValue> String valueStr() {
		T value = value();
		if (value == null) {
			return null;
		}
		return value.toString();
	}

	String getOperationKey();

	default boolean matches(FilterKey filterKey, String operationKey) {
		if (filterKey != null && filterKey == filterKey() && operationKey.equals(getOperationKey())) {
			return true;
		}
		return false;
	}

	default <T, R extends FilterValue> T apply(Class<R> clazzOfT, Function<R, T> mapper) {
		if (value().getClass().isAssignableFrom(clazzOfT)) {
			return mapper.apply(value());
		} else {
			return null;
		}
	}

}
