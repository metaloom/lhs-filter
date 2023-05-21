package io.metaloom.filter.parser;

import java.util.List;

import io.metaloom.filter.Filter;
import io.metaloom.filter.FilterKey;

public interface LHSFilterParser {

	List<Filter> parse(String line);

	void unregisterFilter(String op);

	void register(String op, FilterParser filterProvider);

	void register(FilterKey key);

}
