import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import entity.LessonManagement;
import entity.LessonManagementDetail;
import entity.Subject;
import entity.Teacher;

import java.util.Locale;
import java.util.Scanner;

public class MainRun {

    public static Teacher[] teachers = new Teacher[100];
    public static Subject[] subjects = new Subject[100];
    public static LessonManagement[] LessonManagements = new LessonManagement[200];

    public static void main(String[] args) {
        while (true) { // cho vào lặp vô hạn
            showMenu();
            int functionChoice = chooseFunction();
            logicHandle(functionChoice);
        }
    }

    private static void logicHandle(int functionChoice) {
        switch (functionChoice) {
            case 1:
                addNewTeacher();
                break;
            case 2:
                showAllTeacher();
                break;
            case 3:
                addNewLesson();
                break;
            case 4:
                showAllLesson();
                break;
            case 5:
                lessonManagement();
                showLessonManagement();
                break;
            case 6:
                sortTeaching();
                break;
            case 7:
                salaryCalculation();
                break;
            case 8:
                System.exit(0);
        }
    }

    private static void salaryCalculation() {
    }

    private static void sortTeaching() {
        //Theo họ tên giảng viên
        //Theo số tiết giảng dạy mỗi môn (giảm dần)
        System.out.println("Nhập lựa chọn của bạn: ");
        System.out.println("1. Sắp xếp theo họ tên giảng viên");
        System.out.println("2. Sắp xếp theo số tiết giảng dạy mỗi môn (giảm dần)");
        int choice;//
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        if (choice == 1) { // sắp xếp theo tên giảng viên
            for (int i = 0; i < teachers.length - 1; i++) {
                if (teachers[i] == null) { //
                    continue;
                }
                for (int j = i + 1; j < teachers.length; j++) {
                    if (teachers[j] == null) {
                        continue;
                    }
                    if (teachers[i].getName().compareTo(teachers[j].getName()) > 0) {
                        Teacher temp = teachers[i];
                        teachers[i] = teachers[j];
                        teachers[j] = temp;
                    }
                }
            }
            // in ra danh sách sau khi sắp xếp
        } else if (choice == 2) { // sắp xếp theo số lượng cuốn sách


        }
    }

    private static void showLessonManagement() {
        for (int i = 0; i < LessonManagements.length; i++) {
            if (LessonManagements[i] != null) {
                System.out.println(LessonManagements[i]);
            }
        }
    }

    private static void lessonManagement() {
        //Phải có môn học và phải có giảng viên mới phân công được
        if (teachers.length == 0 || subjects.length == 0 ) {
            System.out.println("Bạn cần có thông tin về giảng viên và môn học trước");
            return;
        }


        System.out.println("Bạn muốn phân công giảng dạy cho mấy giảng viên:");
        int teacherNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNum; i++) {
            System.out.println("Phân công giảng dạy cho giảng viên thứ " + (i+1));
            System.out.println("Nhập mã giảng viên muốn phân công: ");
            int teacherId;
            Teacher teacher = null;//để ngoài
            do{
                teacherId = new Scanner(System.in).nextInt();
                //kiểm tra Id có tồn tại? kiểm tra đúng thì thôi
                for (int j = 0; j < teachers.length; j++) {
                    if (teachers[j].getId() == teacherId) {
                        teacher = teachers[j];
                        break; // tìm thấy rồi
                    }
                }
                if (teacher != null) {
                    break;
                }
                System.out.println("Không tìm thấy giảng viên mang mã " +teacherId +", vui lòng nhập lại");
            }while(true);


            System.out.println("giảng viên này muốn dạy bao nhiêu môn?");
            int subjectNum = new Scanner(System.in).nextInt();
            /**
             *
             */
            LessonManagementDetail[] detail = new LessonManagementDetail[subjectNum];
            int count = 0;
            //
            int sum = 0;

            for (int j = 0; j < subjectNum; j++) {
                System.out.println("Nhập thông tin môn học thứ " + (j + 1) + "mà giảng viên " + teacher.getName() + "muốn dạy");
                System.out.println("Nhập mã môn học: ");
                int subjectId;
                Subject subject = null;//để ngoài
                do{
                    subjectId = new Scanner(System.in).nextInt();
                    //kiểm tra Id có tồn tại? kiểm tra đúng thì thôi
                    for (int k = 0; k < subjects.length; k++) {
                        if (subjects[j].getId() == subjectId) {
                            subject = subjects[k];
                            break; // tìm thấy rồi
                        }
                    }
                    if (subject != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy môn học mang mã " +subjectId +", vui lòng nhập lại");
                }while(true);


                System.out.println("Môn này ông muốn dạy mấy lớp: ");
                int classNum;
                // Số lớp cho mỗi môn là số nguyên dương và không lớn hơn 3
                do {
                    classNum = new Scanner(System.in).nextInt();
                    if (classNum > 0 && classNum <=3) {
                        break;
                    }
                    System.out.println("Số lớp cho mỗi môn là số nguyên dương và không lớn hơn 3, vui lòng nhập lại");
                }while(true);


                // lưu môn học, số lớp muốn dạy: tạo mảng môn, tạo count dể đếm môn
                detail[count] = new LessonManagementDetail(subject, classNum);
                sum += subject.getLessonQuantity() * classNum;
                do{
                    if (sum > 200) {
                        System.out.println("Tổng số tiết không được vượt quá 200, bạn không được nhập môn này nữa.");
                        break; // thoát khỏi vòng lặp, vẫn lưu số tiết nhập lúc trước đó
                    }
                }while(true);

                count++;

            }
            //lưu thông tin cho 1 giáo viên
            LessonManagement lessonManagement = new LessonManagement(teacher, detail);
            saveLessonInfo(lessonManagement);
        }

    }

