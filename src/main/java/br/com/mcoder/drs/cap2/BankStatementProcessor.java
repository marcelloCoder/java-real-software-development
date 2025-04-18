package br.com.mcoder.drs.cap2;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

	private final List<BankTransaction> bankTransactions;

	public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public double calculateTotalAmount() {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	public double calculateTotalInMonth(final Month month) {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	public double calculateTotalForCategory(final String category) {
		double total = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDescription().equals(category)) {
				total += bankTransaction.getAmount();
			}
		}
		return total;
	}

	public double calculateMaxTransactionPerMonth(final Month month) {
		double max = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				if(bankTransaction.getAmount() > max) {
					max = bankTransaction.getAmount();
				}
			}
		}
		return max;
	}

	public double calculateMinTransactionPerMonth(final Month month) {
		double min = 0;
		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				if(bankTransaction.getAmount() < min) {
					min = bankTransaction.getAmount();
				}
			}
		}
		return min;
			
	}

}
