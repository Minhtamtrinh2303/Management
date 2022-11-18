package productmanagement;

import run.Main;
import entity.Product;

import java.util.Scanner;

public class UpdateProduct {
    public static void update() {
        System.out.println("How many products would you like to add? ");
        int n;
        do {
            n = new Scanner(System.in).nextInt();
            if ( n > 0 ) {
                break;
            }
            System.out.println("Invalid number, please re-enter: ");
        } while(true);

        System.out.println("The product(s) in the list: ");
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.inputInfo(); // nhập thông tin cho từng sản phẩm
            Main.products.add(product); // lưu từng sản phẩm
        }
    }

}
