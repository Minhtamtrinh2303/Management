package logichandle;

import entity.Follower;
import entity.Idol;
import run.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class IdolManagement {
    //create object: Idol
    public entity.Idol inputIdol(Scanner scanner) {

        ArrayList<Follower> followers = new ArrayList<>(); // create list to save followers

        FollowerManagement followerManagement = new FollowerManagement();
        System.out.println("How many followers does Idol have: ");
        Integer followerNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < followerNumber ; i++) {
            Follower follower = followerManagement.inputFollower(scanner); // input information for each follower
            followers.add(follower); // add to list
        }

        System.out.println("Enter idol's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter idol's id: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter idol's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter idol's group: ");
        String group = scanner.nextLine();

        return new entity.Idol(name, id, email, group, followers);
    }

}
