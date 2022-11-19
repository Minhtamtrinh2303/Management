package entity;

public class PostDetail {

    private Post post;
    private int quantity;

    public PostDetail(Post post, int quantity) {
        this.post = post;
        this.quantity = quantity;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PostDetail{" +
                "post=" + post +
                ", quantity=" + quantity +
                '}';
    }

}
