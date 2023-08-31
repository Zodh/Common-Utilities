//package io.github.zodh.io.input;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import io.github.zodh.io.InvalidFileException;
//import io.github.zodh.io.file.types.CsvMapFileData;
//import java.io.File;
//import java.util.Map;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class CSVMapReaderTest {
//
//  private CSVMapReader csvMapReader;
//
//  @BeforeEach
//  void init() {
//    this.csvMapReader = new CSVMapReader();
//  }
//
//  @Test
//  @DisplayName("Should read a CSV file as map")
//  void givenCSVFileWhenCallReadCsvAsMapMethodThenReturnFileContentAsMap() {
//    final File file = new File("src\\test\\resources\\teste.csv");
//    final CsvMapFileData csvMapFileData = csvMapReader.deserializeFileAsObject(file);
//    Map<String, String> content = csvMapFileData.getCsvAsMap();
//    assertThat(content).containsEntry("felipec", "author");
//  }
//
//  @Test
//  @DisplayName("Should not read TXT File and should throws exception")
//  void givenTXTFileWhenCallReadMethodThenThrowsException() {
//    final File file = new File("src\\test\\resources\\teste.txt");
//    csvMapReader = new CSVMapReader(file);
//    assertThrows(InvalidFileException.class, () -> csvMapReader.getDeserializedObject());
//  }
//
//}
