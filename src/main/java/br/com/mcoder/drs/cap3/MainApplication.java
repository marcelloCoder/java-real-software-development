package br.com.mcoder.drs.cap3;

import java.io.IOException;

public class MainApplication {

	public static void main(final String... args) throws IOException{
		
		final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
		
		final BankStatementParser bankStatementParser = new BankStatementCSVParser();
		
		bankStatementAnalyzer.analyze(args[0], bankStatementParser);
		
		boolean test = false;
		
		System.out.println(" " + !test);

	}

}
