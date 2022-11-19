package entity;

import java.util.ArrayList;

public class SummonRift {

    private ArrayList<Team> teams;
    private String time;

    public SummonRift(ArrayList<Team> teams, String time) {
        this.teams = teams;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "entity.SummonRift{" +
                "teams=" + teams +
                ", time='" + time + '\'' +
                '}';
    }
}
