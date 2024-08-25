package interfaces.application;

import interfaces.entities.CarRental;
import interfaces.entities.Vehicle;
import interfaces.services.BrazilTaxService;
import interfaces.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceProgram {
    public static void main (String []args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm) ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm) ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);

        CarRental cr = new CarRental(start,finish, new Vehicle(carModel));

        BrazilTaxService taxService = new BrazilTaxService();

        System.out.println("Entre com o preço por hora: ");
        double pricePerHour=sc.nextDouble();

        System.out.println("Entre com o preço por dia: ");
        double pricePerDay=sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay,pricePerHour,new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("Fatura: ");
        System.out.println("Pagamento básico: " + cr.getInvoice().getBasicPayment());
        System.out.println("Imposto: " + cr.getInvoice().getTax());
        System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());

        sc.close();
    }
}
