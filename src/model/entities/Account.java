package model.entities;

import model.exceptions.DomainExceptions;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	
	public Account() {
	}
	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void deposit(Double amount) {
		balance += amount;
	}
	public void withdraw(Double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	public Double withdrawLimit(Double balance) {
		double withdrawLimit = 0.0;
		if(balance <= 500.00) {
			withdrawLimit = balance * 0.5;
		}else {
			withdrawLimit = balance * 0.6;
		}
		return withdrawLimit;
	}
	public void validateWithdraw(Double amount) {
		if(amount > withdrawLimit(balance)) {
			throw new DomainExceptions("Withdraw error: The amount exceeds the withdrawal limit.");
		}
		if(amount > getBalance()) {
			throw new DomainExceptions("Withdraw error: Insufficient balance");
		}
	}
}