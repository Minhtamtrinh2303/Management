package run;

import entity.Post;
import entity.PostDetail;
import entity.PostManagement;
import entity.Writer;
import logic_handle.PostManagementLogic;
import logic_handle.WriterLogic;

import java.util.Scanner;

public class MainRun {

    public static Writer[] writers = new Writer[1000];
    public static Post[] posts = new Post[2000];
    public static PostManagement[] postManagements = new PostManagement[2000];


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
                WriterLogic.addNewWriter();
                break;
            case 2:
                WriterLogic.showWriter();
                break;
            case 3:
                addNewPost();
                break;
            case 4:
                showPost();
                break;
            case 5: //
                PostManagementLogic.addNewPostManagement();
                PostManagementLogic.showPostManagement();
                break;
            case 6:
                showSortMenu();
                break;
            case 7:
                PostManagementLogic.calculateSalary();
                break;
            case 8:
                System.exit(0);
        }
    }



    private static void showSortMenu() {
        System.out.println("Nhập lựa chọn của bạn: ");
        System.out.println("1. Sắp xếp theo họ tên phóng viên");
        System.out.println("2. Sắp xếp theo số lượng bài viết (giảm dần)");
        System.out.println("3. Thoát ra ngoài menu chính.");
        int choice;//
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (choice) {
            case 1:
                PostManagementLogic.sortbyWriterName();
                break;
            case 2:
                PostManagementLogic.sortbyPostNumber();
                break;
            case 3:
                return;
        }

    }

    //PostManagementLogic
    //WriterLogic
    // PostLogic
    public static Post findIdByPost(int postId) { //check lỗi
        Post post = null;
        for (int k = 0; k < posts.length; k++) {
            if (posts[k] != null && posts[k].getId() == postId) {
                post = posts[k];
                break; // tìm thấy rồi
            }
        }
        return post;
    }

    private static void showPost() {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null) {
                System.out.println(posts[i]);
            }
        }
    } //

    private static void addNewPost() {
        System.out.println("Nhập số lượng bài viết muốn thêm mới: ");
        int postNum = new Scanner(System.in).nextInt();
        // mỗi 1 lần nhập là 1 bạn mới=>tạo ra 1 bạn mới và có thông tin
        for (int i = 0; i < postNum; i++) {
            Post post = new Post();//ENTITY
            post.inputInfo();
            // nhập xong cho từng bạn đọc thì phải lưu
            savePost(post);
        }
    } //

    private static void savePost(Post post) {
        for (int j = 0; j < posts.length; j++) {
            if (posts[j] == null) {
                posts[j] = post;//gắn =
                break;
            }
        }
    } //




    private static int chooseFunction() {
        System.out.print("Xin mời chọn chức năng: ");
        int choice = 0; //**
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.print("Chức năng vừa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return choice;
    } //

    private static void showMenu() {
        System.out.println("----PHẦN MỀM QUẢN LÝ TRẢ NHUẬN BÚT CHO PHÓNG VIÊN-----");
        System.out.println("1. Nhập danh sách phóng viên mới.");
        System.out.println("2. Hiển thị danh sách phóng viên.");
        System.out.println("3. Nhập danh sách bài viết mới.");
        System.out.println("4. Hiển thị danh sách bài viết.");
        System.out.println("5. Lập bảng tính công.");
        System.out.println("6. Sắp xếp bảng tính công.");
        System.out.println("7. Tính lương.");
        System.out.println("8. Thoát.");
    } //
}
