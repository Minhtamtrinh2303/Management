package entity;

import Constant.TeacherLevel;
import entity.Person;

import java.util.Scanner;

public class Teacher extends Person {

    private int id; //
    private String level; //

    private static int AUTO_ID = 0;
    public Teacher() {
        if (AUTO_ID == 0) {
            AUTO_ID = 99;
        }
        AUTO_ID++;
        this.id = AUTO_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "entity.Teacher{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public void teacherInfo() {
        super.teacherInfo();
        System.out.println("Nhập trình độ giáo viên: ");
        System.out.println("Vui lòng chọn 1 trong các loại dưới đây: ");
        System.out.println("1. GS_TS");
        System.out.println("2. PGS_TS");
        System.out.println("3. GVC");
        System.out.println("4. TS");
        // chọn đúng thì thôi
        int teacherTypeTemp;
        do {
            teacherTypeTemp = new Scanner(System.in).nextInt();
            if ( teacherTypeTemp >= 1 && teacherTypeTemp <=4 ) {
                break;
            }
            System.out.println("Không có loại trình độ trên, vui lòng nhập lại: ");
        }while(true);
        switch (teacherTypeTemp) {
            case 1:
                this.level = TeacherLevel.GS_TS.value;
                break;
            case 2:
                this.level = TeacherLevel.PGS_TS.value;
                break;
            case 3:
                this.level = TeacherLevel.GVC.value;
                break;
            case 4:
                this.level = TeacherLevel.TS.value;
                break;
        }
    }
}
