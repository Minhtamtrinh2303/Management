package entity;

import constant.WriterType;
import entity.Person;

import java.util.Scanner;

public class Writer extends Person {

    private int id;
    private String type;
    private static int AUTO_ID = 9999;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "entity.Writer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        this.id = AUTO_ID;
        AUTO_ID++;
        super.inputInfo();
        System.out.println("Nhập loại phóng viên: ");
        System.out.println("Vui lòng chọn 1 trong các loại dưới đây: ");
        System.out.println("1. chuyên nghiệp");
        System.out.println("2. nghiệp dư");
        System.out.println("3. cộng tác viên");
        // chọn đúng thì thôi
        int typeTemp;
        do {
            typeTemp = new Scanner(System.in).nextInt();
            if ( typeTemp >= 1 && typeTemp <=3 ) {
                break;
            }
            System.out.println("Không có loại trình độ trên, vui lòng nhập lại: ");
        }while(true);

        switch (typeTemp) {
            case 1:
                this.type = WriterType.CHUYEN_NGHIEP.value;
                break;
            case 2:
                this.type = WriterType.NGHIEP_DU.value;
                break;
            case 3:
                this.type = WriterType.CTV.value;
                break;
        }

    }
}
