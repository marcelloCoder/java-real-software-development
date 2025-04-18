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
				if (bankTransaction.getAmount() > max) {
					max = bankTransaction.getAmount();
				}
			}
		}
		return max;
	}

	public double calculateMinTransactionPerMonth(final Month month) {
		double min = 0;
		boolean found = false;

		for (final BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				if (!found) {
					min = bankTransaction.getAmount();
					found = true;
				} else if (bankTransaction.getAmount() < min) {
					min = bankTransaction.getAmount();
				}
			}
		}
		return min;
	}

	public void calculateTotalPerMonth() {
		for (Month month : Month.values()) {
			double total = 0.0;

			for (BankTransaction bankTransaction : bankTransactions) {
				if (bankTransaction.getDate().getMonth() == month) {
					total += bankTransaction.getAmount();
				}
			}
			if (total >= 0) {
				System.out.println("Total in month : " + month + " is POSITIVE $ " + total);
			}
			if (total < 0) {
				System.out.println("Total in month : " + month + " is NEGATIVE $ " + total);
			}
		}
	}

	/*public Map<Month, Double> calculateTotalPerMonth() {  OUTRA ALTERNATIVA
	    Map<Month, Double> totalsPerMonth = new HashMap<>();

	    for (final BankTransaction bankTransaction : bankTransactions) {
	        Month month = bankTransaction.getDate().getMonth();
	        double amount = bankTransaction.getAmount();

	        totalsPerMonth.put(month, totalsPerMonth.getOrDefault(month, 0.0) + amount);
	    }

	    return totalsPerMonth;
	}*/

	
	public void calculateMinTransactionForAllMonths() {
		double min = 0;
		boolean found = false;

		for (Month month : Month.values()) {
			for (final BankTransaction bankTransaction : bankTransactions) {
				if (bankTransaction.getDate().getMonth() == month) {
					if (!found) {
						min = bankTransaction.getAmount();
						found = true;
					} else if (bankTransaction.getAmount() < min) {
						min = bankTransaction.getAmount();
					}
				}
			}
			System.out.println("The MIN transaction of Month : " + month + " is $ :" + min);
			min = 0;
		}

	}

	public void calculateMaxTransactionForAllMonths() {
		double max = 0;
		for (Month month : Month.values()) {
			for (final BankTransaction bankTransaction : bankTransactions) {
				if (bankTransaction.getDate().getMonth() == month) {
					if (bankTransaction.getAmount() > max) {
						max = bankTransaction.getAmount();
					}
				}
			}
			System.out.println("The MAX transaction of Month : " + month + " is $ :" + max);
			max = 0;
		}

	}

}
