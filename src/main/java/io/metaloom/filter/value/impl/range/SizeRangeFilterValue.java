package io.metaloom.filter.value.impl.range;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.RangeFilterValue;
import io.metaloom.filter.value.impl.SizeFilterValueVariant;
import io.metaloom.utils.ConvertUtils;

public class SizeRangeFilterValue implements RangeFilterValue, SizeFilterValueVariant {

	private final long from;
	private final long to;

	public SizeRangeFilterValue(String from, String to) {
		this.from = ConvertUtils.fromHumanSize(from);
		this.to = ConvertUtils.fromHumanSize(to);
	}

	public long getFrom() {
		return from;
	}

	public long getTo() {
		return to;
	}

	@Override
	public String toString() {
		String from = ConvertUtils.toHumanSize(getFrom()).replaceAll("\s", "");
		String to = ConvertUtils.toHumanSize(getTo()).replaceAll("\s", "");
		return from.toString() + RANGE_SEPERATOR + to.toString();
	}

	public static SizeRangeFilterValue create(String val) {
		String[] parts = val.split(RANGE_SEPERATOR);
		if (parts.length != 2) {
			throw new FilterException("The value " + val + " could did not contain two values with a colon seperator.");
		}
		try {
			return new SizeRangeFilterValue(parts[0], parts[1]);
		} catch (Exception e) {
			throw new FilterException("Failed to parse " + val + " into size range", e);
		}
	}

}
