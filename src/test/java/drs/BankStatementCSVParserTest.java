package drs;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.com.mcoder.drs.cap2.BankStatementCSVParser;
import br.com.mcoder.drs.cap2.BankStatementParser;
import br.com.mcoder.drs.cap2.BankTransaction;

public class BankStatementCSVParserTest {

	private final BankStatementParser statementParser = new BankStatementCSVParser();

	@Test
	public void shouldParseOneCorrectLine() throws Exception {
		final String line = "22-01-2017,200,Iphone";

		final BankTransaction result = statementParser.parseFrom(line);

		final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 22), 200, "Iphone");
		final double tolerance = 0.0d;

		Assert.assertEquals(expected.getDate(), result.getDate());
		Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
		Assert.assertEquals(expected.getDescription(), result.getDescription());
	}

	@Test
	public void shouldParseFromCsv() {
		final List<String> lines = Arrays.asList("22-01-2017,200,Iphone", "24-01-2017,345,PC");

		final List<BankTransaction> result = statementParser.parseLinesFrom(lines);

		Assert.assertEquals(2, result.size());

		BankTransaction first = result.get(0);
		BankTransaction second = result.get(1);

		Assert.assertEquals(LocalDate.of(2017, 1, 22), first.getDate());
		Assert.assertEquals(200.0, first.getAmount(), 0.0);
		Assert.assertEquals("Iphone", first.getDescription());

		Assert.assertEquals(LocalDate.of(2017, 1, 24), second.getDate());
		Assert.assertEquals(345, second.getAmount(), 0.0);
		Assert.assertEquals("PC", second.getDescription());

	}

	@Test
	public void shouldThrowExceptionForInvalidLine() {
	    final String invalidLine = "not-a-date,abc,nope";

	    Assertions.assertThrows(Exception.class, () -> {
	        statementParser.parseFrom(invalidLine);
	    });
	}

}

