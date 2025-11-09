package MusicPlayerApplication.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String plName;
    private List<Song> songs;

    public Playlist(String plName){
        this.plName = plName;
        this.songs = new ArrayList<>();
    }

    public String getPlName(){
        return plName;
    }

    public List<Song> getSongs(){
        return songs;
    }

    public int getSize(){
        return songs.size();
    }

    public void addSong(Song song){
        if(song == null){
            throw new RuntimeException("plName cannot be null");
        }
        songs.add(song);
    }
}
