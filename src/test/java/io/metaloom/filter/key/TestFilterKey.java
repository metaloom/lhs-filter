package io.metaloom.filter.key;

import java.util.Arrays;
import java.util.List;

import io.metaloom.filter.FilterKey;
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
	
	//public final static RangeFilterKey VIDEO_DURATION_RANGE = new RangeFilterKey("duration");

	public static List<FilterKey<?>> values() {
		return Arrays.asList(USER_USERNAME, ARTICLE_PRICE, FILE_SIZE, VIDEO_DURATION, DUE_DATE, DUE_TIME, DUE);
	}

	public static FilterKey<?> fromKey(String key) {
		for (FilterKey<?> v : values()) {
			if (v.key().equals(key)) {
				return v;
			}
		}
		return null;
	}

}
