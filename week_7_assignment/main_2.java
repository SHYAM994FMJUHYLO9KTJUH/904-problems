package week_7_assignment;
import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        songs = new String[Math.max(0, capacity)];
        count = 0;
    }

    public void addSong(String song) {
        if (song != null && count < songs.length) {
            songs[count++] = song;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class main_2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println(p.getSongCount());
    }
}
}
