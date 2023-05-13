package io.github.zodh.io;

import java.io.File;

public enum FileExtension {

  CSV(".csv"),
  TXT(".txt"),
  JSON(".json");

  private final String fileExtension;

  FileExtension(String fileExtension) {
    this.fileExtension = fileExtension;
  }

  public String getFileExtension() {
    return fileExtension;
  }

  public static FileExtension fromValue(String string) {
    var values = values();
    for (int i = 0; i != values.length; i++) {
      if (values[i].getFileExtension().equals(string)) {
        return values[i];
      }
    }
    throw new IllegalArgumentException("Unhandled file extension");
  }

  public static FileExtension getFileExtension(final File file) {
    if (file == null) {
      throw new NullPointerException("Is not possible to check extension of a null file");
    }
    var len = file.getAbsolutePath().length();
    var fourLen = file.getAbsolutePath().substring(len - 3, len);
    var fiveLen = file.getAbsolutePath().substring(len - 4, len);
    var result = (fourLen.charAt(0) == '.') ? fourLen : fiveLen;
    try {
      return FileExtension.fromValue(result);
    } catch (Exception exception) {
      throw new IllegalArgumentException(
          String.format("Unhandled file extension: %s or %s", fourLen, fiveLen));
    }
  }

}