    private static void saveLessonInfo(LessonManagement lessonManagement) {
        for (int j = 0; j < LessonManagements.length; j++) {
            if (LessonManagements[j] == null) {
                LessonManagements[j] = lessonManagement;//gắn =
                break;
            }
        }

    }

    private static void showAllLesson() {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                System.out.println(subjects[i]);
            }
        }
    }

    private static void addNewLesson() {
        System.out.println("Nhập số lượng môn học muốn thêm mới: ");
        int subjectNum = new Scanner(System.in).nextInt();
        // mỗi 1 lần nhập là 1 bạn mới=>tạo ra 1 bạn mới và có thông tin
        for (int i = 0; i < subjectNum; i++) {
            Subject subject = new Subject();//ENTITY
            subject.subjectInfo();
            // nhập xong cho từng bạn đọc thì phải lưu
            saveSubject(subject);
        }
    }

    private static void saveSubject(Subject subject) {
        for (int j = 0; j < subjects.length; j++) {
            if (subjects[j] == null) {
                subjects[j] = subject;//gắn =
                break;
            }
        }
    }

    private static void showAllTeacher() {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                System.out.println(teachers[i]);
            }
        }
    }

    private static void addNewTeacher() {
        System.out.println("Nhập số lượng giảng viên muốn thêm mới: ");
        int teacherNum = new Scanner(System.in).nextInt();
        // mỗi 1 lần nhập là 1 bạn mới=>tạo ra 1 bạn mới và có thông tin
        for (int i = 0; i < teacherNum; i++) {
            Teacher teacher = new Teacher();//ENTITY
            teacher.teacherInfo();
            // nhập xong cho từng bạn đọc thì phải lưu
            saveTeacher(teacher);
        }
    }

    private static void saveTeacher(Teacher teacher) {
        for (int j = 0; j < teachers.length; j++) {
            if (teachers[j] == null) {
                teachers[j] = teacher;//gắn =
                break;
            }
        }
    }

    private static int chooseFunction() {
        System.out.print("Xin mời chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.println("Chức năng không hợp lệ, vui lòng nhập lại: ");
        } while (true);
        //nhập đúng thì thôi
        return functionChoice;
    }

    private static void showMenu() {
        System.out.println("-----PHẦN MỀM QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THỈNH GIẢNG----");
        System.out.println("1. Nhập danh sách giảng viên mới");
        System.out.println("2. In ra danh sách giảng viên.");
        System.out.println("3. Nhập danh sách môn học mới.");
        System.out.println("4. In ra danh sách môn học.");
        System.out.println("5. Lập Bảng kê khai giảng dạy cho mỗi giảng viên");
        System.out.println("6. Sắp xếp  danh sách kê khai giảng dạy .");
        System.out.println("7. Tính toán và lập bảng tính tiền công cho mỗi giảng viên");
        System.out.println("8. Thoát chương trình.");
    }

    /**
     * phương pháp tìm kiếm
     */
    public static void search(){
        String keyword = new Scanner(System.in).nextLine();
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null && teachers[i].getName().toLowerCase().contains(keyword.toLowerCase()));
            System.out.println("teachers[i]");
        }
    }

}

// tách hàm
// sắp xếp
//tính toán lập bảng kê khai

