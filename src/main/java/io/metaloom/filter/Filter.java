package io.metaloom.filter;

import static io.metaloom.filter.operation.DefaultFilterOperation.AFTER;
import static io.metaloom.filter.operation.DefaultFilterOperation.BEFORE;
import static io.metaloom.filter.operation.DefaultFilterOperation.EQUAL;
import static io.metaloom.filter.operation.DefaultFilterOperation.GREATER;
import static io.metaloom.filter.operation.DefaultFilterOperation.LESSER;
import static io.metaloom.filter.operation.DefaultFilterOperation.RANGE;

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
import io.metaloom.filter.operation.DefaultFilterOperation;
import io.metaloom.filter.operation.FilterOperation;
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
		String opStr = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
		String val = line.substring(line.indexOf("=") + 1);

		FilterKey<?> filterKey = keyMapper.apply(key);
		FilterOperation op = () -> opStr;
		FilterValue filterVal = filterKey.createValue(op, val);
		switch (opStr) {
		case "eq":
			return new EqualsFilter(filterKey, filterVal);
		case "after":
			TemporalFilterValue tempValue = FilterValue.createTemporal(val);
			return new AfterFilter(filterKey, tempValue);
		case "before":
			return new BeforeFilter(filterKey, (TemporalFilterValue) filterVal);
		case "range":
			return new RangeFilter(filterKey, (RangeFilterValue) filterVal);
		case "lte":
			return new LesserFilter(filterKey, (NumericFilterValue) filterVal);
		case "gte":
			return new GreaterFilter(filterKey, (NumericFilterValue) filterVal);
		default:
			throw new FilterException("Unknown filter operation: " + op);
		}
	}

	FilterKey<?> filterKey();

	T value();

	FilterOperation getOperationKey();

}
