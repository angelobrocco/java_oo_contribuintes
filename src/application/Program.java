package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		for (int i = 0; i<n; i++) {
			System.out.println();
			System.out.println("Renda anual do " + (i+1) + "o contribuinte");
			System.out.print("Renda anual com salário: ");
			salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			educationSpending = sc.nextDouble();
			TaxPayer payer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			list.add(payer);
		}
		System.out.println();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println("Resumo do "+(i+1)+"o contribuinte:");
			for(TaxPayer payer : list) {
				System.out.println(payer);
				System.out.println();
				}
		}
	}
}
