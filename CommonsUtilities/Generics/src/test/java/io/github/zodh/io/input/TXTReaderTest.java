//package io.github.zodh.io.input;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import io.github.zodh.io.InvalidFileException;
//import io.github.zodh.io.file.types.TextFileData;
//import java.io.File;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class TXTReaderTest {
//
//  private FileReader<TextFileData> txtReader;
//
//  @BeforeEach
//  void init() {
//    this.txtReader = new TXTReader();
//  }
//
//  @Test
//  @DisplayName("Should read a TXT file")
//  void givenCSVFileWhenCallReadMethodThenReturnFileContent() {
//    final File file = new File("src/test/resources/teste.txt");
//    final TextFileData textFileData = (txtReader.deserializeFileAsObject(file));
//    String content = textFileData.getContent();
//    assertThat(content).isEqualTo("felipec;author");
//  }
//
//  @Test
//  @DisplayName("Should not read CSV File and should throws exception")
//  void givenTXTFileWhenCallReadMethodThenThrowsException() {
//    final File file = new File("src/test/resources/teste.csv");
//    txtReader = new TXTReader(file);
//    assertThrows(InvalidFileException.class, () -> txtReader.getDeserializedObject());
//  }
//
//}
