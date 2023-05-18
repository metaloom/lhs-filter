package io.metaloom.filter.key;

import io.metaloom.filter.key.impl.DurationFilterKey;
import io.metaloom.filter.key.impl.LocalDateFilterKey;
import io.metaloom.filter.key.impl.LocalDateTimeFilterKey;
import io.metaloom.filter.key.impl.LocalTimeFilterKey;
import io.metaloom.filter.key.impl.NumberFilterKey;
import io.metaloom.filter.key.impl.SizeFilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;
import io.metaloom.filter.parser.LHSFilterParser;

public final class TestFilterKey {

	public final static StringFilterKey USER_USERNAME = new StringFilterKey("username");

	public final static NumberFilterKey ARTICLE_PRICE = new NumberFilterKey("price");

	public final static LocalTimeFilterKey DUE_TIME = new LocalTimeFilterKey("due_time");

	public final static LocalDateFilterKey DUE_DATE = new LocalDateFilterKey("due_date");

	public final static LocalDateTimeFilterKey DUE = new LocalDateTimeFilterKey("due");

	public final static SizeFilterKey FILE_SIZE = new SizeFilterKey("size");

	public final static DurationFilterKey VIDEO_DURATION = new DurationFilterKey("duration");

	static {
		LHSFilterParser.getInstance().register(USER_USERNAME);
		LHSFilterParser.getInstance().register(ARTICLE_PRICE);
		LHSFilterParser.getInstance().register(DUE_TIME);
		LHSFilterParser.getInstance().register(DUE_DATE);
		LHSFilterParser.getInstance().register(DUE);
		LHSFilterParser.getInstance().register(FILE_SIZE);
		LHSFilterParser.getInstance().register(VIDEO_DURATION);
	}
}
