package br.com.mcoder.drs.cap2;

import java.util.List;

public interface BankStatementParser {

	BankTransaction parseFrom(String line);

	List<BankTransaction> parseLinesFrom(List<String> lines);
}
