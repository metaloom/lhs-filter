package io.metaloom.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.value.FilterValue;
import io.metaloom.filter.value.NumericFilterValue;
import io.metaloom.filter.value.RangeFilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

public interface Filter<T extends FilterValue> {

	static List<Filter<FilterValue>> parse(String line, Function<String, FilterKey<?>> keyMapper) {
		Stream<String> lines = Arrays.stream(line.split(","));
		return lines.map(filterLine -> parseFilterLine(filterLine, keyMapper)).collect(Collectors.toList());
	}

	private static Filter<FilterValue> parseFilterLine(String line, Function<String, FilterKey<?>> keyMapper) {
		String key = line.substring(0, line.indexOf("["));
		String op = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
		String val = line.substring(line.indexOf("=") + 1);
		FilterKey<?> filterKey = keyMapper.apply(key);
		FilterValue filterVal = filterKey.createValue(val);
		switch (op) {
		case EqualsFilter.OPERATION_KEY:
			return new EqualsFilter(filterKey, filterVal);
		case AfterFilter.OPERATION_KEY:
			TemporalFilterValue tempValue = FilterValue.createTemporal(val);
			return new AfterFilter(filterKey, tempValue);
		case BeforeFilter.OPERATION_KEY:
			return new BeforeFilter(filterKey, (TemporalFilterValue) filterVal);
		case RangeFilter.OPERATION_KEY:
			return new RangeFilter(filterKey, (RangeFilterValue) filterVal);
		case LesserFilter.OPERATION_KEY:
			return new LesserFilter(filterKey, (NumericFilterValue) filterVal);
		case GreaterFilter.OPERATION_KEY:
			return new GreaterFilter(filterKey, (NumericFilterValue) filterVal);
		default:
			throw new FilterException("Unknown filter operation: " + op);
		}
	}

	FilterKey<?> filterKey();

	T value();

	String getOperationKey();

}
