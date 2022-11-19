package entity;

public class Follower {

    private String followerName;
    private int followerId;
    private String followerEmail;
    private int numberOfLike;

    public Follower(String followerName, int followerId, String followerEmail, int numberOfLike) {
        this.followerName = followerName;
        this.followerId = followerId;
        this.followerEmail = followerEmail;
        this.numberOfLike = numberOfLike;
    }

    public String getFollowerName() {
        return followerName;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public String getFollowerEmail() {
        return followerEmail;
    }

    public void setFollowerEmail(String followerEmail) {
        this.followerEmail = followerEmail;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "followerName='" + followerName + '\'' +
                ", followerId=" + followerId +
                ", followerEmail='" + followerEmail + '\'' +
                ", numberOfLike=" + numberOfLike +
                '}';
    }
}
