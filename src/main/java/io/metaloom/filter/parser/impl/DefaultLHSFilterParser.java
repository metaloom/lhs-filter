package io.metaloom.filter.parser.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.metaloom.filter.Filter;
import io.metaloom.filter.FilterException;
import io.metaloom.filter.FilterKey;
import io.metaloom.filter.impl.AfterFilter;
import io.metaloom.filter.impl.BeforeFilter;
import io.metaloom.filter.impl.EqualsFilter;
import io.metaloom.filter.impl.GreaterFilter;
import io.metaloom.filter.impl.LesserFilter;
import io.metaloom.filter.impl.RangeFilter;
import io.metaloom.filter.parser.FilterParser;
import io.metaloom.filter.parser.LHSFilterParser;

public enum DefaultLHSFilterParser implements LHSFilterParser {

	INSTANCE;

	private final Map<String, FilterParser> filters = new HashMap<>();
	private Map<String, FilterKey> keys = new HashMap<>();

	DefaultLHSFilterParser() {
		register("eq", EqualsFilter::parse);
		register("after", AfterFilter::parse);
		register("before", BeforeFilter::parse);
		register("range", RangeFilter::parse);
		register("lte", LesserFilter::parse);
		register("gte", GreaterFilter::parse);
	}

	@Override
	public void register(String op, FilterParser filterProvider) {
		filters.put(op, filterProvider);
	}

	@Override
	public void unregisterFilter(String op) {
		filters.remove(op);
	}

	@Override
	public void register(FilterKey key) {
		keys.put(key.key(), key);
	}

	@Override
	public List<Filter> parse(String line) {
		Stream<String> lines = Arrays.stream(line.split(","));
		return lines.map(filterLine -> parseFilterLine(filterLine)).collect(Collectors.toList());
	}

	private Filter  parseFilterLine(String line) {
		String key = line.substring(0, line.indexOf("["));
		String op = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
		String val = line.substring(line.indexOf("=") + 1);

		FilterParser parser = filters.get(op);
		if (parser == null) {
			throw new FilterException("Unknown filter operation: " + op);
		}

		FilterKey filterKey = keys.get(key);
		if (filterKey == null) {
			throw new FilterException("Unknown filter key: " + key);
		}
		return parser.parse(filterKey, op, val);
	}

	public static LHSFilterParser getInstance() {
		return INSTANCE;
	}
}
