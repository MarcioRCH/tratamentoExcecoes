package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class BancAccount {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account acc = new Account();
		
		try {
			System.out.println("Enter account data.");
			System.out.print("Number: ");
			acc.setNumber(sc.nextInt());
			sc.nextLine();
			System.out.print("Holder: ");
			acc.setHolder(sc.nextLine());
			System.out.print("Inicial balance: ");
			acc.setBalance(sc.nextDouble());
			System.out.print("Withdraw limit: " + String.format("%.2f", acc.withdrawLimit(acc.getBalance())));
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			acc.withdraw(sc.nextDouble());
			
			System.out.print("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
