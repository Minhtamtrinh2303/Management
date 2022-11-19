package entity;

import java.util.Scanner;

public class Person implements Inputable {

    protected String name;
    protected String address;
    protected String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "entity.Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    @Override
    public void teacherInfo() {
        System.out.println("Nhập tên bạn đọc: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ:  ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại: ");
        this.phone = new Scanner(System.in).nextLine();
    }

}
