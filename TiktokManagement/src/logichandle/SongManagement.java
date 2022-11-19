package logichandle;

import entity.Song;
import run.Main;

import java.util.Scanner;

public class SongManagement {
    //create object: Song
    public entity.Song inputSong (Scanner scanner) {

        System.out.println("Enter song's id: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter song's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter song's singer: ");
        String singer = scanner.nextLine();

        return new entity.Song(id, name, singer);
    }

}
