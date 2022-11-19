package logichandle;

import entity.Follower;

import java.util.Scanner;

public class FollowerManagement {
    // create object: Follower
    public entity.Follower inputFollower(Scanner scanner) {

        System.out.println("Enter follower's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter follower's id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter follower's email: ");
        String email = scanner.nextLine();

        System.out.println("Enter the number of like: ");
        int number = Integer.parseInt(scanner.nextLine());

        return new Follower(name, id, email, number);
    }
}
