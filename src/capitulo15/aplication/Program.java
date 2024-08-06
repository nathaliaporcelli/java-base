package capitulo15.aplication;

import capitulo15.BusinesException;
import capitulo15.entities.Account;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main (String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double initialBalance = sc.nextDouble();

        System.out.print("Enter withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number,holder,initialBalance,withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

       try{
            acc.withDraw(amount);
            System.out.println("New Balance: " + String.format("%.2f", acc.getBalance()));
        }
       catch (BusinesException e){
          System.out.println(e.getMessage());
       }
        sc.close();


    }

}
