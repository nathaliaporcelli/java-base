package order.application;

import order.entities.Client;
import order.entities.Order;
import order.entities.OrderItem;
import order.entities.Product;
import order.enums.OrderStatus;
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

        System.out.println("--- Enter order data ---");
        System.out.print("Enter order status: "   );
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status,client);

        System.out.print("How many items to this order: ");
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
