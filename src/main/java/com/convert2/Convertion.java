package com.convert2;

import java.io.FileWriter;
import java.io.IOException;

public class Convertion {
	private String actualCurrency;
	private String targetCurrency;
	private double amount;

	private double conversion;

	public Convertion(String actualCurrency, String newCurrency, double amount) {
		this.actualCurrency = actualCurrency;
		this.targetCurrency = newCurrency;
		this.amount = amount;
		this.conversion = 0;
	}

	public void convertRates(CurrencyR rates) {
		// System.out.println("MXN = "+rates.convertion().get(targetRate));
		this.conversion = this.amount * rates.conversion().get(this.targetCurrency);

	}

	public void saveConvertion(Convertion conversion) throws IOException {
		DaoCurrency dao = new DaoCurrency();
		dao.saveConversion(conversion);
	}

	public String getActualCurrency() {
		return actualCurrency;
	}

	public void setActualCurrency(String actualCurrency) {
		this.actualCurrency = actualCurrency;
	}

	public String gettargetCurrency() {
		return targetCurrency;
	}

	public void targetCurrency(String newCurrency) {
		this.targetCurrency = newCurrency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getConversion() {
		return conversion;
	}

	public void setConversion(double conversion) {
		this.conversion = conversion;
	}

}
