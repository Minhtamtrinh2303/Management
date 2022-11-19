package entity;

import java.util.Scanner;

public class Subject {

    private static int AUTO_ID = 100;
    private int id;
    private String name;
    private int lessonQuantity;
    private int theoryLessonQuantity;
    private double lessonPrice;

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

    public int getLessonQuantity() {
        return lessonQuantity;
    }

    public void setLessonQuantity(int lessonQuantity) {
        this.lessonQuantity = lessonQuantity;
    }

    public int getTheoryLessonQuantity() {
        return theoryLessonQuantity;
    }

    public void setTheoryLessonQuantity(int theoryLessonQuantity) {
        this.theoryLessonQuantity = theoryLessonQuantity;
    }

    public double getLessonPrice() {
        return lessonPrice;
    }

    public void setLessonPrice(double lessonPrice) {
        this.lessonPrice = lessonPrice;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lessonQuantity=" + lessonQuantity +
                ", theoryLessonQuantity=" + theoryLessonQuantity +
                ", lessonPrice=" + lessonPrice +
                '}';
    }

    public void subjectInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("Nhập tổng số tiết: ");
        this.lessonQuantity = new Scanner(System.in).nextInt();
        System.out.print("Nhập số tiết lý thuyết: ");
        this.theoryLessonQuantity = new Scanner(System.in).nextInt();
        System.out.print("Nhập số mức kinh phí: ");
        this.lessonPrice = new Scanner(System.in).nextDouble();
    }



}
