package MusicPlayerApplication.core;

import MusicPlayerApplication.device.IAudioOutputDevice;
import MusicPlayerApplication.model.Song;

public class AudioEngine {
    private Song currentSong;
    private boolean isPlaying;

    public AudioEngine(){
        this.isPlaying = false;
        this.currentSong = null;
    }

    public String getCurrentSongTitle(){
        if(currentSong == null){
            return "No song is currently loaded.";
        }
        return currentSong.getTitle();
    }

    public boolean isPlaying(){
        return isPlaying;
    }

    public void play(IAudioOutputDevice aod, Song song){
        if(song == null){
            throw new IllegalArgumentException("Song cannot be null");
        }

        if(!isPlaying && song == currentSong){
            isPlaying = true;
            System.out.println("Resuming song: " + song.getTitle());
            aod.playAudio(song);
            return ;
        }

        currentSong= song;
        isPlaying = true;
        System.out.println("Playing song: " + song.getTitle());
        aod.playAudio(song);
    }

    public void pause(){
        if(currentSong == null ){
            throw new IllegalStateException("No song is currently playing to pause.");
        }

        if(!isPlaying){
            throw new IllegalStateException("Song is already paused.");
        }

        isPlaying = false;
        System.out.println("Paused song: " + currentSong.getTitle());
    }
}
