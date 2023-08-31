//package io.github.zodh.io.input;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import io.github.zodh.io.InvalidFileException;
//import java.io.File;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class CSVReaderTest {
//
//  private CSVReader csvReader;
//
//  @BeforeEach
//  void init() {
//    this.csvReader = new CSVReader();
//  }
//
//  @Test
//  @DisplayName("Should read a CSV file")
//  void givenCSVFileWhenCallReadMethodThenReturnFileContent() {
//    final File file = new File("src\\test\\resources\\teste.csv");
//    String content = csvReader.deserializeFileAsObject(file).getContent();
//    assertThat(content).isEqualTo("felipec;author");
//  }
//
//  @Test
//  @DisplayName("Should not read TXT File and should throws exception")
//  void givenTXTFileWhenCallReadMethodThenThrowsException() {
//    final File file = new File("src\\test\\resources\\teste.txt");
//    csvReader = new CSVReader(file);
//    assertThrows(InvalidFileException.class, () -> csvReader.getDeserializedObject());
//  }
//
//}
