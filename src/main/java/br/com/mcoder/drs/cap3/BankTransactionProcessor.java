package br.com.mcoder.drs.cap3;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionProcessor {
	
	private final List<BankTransaction> bankTransactions;
	
	public BankTransactionProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
		final List<BankTransaction> result = new ArrayList<>();
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getAmount() >= amount) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	public List<BankTransaction> findTransactionsInMonth(final Month month){
		final List<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount){
		final List<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
	
	// método usando conceito Open/Closed
	public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
		final List<BankTransaction> result = new ArrayList<>();
		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransactionFilter.test(bankTransaction)) {
				result.add(bankTransaction);
			}
		}
		return result;
	}

}
