package logichandle;

import logichandle.FigureManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamManagement {
    /**
     * 2 teams
     * Mỗi team 5 người(5 tướng – figure)
     * @param scanner
     * @return
     */

    public entity.Team teamInfo(Scanner scanner) {

        System.out.println("Enter team's id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        /**
         * Input information for each member
         * There are 5 members in a team.
         */
        //create a list to save 5 members in a team
        ArrayList<entity.Figure> members = new ArrayList<>();
        FigureManagement figureManagement = new FigureManagement();
        for (int i = 0; i < 5; i++) {
            entity.Figure member = figureManagement.memberInfo(scanner); // input information for each member
            members.add(member); // add each member to the list
        }
        return new entity.Team(id, members);
    }
}
