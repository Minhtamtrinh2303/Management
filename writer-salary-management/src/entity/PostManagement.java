package entity;

import java.util.Arrays;

public class PostManagement {

    private Writer writer;
    PostDetail[] postDetails;

    private int totalPost;

    public int getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(int total) {
        this.totalPost = total;
    }

    public PostManagement(Writer writer, PostDetail[] postDetails) {
        this.writer = writer;
        this.postDetails = postDetails;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public PostDetail[] getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetail[] postDetails) {
        this.postDetails = postDetails;
    }

    @Override
    public String toString() {
        return "PostManagement{" +
                "writer=" + writer +
                ", postDetails=" + Arrays.toString(postDetails) +
                '}';
    }
}
