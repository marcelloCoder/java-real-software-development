package drs;

import java.io.IOException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.mcoder.drs.cap2.BankStatementAnalyzer;
import br.com.mcoder.drs.cap2.BankStatementCSVParser;
import br.com.mcoder.drs.cap2.BankStatementParser;

public class BankStatementAnalyzerTest {

	final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
	final String RESOURCES = "src/main/resources/";


	@Test
	public void analyzeShouldThrowIOExceptionWhenFileDoesNotExist() {
		String fileName = "non_existing_file.csv";
		BankStatementParser parser = new BankStatementCSVParser();

		Assertions.assertThrows(IOException.class, () -> {
			analyzer.analyze(fileName, parser);
		});
	}

	@Test
	public void analyzeShouldProcessValidFile() throws IOException {
		String csvcontent = "mseuarquivo.csv";
		BankStatementParser parser = new BankStatementCSVParser();	
		Assertions.assertDoesNotThrow(() ->{
			analyzer.analyze(csvcontent, parser);
		});
		
		
	}

}
