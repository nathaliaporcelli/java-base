package heranca_polimorfismo.exercicio1.heranca.application;

import heranca_polimorfismo.exercicio1.heranca.entities.ImportedProduct;
import heranca_polimorfismo.exercicio1.heranca.entities.Product;
import heranca_polimorfismo.exercicio1.heranca.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static  void main (String[]args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int  n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <=n ;i++){
            System.out.println("Product #" +i+"data");
            System.out.println("Enter product's name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter product's price: ");
            Double price = sc.nextDouble();
            System.out.print("Common, user or imported (c/u/i)? ");
            String option = sc.next();
            if(option.equals("c")){
                list.add(new Product(name,price));
            }
            if(option.equals("i")){

                System.out.print("Enter customs fee: ");
                Double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name,price,customsFee));

            }
            if(option.equals("u")){


                System.out.print("Enter product's manufactured date (DD/MM/AAAA): ");
                Date manufacturedDate = sdf.parse(sc.next());
                list.add(new UsedProduct(name,price,manufacturedDate));

            }

        }
        System.out.println();
        System.out.println("--------Products-------");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }


        sc.close();


    }
}
