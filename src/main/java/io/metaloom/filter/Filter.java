package io.metaloom.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.value.FilterValue;

public interface Filter {

	static List<Filter> parse(String line, Function<String, FilterKey> keyMapper) {
		Stream<String> lines = Arrays.stream(line.split(","));
		return lines.map(filterLine -> parseFilterLine(filterLine, keyMapper)).collect(Collectors.toList());
	}

	private static Filter parseFilterLine(String line, Function<String, FilterKey> keyMapper) {
		String key = line.substring(0, line.indexOf("["));
		String op = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
		String val = line.substring(line.indexOf("=") + 1);
		FilterKey filterKey = keyMapper.apply(key);
		FilterValue filterValue = FilterValue.valueOf(val);
		switch (op) {
		case EqualsFilter.OPERATION_KEY:
			return new EqualsFilter(filterKey, filterValue);
		case AfterFilter.OPERATION_KEY:
			return new AfterFilter(filterKey, filterValue);
		case BeforeFilter.OPERATION_KEY:
			return new BeforeFilter(filterKey, filterValue);
		case RangeFilter.OPERATION_KEY:
			return new RangeFilter(filterKey, filterValue);
		case LesserFilter.OPERATION_KEY:
			return new LesserFilter(filterKey, filterValue);
		default:
			throw new FilterException("Unknown filter operation: " + op);
		}
	}

	FilterKey filterKey();

	FilterValue value();

	String getOperationKey();

}
