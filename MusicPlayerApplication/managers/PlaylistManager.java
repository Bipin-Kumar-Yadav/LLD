package MusicPlayerApplication.managers;

import java.util.HashMap;
import java.util.Map;

import MusicPlayerApplication.model.Playlist;
import MusicPlayerApplication.model.Song;

public class PlaylistManager {
    private static PlaylistManager instance = null;
    private Map<String, Playlist> playlists;


    private PlaylistManager(){
        playlists = new HashMap<>();
    }

    public static PlaylistManager getInstance(){
        if(instance == null){
            instance = new PlaylistManager();
        }
        return instance;
    }

    public void createPlaylist(String plName){
        if(playlists.containsKey(plName)){
            throw new RuntimeException("Playlist with name " + plName + " already exists");
        }

        playlists.put(plName,new Playlist(plName));
    }

    public void addSongsToPlaylist(String plName, Song song){
        if(!playlists.containsKey(plName)){
            throw new RuntimeException("Playlist with name " + plName + " does not exists");
        }

       if(song == null){
            throw new RuntimeException("Song cannot be null");
        }

       playlists.get(plName).addSong(song);
    }

    public Playlist getPlaylist(String plName){
        if(!playlists.containsKey(plName)){
            throw new RuntimeException("Playlist with name " + plName + " does not exists");
        }
        return playlists.get(plName);
    }
}
