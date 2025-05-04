package br.com.mcoder.drs.cap3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {
	private static final String RESOURCES = "src/main/resources/";

	public static void main(final String... args) throws IOException {

		final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
		final String fileName = args[0];

		if (args.length == 0) {
			System.out.println("Por favor, forneça o nome do arquivo como argumento.");
			return;
		}

		final Path path = Paths.get(RESOURCES + fileName);
		if (!Files.exists(path)) {
			System.out.println("Arquivo não encontrado: " + path.toAbsolutePath());
			return;
		}

		final List<String> lines = Files.readAllLines(path);
		final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
		double total = 0d;
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyy");

		/*
		 * for (final String line : lines) { final String[] columns = line.split(",");
		 * final double amount = Double.parseDouble(columns[1]); total += amount; }
		 */

		for (String line : lines) {
			final String columns[] = line.split(",");
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			if (date.getMonth() == Month.JANUARY) {
				final Double amount = Double.parseDouble(columns[1]);
				total += amount;
			}
		}

		System.out.println("O total de todas as transações de Janeiro é " + total);
		System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
		System.out.println("Transactions in January : " + selectInMonth(bankTransactions, Month.JANUARY));
	}


	private static Double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}
	
	private static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
		
		List<BankTransaction> bankTransactionsMonth = new ArrayList<>();
		
		for (BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsMonth.add(bankTransaction);
			}
		}
		return bankTransactionsMonth;
	}
}