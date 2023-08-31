package io.github.zodh.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.springframework.format.datetime.standard.InstantFormatter;

public class DateUtils {

  private DateUtils() {
  }

  public static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  public static final String ZONE_ID_ETC_UTC = "Etc/UTC";
  public static final String DD_MM_YYYY_PATTERN = "dd-MM-yyyy";

  public static String generateISO8601Timestamp(String timezone) {
    var timezoneAsObject = TimeZone.getTimeZone(timezone);
    var simpleDateFormate = new SimpleDateFormat(ISO_8601_PATTERN);
    simpleDateFormate.setTimeZone(timezoneAsObject);
    return simpleDateFormate.format(new Date());
  }

  public static String fromEpochTimeToISO8601Timestamp(String epochDate) {
    var offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(epochDate)),
        ZoneId.of(ZONE_ID_ETC_UTC));
    var dateTimeFormatter = new DateTimeFormatterBuilder()
        .appendPattern(ISO_8601_PATTERN)
        .toFormatter()
        .withZone(ZoneId.of(ZONE_ID_ETC_UTC));
    return dateTimeFormatter.format(offsetDateTime);
  }

  public static String fromISO8601TimestampToEpochTime(String iso8601Timestamp) {
    try {
      var instantEpoch = new InstantFormatter().parse(iso8601Timestamp, Locale.US).getEpochSecond();
      return String.valueOf(instantEpoch);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Invalid ISO 8601 Timestamp");
    }
  }

  public static String getStringDateNowAsDDMMYYYY() {
    return new DateTimeFormatterBuilder()
        .appendPattern(DD_MM_YYYY_PATTERN)
        .toFormatter()
        .withZone(ZoneId.of(ZoneId.systemDefault().toString())).format(Instant.now());
  }

  public static String getStringDateAsDDMMYYYY(int day, int month, int year) {
    return new DateTimeFormatterBuilder()
        .appendPattern(DD_MM_YYYY_PATTERN)
        .toFormatter()
        .withZone(ZoneId.of(ZONE_ID_ETC_UTC)).format(LocalDate.of(year, month, day));
  }

}
