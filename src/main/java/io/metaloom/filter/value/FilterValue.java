package io.metaloom.filter.value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.filter.value.impl.DateRangeFilterValue;
import io.metaloom.filter.value.impl.DurationFilterValue;
import io.metaloom.filter.value.impl.NumberFilterValue;
import io.metaloom.filter.value.impl.NumberRangeFilterValue;
import io.metaloom.filter.value.impl.StringFilterValue;

public interface FilterValue {

	public static final Logger log = LoggerFactory.getLogger(FilterValue.class);

	static FilterValue create(String val) {
		try {
			return NumberFilterValue.create(val);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("Failed to parse " + val + " into number filter value. Continuing with string value instead.");
			}
		}
		return StringFilterValue.create(val);
	}

	static NumericFilterValue createNumeric(String val) {
		if (val.startsWith("P")) {
			return DurationFilterValue.create(val);
		}
		return NumberFilterValue.create(val);
	}

	static RangeFilterValue createRange(String val) {
		try {
			return DateRangeFilterValue.create(val);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("Failed to parse " + val + " into date range filter value. Continuing with number value instead.");
			}
		}

		return NumberRangeFilterValue.create(val);
	}

}
