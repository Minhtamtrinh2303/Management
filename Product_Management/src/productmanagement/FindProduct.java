package productmanagement;

import entity.Product;
import run.Main;

import java.util.Scanner;

public class FindProduct {

    public static void byNameOrId() {
        /**
         * kiểm tra xem đã nhập sản phẩm hay chưa?
         * phải có sản phẩm mới có thể sắp xếp sản phẩm
         */
        if ( Main.products.size() == 0 ) {
            System.out.println("You must have product's information first.");
            return;
        }

        System.out.println("Enter your selection: ");
        System.out.println("1. Find products by name.");
        System.out.println("2. Find products by id.");
        System.out.println("3. Return to main screen.");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if ( choice == 1 || choice == 2 || choice == 3 ) {
                break;
            }
            System.out.println("Invalid number, please re-enter: ");
        }while(true);
        switch (choice) {
            case 1:
                findByName();
                break;
            case 2:
                findById();
                break;
            case 3:
                Main.showMenu();
        }
    }

    private static void findByName() {
        System.out.println("Enter product's name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("The product(s) in the list: ");
        boolean hasName = false;
        for (Product product : Main.products) {
            if ( name.equals(product.getName()) ) {
                System.out.println(product);
                hasName = true;
            }
        }
        if ( ! hasName ) {
            System.out.println("Product's name does not exist in the list, please re-enter: ");
        }
    }

    private static void findById() {
        System.out.println("Enter product's id: ");
        int id = new Scanner(System.in).nextInt();
        System.out.println("The product(s) in the list: ");
        boolean hasId = false;
        for (Product product : Main.products) {
            if ( id == product.getId() ) {
                System.out.println(product);
                hasId = true;
            }
        }
        if ( ! hasId ) {
            System.out.println("Product's id does not exist in the list, please re-enter: ");
        }
    }

    //Tìm các sản phẩm có số lượng dưới 5
    public static void byQuantity() {
        /**
         * kiểm tra xem đã nhập sản phẩm hay chưa?
         * phải có sản phẩm mới có thể sắp xếp sản phẩm
         */
        if ( Main.products.size() == 0 ) {
            System.out.println("You must have product's information first.");
            return;
        }

        System.out.println("The product(s) in the list: ");
        boolean hasQuantity = false;
        for (Product product : Main.products) {
            if (product.getQuantity() <= 5) {
                System.out.println(product);
                hasQuantity = true;
            }
        }
        if ( ! hasQuantity ) {
            System.out.println("The product's quantities exceed 5, please re-enter: ");
        }
    }

    public static void byPrice() {
        /**
         * kiểm tra xem đã nhập sản phẩm hay chưa?
         * phải có sản phẩm mới có thể sắp xếp sản phẩm
         */
        if ( Main.products.size() == 0 ) {
            System.out.println("You must have product's information first.");
            return;
        }

        System.out.println("What price do you want to find products at?");
        System.out.println(" 1. Under 50000 VND ");
        System.out.println(" 2. From 50000 to less than 100000 VND ");
        System.out.println(" 3. From 100000 or more ");
        System.out.println(" 4. Return to main screen.");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if ( choice == 1 || choice == 2 || choice == 3 || choice == 4 ) {
                break;
            }
            System.out.println("Invalid number, please re-enter: ");
        }while(true);
        priceChoice(choice);
    }

    /**
     * Tìm sản phẩm theo mức giá:
     * Dưới 50.000
     * Từ 50.000 đến dưới 100.000
     * Từ 100.000 trở lên
     * @param choice
     */
    private static void priceChoice(int choice) {
        System.out.println("The product(s) in the list: ");
        boolean hasPrice = false;
        switch (choice) {
            case 1:
                for (Product product : Main.products) {
                    if ( product.getPrice() < 50000 && product.getPrice() > 0 ) {
                        System.out.println(product);
                        hasPrice = true;
                    }
                }
                break;
            case 2:
                for (Product product : Main.products) {
                    if ( product.getPrice() >= 50000 && product.getPrice() < 100000 ) {
                        System.out.println(product);
                        hasPrice = true;
                    }
                }
                break;
            case 3:
                for (Product product : Main.products) {
                    if ( product.getPrice() >= 100000 ) {
                        System.out.println(product);
                        hasPrice = true;
                    }
                }
                break;
            case 4:
                Main.showMenu();
        }
        if ( !hasPrice ) {
            System.out.print("There is (are) no product(s) in this price range.");
        }
    }

}
