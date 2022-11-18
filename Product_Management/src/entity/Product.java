package entity;

import java.util.Scanner;

public class Product implements Inputable {

    private static int autoId = 0;
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "entity.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        autoId ++;
        this.id = autoId;
        System.out.println("Enter product's name: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Enter product's description: ");
        this.description = new Scanner(System.in).nextLine();
        System.out.println("Enter product's quantity: ");
        this.quantity = new Scanner(System.in).nextInt();
        System.out.println("Enter product's price: ");
        this.price = new Scanner(System.in).nextDouble();
        System.out.println("Enter product's unit: ");
        this.unit = new Scanner(System.in).nextLine();
    }
}
