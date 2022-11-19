package logichandle;

import java.util.Scanner;

public class FigureManagement {
    /**
     * Mỗi team 5 người(5 tướng – figure)
     * Mỗi vị tướng sẽ bao gồm các thuộc tính: id, name, position
     * @param scanner
     * @return
     */
    public entity.Figure memberInfo(Scanner scanner) {
        System.out.println("Enter member's id:  ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter member's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter member's position: ");
        String position = scanner.nextLine();

        return new entity.Figure(id, name, position);
    }
}
