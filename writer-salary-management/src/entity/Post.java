package entity;

import java.util.Scanner;

public class Post implements Inputable {

    private static int AUTO_ID = 99;
    private int id;
    private String name;
    private double price;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên bài viết: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập mã bài viết: ");
        this.id = new Scanner(System.in).nextInt();
        System.out.print("Nhập giá: ");
        this.price = new Scanner(System.in).nextInt();

    }

}
