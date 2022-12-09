package io.github.zodh.infrastructure.io;

import io.github.zodh.evaluation.FileEvaluator;

import java.io.File;

public class InvalidFileException extends RuntimeException {

    public InvalidFileException(File file) {
        super(FileEvaluator.getFileInformation(file));
    }

}