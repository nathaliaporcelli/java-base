package interfaceExercicioFixacao.application;

import interfaceExercicioFixacao.entities.Contract;
import interfaceExercicioFixacao.entities.Installment;
import interfaceExercicioFixacao.services.ContractService;
import interfaceExercicioFixacao.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com os dados do contrato: ");
        System.out.println("Número ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy) : ");
        LocalDate date = LocalDate.parse(sc.next(),fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number,date,totalValue);

        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();

        ContractService contractService =  new ContractService(new PaypalService());
        contractService.processContract(contract,n);

        System.out.println("Parcelas: ");
        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
