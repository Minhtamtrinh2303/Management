package run;

import logichandle.TeamManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class SummonRiftMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //create a list of each team - 2 teams
        ArrayList<entity.Team> teams = new ArrayList<>();
        TeamManagement teamManagement = new TeamManagement();

        for (int i = 0; i < 2; i++) {
            entity.Team team = teamManagement.teamInfo(scanner); // input information for each team
            teams.add(team); //add a team to the list
        }

        System.out.println("What time does the match start");
        String time = scanner.nextLine();

        entity.SummonRift summonRift = new entity.SummonRift(teams, time);
        System.out.println(summonRift.toString());
    }
}
