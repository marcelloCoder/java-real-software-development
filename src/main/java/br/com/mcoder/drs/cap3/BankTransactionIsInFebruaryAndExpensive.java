package br.com.mcoder.drs.cap3;

import java.time.Month;
import java.util.List;

class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

	BankStatementProcessor bankStatementProcessor;

	BankTransactionProcessor bankTransactionProcessor;

	@Override
	public boolean test(BankTransaction bankTransaction) {
		return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
	}

	final List<BankTransaction> transactions = bankTransactionProcessor
			.findTransactions(new BankTransactionIsInFebruaryAndExpensive());

}
