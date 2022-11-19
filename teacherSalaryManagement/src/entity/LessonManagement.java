package entity;

import java.util.Arrays;

public class LessonManagement {


    private Teacher teacher;
    private LessonManagementDetail[] lessonManagementDetails;

    public LessonManagement(Teacher teacher, LessonManagementDetail[] lessonManagementDetails) {
        this.teacher = teacher;
        this.lessonManagementDetails = lessonManagementDetails;
    }

    // 1 mảng

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LessonManagementDetail[] getLessonManagementDetails() {
        return lessonManagementDetails;
    }

    public void setLessonManagementDetails(LessonManagementDetail[] lessonManagementDetails) {
        this.lessonManagementDetails = lessonManagementDetails;
    }

    @Override
    public String toString() {
        return "LessonManagement{" +
                "teacher=" + teacher +
                ", lessonManagementDetails=" + Arrays.toString(lessonManagementDetails) +
                '}';
    }


}
