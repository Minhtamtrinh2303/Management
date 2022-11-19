package entity;

import entity.Follower;

import java.util.ArrayList;

public class Idol {

    private String idolName;
    private int idolId;
    private String idolEmail;
    private String group;
    private ArrayList<Follower> followers;

    public Idol(String idolName, int idolId, String idolEmail, String group, ArrayList<Follower> followers) {
        this.idolName = idolName;
        this.idolId = idolId;
        this.idolEmail = idolEmail;
        this.group = group;
        this.followers = followers;
    }

    public String getIdolName() {
        return idolName;
    }

    public void setIdolName(String idolName) {
        this.idolName = idolName;
    }

    public int getIdolId() {
        return idolId;
    }

    public void setIdolId(int idolId) {
        this.idolId = idolId;
    }

    public String getIdolEmail() {
        return idolEmail;
    }

    public void setIdolEmail(String idolEmail) {
        this.idolEmail = idolEmail;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Follower> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "idolName='" + idolName + '\'' +
                ", idolId=" + idolId +
                ", idolEmail='" + idolEmail + '\'' +
                ", group='" + group + '\'' +
                ", followers=" + followers +
                '}';
    }
}
