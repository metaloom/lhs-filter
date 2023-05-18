package io.metaloom.filter.parser;

import io.metaloom.filter.Filter;
import io.metaloom.filter.FilterKey;

@FunctionalInterface
public interface FilterParser {

	Filter parse(FilterKey key, String op, String val);
}
