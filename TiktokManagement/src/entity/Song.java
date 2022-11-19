package entity;

public class Song {

    private int songId;
    private String songName;
    private String singer;

    public Song(int songId, String songName, String singer) {
        this.songId = songId;
        this.songName = songName;
        this.singer = singer;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "entity.Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}
