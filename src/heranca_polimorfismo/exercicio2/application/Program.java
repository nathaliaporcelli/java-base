package heranca_polimorfismo.exercicio2.application;

import heranca_polimorfismo.exercicio2.entities.Company;
import heranca_polimorfismo.exercicio2.entities.Individual;
import heranca_polimorfismo.exercicio2.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        List<TaxPayer> list = new ArrayList<>();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of taxpayers: ");
        int numberOfTaxPayers = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i<= numberOfTaxPayers;i++){
            System.out.println("Taxpayer #"+i+" data: ");
            System.out.print("Is the taxpayer individual or company? (i/c)");
            String option = sc.next();
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            if (option.equals("i")){
                System.out.print("Health expeditures: ");
                Double healthExpenditures = sc.nextDouble();
                Individual taxPayer = new Individual(name,anualIncome,healthExpenditures);
                list.add(taxPayer);
            }else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                Company taxPayer = new Company(name,anualIncome,numberOfEmployees);
                list.add(taxPayer);
            }
            System.out.println();


        }System.out.println("--------Tax Paid-------");
        for (TaxPayer taxPayer : list) {
            System.out.println("Name: " + taxPayer.getName() + " \nTax payed: " +String.format("%.2f", taxPayer.taxToPay()));
        }
        double totalTaxes = 0;
        for (TaxPayer taxPayer : list) {
            totalTaxes += taxPayer.taxToPay();
        }
        System.out.printf("Total taxes: " +String.format("%.2f", totalTaxes));
         sc.close();
    }
}
