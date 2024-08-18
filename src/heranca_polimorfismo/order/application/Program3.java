package heranca_polimorfismo.order.application;

import heranca_polimorfismo.order.entities.Client;
import heranca_polimorfismo.order.entities.Order;
import heranca_polimorfismo.order.entities.OrderItem;
import heranca_polimorfismo.order.entities.Product;
import heranca_polimorfismo.order.enums.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Enter client data ---");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your e-mail: ");
        String email = sc.nextLine();
        System.out.print("Enter your birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name,email, birthDate);

        System.out.println("--- Enter capitulo14.order data ---");
        System.out.print("Enter capitulo14.order status: "   );
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status,client);

        System.out.print("How many items to this capitulo14.order: ");
        int n = sc.nextInt();
        for (int i = 1 ; i<= n; i++){
            System.out.print("Enter the #"+ i + " product's name: " );
            String productName = sc.next();
            System.out.print("Enter product's price: "   );
            double productPrice = sc.nextInt();
            System.out.print("Enter product's quantity: ");
            int productQuantity = sc.nextInt();

            Product product = new Product(productName,productPrice);
            OrderItem orderItem = new OrderItem(productQuantity,productPrice,product);
            order.addItem(orderItem);
        }

    System.out.println(order);
    sc.close();
    }
}
