package io.github.zodh.evaluation;

import java.io.File;

public class FileEvaluator {

  public static String getFileInformation(final File file) {
    return "The file " + file.getName() + " is not valid. \n" +
        "Path: " + file.getAbsolutePath() + " (absolute path) \n" +
        "Exists? " + file.exists() + "\n" +
        "Read: " + file.canRead() + " - Write: " + file.canWrite() + " - Execute: "
        + file.canExecute();
  }

}
