package io.github.zodh.date;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatterBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateUtilsTest {

  @Test
  @DisplayName("Should generate an ISO 8601 Now Timestamp")
  void givenMethodCallWhenNeedNowTimestampAsISO8601FormatThenGenerateISO8601Timestamp() {
    // arrange and act
    var result = DateUtils.generateISO8601Timestamp("GMT-3");
    var instantDate = Long.parseLong(DateUtils.fromISO8601TimestampToEpochTime(result));

    // assert
    assertThat(result).isNotBlank();
    assertThat(DateUtils.fromISO8601TimestampToEpochTime(result)).isNotBlank();
    assertThat(Date.from(Instant.ofEpochSecond(instantDate))).isNotNull();
  }

  @Test
  @DisplayName("Should convert epoch time to ISO 8601 Timestamp")
  void givenAnEpochTimeStringWhenConvertEpochToISO8601ThenGenerateISO8601Date() {
    // arrange
    var epochTime = "1669349517";
    // act
    var result = DateUtils.fromEpochTimeToISO8601Timestamp(epochTime);
    var instantDate = Long.parseLong(DateUtils.fromISO8601TimestampToEpochTime(result));
    // assert
    assertThat(result).isNotBlank();
    assertThat(DateUtils.fromISO8601TimestampToEpochTime(result)).isNotBlank();
    assertThat(Date.from(Instant.ofEpochSecond(instantDate))).isNotNull();
  }

  @Test
  @DisplayName("Should convert ISO 8601 to Epoch time")
  void givenISO8601TimestampWhenShouldConvertFromISO8601ToEpochThenConvertToEpoch() {
    // arrange
    var iso8601Timestamp = "2022-11-25T04:11:57.000Z";
    // act
    var result = DateUtils.fromISO8601TimestampToEpochTime(iso8601Timestamp);
    var resultAsLong = Long.parseLong(result);
    var resultAsInstant = Instant.ofEpochSecond(resultAsLong);
    var localDateTime = LocalDateTime.ofInstant(resultAsInstant,
        ZoneId.of(DateUtils.ZONE_ID_ETC_UTC));
    // assert
    assertThat(result).isNotNull();
    assertThat(localDateTime.getDayOfMonth()).isEqualTo(25);
    assertThat(localDateTime.getMonth()).isEqualTo(Month.NOVEMBER);
    assertThat(localDateTime.getYear()).isEqualTo(2022);
    assertThat(localDateTime.getHour()).isEqualTo(4L);
    assertThat(localDateTime.getMinute()).isEqualTo(11);
    assertThat(localDateTime.getSecond()).isEqualTo(57);
  }

  @Test
  @DisplayName("Should generate dd-MM-yyyy string from now")
  void givenMethodCallWhenNeedNowTimestampAsDDMMYYYYThenReturnNowDDMMYYYAsString() {
    // arrange and act
    var result = DateUtils.getStringDateNowAsDDMMYYYY();
    var resultAsLocalDate = LocalDate.parse(result,
        new DateTimeFormatterBuilder().appendPattern(DateUtils.DD_MM_YYYY_PATTERN).toFormatter());
    // assert
    assertThat(resultAsLocalDate).isNotNull();
    assertThat(resultAsLocalDate.getDayOfMonth()).isEqualTo(LocalDate.now().getDayOfMonth());
    assertThat(resultAsLocalDate.getYear()).isEqualTo(LocalDate.now().getYear());
    assertThat(resultAsLocalDate.getMonth()).isEqualTo(LocalDate.now().getMonth());
  }

  @Test
  @DisplayName("Should generate dd-MM-yyyy string from given day, month and year")
  void givenMethodCallWithDayAsParametersWhenNeedNowTimestampAsDDMMYYYYThenReturnNowDDMMYYYAsString() {
    // arrange and act
    var result = DateUtils.getStringDateAsDDMMYYYY(16, Month.JANUARY.getValue(), 2001);
    var resultAsLocalDate = LocalDate.parse(result,
        new DateTimeFormatterBuilder().appendPattern(DateUtils.DD_MM_YYYY_PATTERN).toFormatter());
    // assert
    assertThat(resultAsLocalDate).isNotNull();
    assertThat(resultAsLocalDate.getDayOfMonth()).isEqualTo(16);
    assertThat(resultAsLocalDate.getYear()).isEqualTo(2001);
    assertThat(resultAsLocalDate.getMonth()).isEqualTo(Month.JANUARY);
  }

}
