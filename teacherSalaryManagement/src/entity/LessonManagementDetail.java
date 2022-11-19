package entity;

public class LessonManagementDetail {
    /**
     * 1 môn
     * nhiều lớp
     */
    private Subject subject;
    private int classNumber;

    //constructor có tham số
    public LessonManagementDetail(Subject subject, int classNumber) {
        this.subject = subject;
        this.classNumber = classNumber;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "LessonManagementDetail{" +
                "subject=" + subject +
                ", classNumber=" + classNumber +
                '}';
    }


}
