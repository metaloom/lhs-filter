package io.metaloom.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import io.metaloom.filter.key.TestFilterKey;
import io.metaloom.filter.parser.LHSFilterParser;
import io.metaloom.filter.parser.impl.LHSFilterParserImpl;
import io.metaloom.filter.value.FilterValue;

public abstract class AbstractFilterTest {

	public LHSFilterParser parser = new LHSFilterParserImpl();

	@BeforeEach
	public void setup() {
		parser.register(TestFilterKey.USER_USERNAME);
		parser.register(TestFilterKey.ARTICLE_PRICE);
		parser.register(TestFilterKey.DUE_TIME);
		parser.register(TestFilterKey.DUE_DATE);
		parser.register(TestFilterKey.DUE);
		parser.register(TestFilterKey.FILE_SIZE);
		parser.register(TestFilterKey.VIDEO_DURATION);
	}

	@SuppressWarnings("unchecked")
	public <F extends Filter, V extends FilterValue> F assertParsedFilter(String expectedFilterStr, F filter) {
		String filterStr = filter.toString();
		assertEquals(expectedFilterStr, filterStr, "The serialized filter did not match up");

		List<Filter> parsedFilters = parser.parse(filterStr);
		assertEquals(1, parsedFilters.size(), "There should only be one filter");
		Filter parsedFilter = parsedFilters.get(0);
		assertEquals(filter.getClass(), parsedFilter.getClass(), "The filter type did not match up.");
		assertEquals(filter.value().getClass(), parsedFilter.value().getClass(), "The filter value did not match up");
		return (F) parsedFilter;
	}

}
