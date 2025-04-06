package drs;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import br.com.mcoder.drs.cap2.BankStatementCSVParser;
import br.com.mcoder.drs.cap2.BankStatementParser;
import br.com.mcoder.drs.cap2.BankTransaction;

public class BankStatementCSVParserTest {
	
	private final BankStatementParser statementParser = new BankStatementCSVParser();
	
	@Test
	public void shouldParseOneCorrectLine() throws Exception{
		final String line = "22-01-2017,200,Iphone";
		
		final BankTransaction result = statementParser.parseFrom(line);
		
		final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 22), 200, "Iphone");
		final double tolerance = 0.0d;
		
		Assert.assertEquals(expected.getDate(), result.getDate());
		Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		Assert.assertEquals(expected.getDescription(), result.getDescription());
	}
	

}
