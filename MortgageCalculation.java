package Youtupe;

import java.text.NumberFormat;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		/***
		 * Principal
		 * Annual interest rate 
		 * Period (Years)
		 * Number of payment per year
		 * M = (P * (r(1+1)^n))
		 *     /
		 *     ((1+r)^n -1)
		 */
		//declare CONSTANTS 
		Scanner scan = new Scanner(System.in);
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		int principal = 0;
		float monthlyInterest = 0;
		int numberOfPayments = 0;
		
		//get principal input between 1000 and 1000000
		while (true) {
			System.out.print("Principal: ");
			principal = scan.nextInt();
			if (principal >= 1000 && principal <= 1_000_000)
				break;
			System.out.print("Enter a value between 1000 and 1,000,000");
		}
		
		
		//get annual interest rate between 1 and 8
		while (true) {
			System.out.print("Annual Interest Rate: ");
			float annualInterest = scan.nextFloat();
			if (annualInterest >= 1 && annualInterest <= 8) {
				monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
				break;
			}
		}
		
		
		//get period of years input between 1 and 30
		while (true) {
			System.out.print("Period (Years): ");
			byte years = scan.nextByte();
			if (years >= 1 && years <= 30) {
				numberOfPayments = years * MONTHS_IN_YEAR;
				break;
			}
			System.out.print("Enter a number between 1 and 8");
		}
		
		//mortgage calculation
		double mortgage = principal
				* (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) -1);
		
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage: " + mortgageFormatted);	

	}
}
