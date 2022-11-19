package logic_handle;

import entity.Post;
import entity.PostDetail;
import entity.PostManagement;
import entity.Writer;
import run.MainRun;
import sun.applet.Main;

import java.util.Scanner;

public class PostManagementLogic {

    public static void showPostManagement() {
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            if (MainRun.postManagements[i] != null) {
                System.out.println(MainRun.postManagements[i]);
            }
        }
    }

    public static void addNewPostManagement() {
        if (MainRun.writers.length == 0 || MainRun.posts.length == 0 ) {
            System.out.println("Bạn cần có thông tin về phóng viên và bài viết trước");
            return;
        }

        System.out.println("Lập bảng tính công cho bao nhiêu phóng viên: ");
        int temp = new Scanner(System.in).nextInt();
        for (int i = 0; i < temp; i++) {
            System.out.println("Nhập thông tin tính công cho phóng viên thứ " + (i + 1));
            System.out.println("Nhập mã phóng viên muốn tính công: ");
            int writerId; //note
            Writer writer = null;//note
            do {
                writerId = new Scanner(System.in).nextInt();
                //hàm tách 1
                writer = WriterLogic.findIdByWriter(writerId); // cách tách hàm

                if (writer != null) {
                    break;
                }
                System.out.println("Không tìm thấy phóng viên mang mã " + writerId + ", vui lòng nhập lại");
            } while (true);



            System.out.println("Nhập số lượng bài viết đã viết: ");
            int postNum;
            do{
                postNum = new Scanner(System.in).nextInt();
                // chú ý: ko được vượt quá số bài trong hệ thống
                if (postNum > 0 && postNum <=5 && postNum <= MainRun.posts.length) {
                    break;
                }
                System.out.println("Mỗi phóng viên chỉ được tham gia viết tối đa 5 kiểu bài khác nhau.");
                System.out.println("Vui lòng nhập lại.");
            }while(true);


            //lưu thông tin vào mảng
            PostDetail[] postDetails = new PostDetail[postNum];
            //
            int count = 0;

            for (int j = 0; j < postNum; j++) {
                System.out.println("Nhập thông tin bài viết thứ " + (j + 1) + "mà phóng viên " + writer.getName() + "muốn viết");
                System.out.println("Nhập mã bài viết: ");
                int postId;
                Post post = null;//để ngoài
                do {
                    postId = new Scanner(System.in).nextInt();
                    post = MainRun.findIdByPost(postId);
                    if (post == null) {
                        System.out.println("Không tìm thấy bài viết mang mã " + postId + ", vui lòng nhập lại");
                        continue; //chạy lại lên trên, vì ko tìm thấy thì kiểm tra làm gì nữa
                    }
                    boolean inputOrNot = false;
                    // count = > postDetails.length <
                    //postDetails[k] != null
                    for (int k = 0; k < count; k++) {
                        if (postDetails[k].getPost().getId() == postId) {
                            inputOrNot = true;
                            break;
                        }
                    }
                    if (! inputOrNot) {
                        break;
                    }
                    System.out.println("Loại bài này bạn vừa mới nhập xong.");
                } while (true);
                //Một phóng viên với cùng một kiểu bài không được phép xuất hiện quá một lần trong bảng này




                System.out.println("Nhập số lượng bài ở thể loại này đã viết: ");
                int quantity = new Scanner(System.in).nextInt();
                //
                postDetails[count] = new PostDetail(post, quantity);
                count++;

            }
            PostManagement postManagement = new PostManagement(writer, postDetails);
            savePostManagement(postManagement);
        }

    }

    public static void savePostManagement(PostManagement postManagement) {
        for (int j = 0; j < MainRun.postManagements.length; j++) {
            if (MainRun.postManagements[j] == null) {
                MainRun.postManagements[j] = postManagement;//gắn =
                break;
            }
        }
    }

    public static void sortbyPostNumber() { // khó
        //phải có biến để lưu => PostManagement
        //tính tổng số lượng bài viết mà 1 phóng viên đã viết
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            PostManagement postManagement = MainRun.postManagements[i];
            PostDetail[] postDetails = postManagement.getPostDetails();
            int total = 0;
            for (int j = 0; j < postDetails.length; j++) {
                total += postDetails[j].getQuantity();
            }
            postManagement.setTotalPost(total);
        }
        //3 dòng

        for (int i = 0; i < MainRun.postManagements.length - 1; i++) {
            // chekk null
            for (int j = i + 1; j < MainRun.postManagements.length ; j++) {
                PostManagement post1 = MainRun.postManagements[i];
                PostManagement post2 = MainRun.postManagements[i];
                if (post1.getTotalPost() < post2.getTotalPost() ) {
                    PostManagement temp = post1;
                    post1 = post2;
                    post2 = temp;
                }
            }
        }

    }



    public static void sortbyWriterName() { //null

        for (int i = 0; i < MainRun.postManagements.length - 1; i++) {
            //check null: 2 lỗi null
            for (int j = i + 1; j < MainRun.postManagements.length ; j++) {
                PostManagement post1 = MainRun.postManagements[i];
                PostManagement post2 = MainRun.postManagements[i];
                if (post1.getWriter().getName().compareTo(post2.getWriter().getName()) > 0 ) {
                    PostManagement temp = post1;
                    post1 = post2;
                    post2 = temp;
                }
            }
        }

    }


    public static void calculateSalary() {
        //Lập bảng kê thu nhập của mỗi phóng viên
        for (int i = 0; i < MainRun.postManagements.length; i++) {
            //check null
            if (MainRun.postManagements[i] == null) {
                continue;
            }
            double salary = 0;
            //
            Writer writer = MainRun.postManagements[i].getWriter();
            PostDetail[] postDetails = MainRun.postManagements[i].getPostDetails();
            for (int j = 0; j < postDetails.length; j++) {
                salary += postDetails[j].getPost().getPrice() * postDetails[j].getQuantity();
            }
            System.out.println("Lương của phóng viên" +writer.getName() + "là " +salary);
        }
    }


}
