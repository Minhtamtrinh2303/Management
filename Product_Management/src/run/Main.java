package run;

import entity.Product;
import productmanagement.DeleteProduct;
import productmanagement.FindProduct;
import productmanagement.UpdateProduct;
import productmanagement.ViewProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {

        while(true) {
            showMenu();
            int functionChoice = chooseFunction();
            logicHandle(functionChoice);
        }
    }

    private static void logicHandle(int functionChoice) {
        switch (functionChoice) {
            case 1:
                UpdateProduct.update();
                break;
            case 2:
                ViewProduct.view();
                break;
            case 3:
                FindProduct.byNameOrId();
                break;
            case 4:
                FindProduct.byQuantity();
                break;
            case 5:
                FindProduct.byPrice();
                break;
            case 6:
                DeleteProduct.byNameOrId();
                break;
            case 7:
                System.exit(0);
        }
    }

    private static int chooseFunction() {
        System.out.println("Please select the function below: ");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 7) {
                break;
            }
            System.out.println("Invalid function, please re-enter: ");
        } while (true);
        return choice;
    }

    public static void showMenu() {
        System.out.println("-----WELCOME TO PRODUCT MANAGEMENT SOFTWARE-----");
        System.out.println("1. Update product quantity. ");
        System.out.println("2. View product list. ");
        System.out.println("3. Find products by name or id. ");
        System.out.println("4. Find products with quantities under 5. ");
        System.out.println("5. Find products by price. ");
        System.out.println("6. Delete products by name or id. ");
        System.out.println("7. End program. ");
    }
}
