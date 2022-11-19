package logic_handle;

import entity.Writer;
import run.MainRun;

import java.util.Scanner;

public class WriterLogic {
//lỗi do chưa có mảng MainRun.writers ở đây
    //truy cập vào run.MainRun=>phải tạo package cho Main
    public static void showWriter() {
        for (int i = 0; i < MainRun.writers.length; i++) {
            if (MainRun.writers[i] != null) {
                System.out.println(MainRun.writers[i]);
            }
        }
    } //

    public static void addNewWriter() {
        System.out.println("Nhập số lượng phóng viên muốn thêm mới: ");
        int writerNum = new Scanner(System.in).nextInt();
        // mỗi 1 lần nhập là 1 bạn mới=>tạo ra 1 bạn mới và có thông tin
        for (int i = 0; i < writerNum; i++) {
            Writer writer = new Writer();//ENTITY
            writer.inputInfo();
            // nhập xong cho từng bạn đọc thì phải lưu
            saveWriter(writer);
        }

    } //

    public static void saveWriter(Writer writer) {
        for (int j = 0; j < MainRun.writers.length; j++) {
            if (MainRun.writers[j] == null) {
                MainRun.writers[j] = writer;//gắn =
                break;
            }
        }
    } //

    public static Writer findIdByWriter(int writerId) { //check lỗi
        //MainRun.writers[j] ko được rỗng
        Writer writer = null;
        for (int j = 0; j < MainRun.writers.length; j++) {
            if (MainRun.writers[j] != null && MainRun.writers[j].getId() == writerId) {
                writer = MainRun.writers[j];
                break;
            }
        }
        return writer;
    }


}
