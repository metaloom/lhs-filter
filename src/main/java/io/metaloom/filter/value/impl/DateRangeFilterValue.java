package io.metaloom.filter.value.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.metaloom.filter.FilterException;
import io.metaloom.filter.value.RangeFilterValue;
import io.metaloom.filter.value.TemporalFilterValue;

// Maybe split into different classes (TimeRange, DateRange, DateTimeRange, InstantRange)
public class DateRangeFilterValue implements TemporalFilterValue, RangeFilterValue {

	public static final Logger log = LoggerFactory.getLogger(DateRangeFilterValue.class);

	private Instant instantFrom;
	private Instant instantTo;

	private LocalDateTime dateTimeFrom;
	private LocalDateTime dateTimeTo;

	private LocalDate dateFrom;
	private LocalDate dateTo;

	private LocalTime timeFrom;
	private LocalTime timeTo;

	public DateRangeFilterValue(Instant instantFrom, Instant instantTo) {
		this.instantFrom = instantFrom;
		this.instantTo = instantTo;
	}

	public DateRangeFilterValue(LocalTime timeFrom, LocalTime timeTo) {
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
	}

	public DateRangeFilterValue(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
		this.dateTimeFrom = dateTimeFrom;
		this.dateTimeTo = dateTimeTo;
	}

	public DateRangeFilterValue(LocalDate dateFrom, LocalDate dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDateTime getDateTimeFrom() {
		return dateTimeFrom;
	}

	public LocalDateTime getDateTimeTo() {
		return dateTimeTo;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public Instant getInstantFrom() {
		return instantFrom;
	}

	public Instant getInstantTo() {
		return instantTo;
	}

	public LocalTime getTimeFrom() {
		return timeFrom;
	}

	public LocalTime getTimeTo() {
		return timeTo;
	}
	
	@Override
	public String toString() {
		//TODO add other cases
		return dateFrom.toString() + RANGE_SEPERATOR + dateTo.toString();
	}

	public static DateRangeFilterValue create(String val) {
		String[] parts = val.split(RANGE_SEPERATOR);
		if (parts.length != 2) {
			throw new FilterException("The value " + val + " could did not contain two values with a colon seperator.");
		}
		try {
			LocalDate dateFrom = LocalDate.parse(parts[0]);
			LocalDate dateTo = LocalDate.parse(parts[1]);
			return new DateRangeFilterValue(dateFrom, dateTo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("Failed to parse " + val + " into two dates. Continuing with time", e);
			}
		}
		try {
			LocalTime timeFrom = LocalTime.parse(parts[0]);
			LocalTime timeTo = LocalTime.parse(parts[1]);
			return new DateRangeFilterValue(timeFrom, timeTo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("Failed to parse " + val + " into two times. Continuing with date+time", e);
			}
		}
		try {
			LocalDateTime dateTimeFrom = LocalDateTime.parse(parts[0]);
			LocalDateTime dateTimeTo = LocalDateTime.parse(parts[1]);
			return new DateRangeFilterValue(dateTimeFrom, dateTimeTo);
		} catch (Exception e) {
			if (log.isDebugEnabled()) {
				log.debug("Failed to parse " + val + " into two local date+time. Continuing with ISO8601 UTC ", e);
			}
		}
		try {
			Instant instantFrom = Instant.parse(parts[0]);
			Instant instantTo = Instant.parse(parts[1]);
			return new DateRangeFilterValue(instantFrom, instantTo);
		} catch (Exception e) {
			throw new FilterException("The value " + val + " could not be parsed into a time, date, date+time or ISO8601 UTC", e);
		}
	}

}
