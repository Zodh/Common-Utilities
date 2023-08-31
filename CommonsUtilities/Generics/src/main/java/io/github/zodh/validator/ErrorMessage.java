package io.github.zodh.validator;

import java.util.Objects;

public class ErrorMessage {

  private String message;
  private String reason;
  private String location;

  public ErrorMessage(String message, String reason) {
    this.message = message;
    this.reason = reason;
  }

  public ErrorMessage(String message, String reason, String location) {
    this.message = message;
    this.reason = reason;
    this.location = location;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage that = (ErrorMessage) o;
    return Objects.equals(message, that.message) && Objects.equals(reason,
        that.reason) && Objects.equals(location, that.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, reason, location);
  }

  @Override
  public String toString() {
    return "ErrorMessage{" +
        "message='" + message + '\'' +
        ", reason='" + reason + '\'' +
        ", location='" + location + '\'' +
        '}';
  }
}
