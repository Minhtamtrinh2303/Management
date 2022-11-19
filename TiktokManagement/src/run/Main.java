package run;

import entity.Idol;
import entity.Song;
import entity.Tiktok;
import logichandle.IdolManagement;
import logichandle.SongManagement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Tạo lớp Tiktok: các idols, các bài hát(Songs)
 */

public class Main {
    //create list to save idols, songs
    public static ArrayList<Idol> idols = new ArrayList<>();
    public static ArrayList<Song> songs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IdolManagement idolManagement = new IdolManagement();
        SongManagement songManagement = new SongManagement();

        System.out.println("How many idols do you want to add information? ");
        Integer idolNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < idolNumber; i++) {
            Idol idol = idolManagement.inputIdol(scanner); //input information for each idol
            idols.add(idol); // add idol to the list
        }

        System.out.println("How many songs do you want to add information? ");
        Integer songNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < songNumber; i++) {
            Song song = songManagement.inputSong(scanner); //input information for each song
            songs.add(song); // add song to the list
        }

        Tiktok tiktok = new Tiktok(idols, songs);
        System.out.println(tiktok.toString());

    }

}
