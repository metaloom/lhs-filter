package io.metaloom.filter.key;

import io.metaloom.filter.key.impl.DurationFilterKey;
import io.metaloom.filter.key.impl.LocalDateFilterKey;
import io.metaloom.filter.key.impl.LocalDateTimeFilterKey;
import io.metaloom.filter.key.impl.LocalTimeFilterKey;
import io.metaloom.filter.key.impl.NumberFilterKey;
import io.metaloom.filter.key.impl.SizeFilterKey;
import io.metaloom.filter.key.impl.StringFilterKey;

public final class TestFilterKey {

	public final static StringFilterKey USER_USERNAME = new StringFilterKey("username");

	public final static NumberFilterKey ARTICLE_PRICE = new NumberFilterKey("price");

	public final static LocalTimeFilterKey DUE_TIME = new LocalTimeFilterKey("due_time");

	public final static LocalDateFilterKey DUE_DATE = new LocalDateFilterKey("due_date");

	public final static LocalDateTimeFilterKey DUE = new LocalDateTimeFilterKey("due");

	public final static SizeFilterKey FILE_SIZE = new SizeFilterKey("size");

	public final static DurationFilterKey VIDEO_DURATION = new DurationFilterKey("duration");

}
