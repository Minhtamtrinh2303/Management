package productmanagement;

import entity.Product;
import run.Main;

import java.util.Scanner;

public class DeleteProduct {

    public static void byNameOrId() {
        /**
         * kiểm tra xem đã nhập sản phẩm?
         * phải có sản phẩm mới có thể xóa sản phẩm
         */
        if ( Main.products.size() == 0 ) {
            System.out.println("You must have product's information first.");
            return;
        }

        System.out.println("Enter your selection: ");
        System.out.println("1. Delete products by name.");
        System.out.println("2. Delete products by id.");
        System.out.println("3. Return to main screen");
        int choice = -1;
        do {
            choice = new Scanner(System.in).nextInt();
            if ( choice == 1 || choice == 2 || choice == 3 ) {
                break;
            }
            System.out.println("Invalid number, please re-enter: ");
        }while(true);
        switch (choice) {
            case 1:
                deleteByName();
                break;
            case 2:
                deleteById();
                break;
            case 3:
                Main.showMenu();
        }

    }

    private static void deleteById() {
        System.out.println("Enter product's id: ");
        int id = new Scanner(System.in).nextInt();
        boolean delete = false;
        int d = -1; //lưu lại id cần xóa
        for (int i = 0; i < Main.products.size(); i++) {
            if ( id == Main.products.get(i).getId()) {
                delete = true;
                d = i;
                break;
            }
        }
        if ( delete == false ) {
            System.out.println("This is not the ID to delete! ");
        } else {
            Main.products.remove(d);
        }
        ViewProduct.view(); // xem danh sách sản phẩm sau khi xóa
    }

    private static void deleteByName() {
        System.out.println("Enter product's name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("The remaining product(s) in the list: ");
        for (Product product : Main.products) {
            if ( product.getName().equals(name) ) {
                Main.products.remove(name);
            }
        }
    }
}
