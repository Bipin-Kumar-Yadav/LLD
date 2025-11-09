package MusicPlayerApplication.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import MusicPlayerApplication.model.Playlist;
import MusicPlayerApplication.model.Song;

public class RandomPlayStrategy implements PlayStrategy{
    private Playlist currentPlaylist;
    private List<Song> remainingSongs;
    private Stack<Song> history;
    private Random random;


    public RandomPlayStrategy(){
        currentPlaylist = null;
        Random random = new Random();
    }


    @Override 
    public void setPlaylist(Playlist playlist){
        currentPlaylist = playlist;
        if(currentPlaylist == null || currentPlaylist.getSize() ==0){
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        this.remainingSongs = new ArrayList<>();
        history = new Stack<>();
    }

    @Override
    public boolean hasNext(){
        return currentPlaylist!=null && !remainingSongs.isEmpty();
    }

    @Override
    public Song next(){
         if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        if (remainingSongs.isEmpty()) {
            throw new RuntimeException("No songs left to play");
        }

        int idx = random.nextInt(remainingSongs.size());
        Song nextSong = remainingSongs.get(idx);
        int lastIdx = remainingSongs.size() - 1;
        remainingSongs.set(idx, remainingSongs.get(lastIdx));
        remainingSongs.remove(lastIdx);
        history.push(nextSong);
        return nextSong;
    }

    @Override
    public boolean hasPrevious(){
        return !history.isEmpty();
    }

    @Override 
    public Song previous(){
        if(history.isEmpty()){
            throw new RuntimeException("No previous song in history.");
        }
        Song prevSong = history.pop();
        return prevSong;
    }
}
