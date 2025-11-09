package MusicPlayerApplication;

import MusicPlayerApplication.core.AudioEngine;
import MusicPlayerApplication.device.IAudioOutputDevice;
import MusicPlayerApplication.enums.DeviceType;
import MusicPlayerApplication.enums.PlayStrategyType;
import MusicPlayerApplication.managers.DeviceManager;
import MusicPlayerApplication.managers.PlaylistManager;
import MusicPlayerApplication.managers.StrategyManager;
import MusicPlayerApplication.model.Playlist;
import MusicPlayerApplication.model.Song;
import MusicPlayerApplication.strategies.PlayStrategy;

public class MusicPlayerFacade {
    private static MusicPlayerFacade instance = null;
    private AudioEngine audioEngine;
    private Playlist loadedPlaylist;
    private PlayStrategy playStrategy;

    private MusicPlayerFacade(){
        loadedPlaylist = null;
        playStrategy  = null;
        audioEngine  = new AudioEngine();
    }

    public static MusicPlayerFacade getInstance(){
        if(instance == null){
            instance = new MusicPlayerFacade();
        }
        return instance;
    }

    public void connectDevice(DeviceType deviceType){
        DeviceManager.getInstance().connect(deviceType);
    }

    public void setPlayStratedy(PlayStrategyType playStrategyType){
        playStrategy = StrategyManager.getInstance().getStrategy(playStrategyType);
    }

    public void loadPlaylist(String plName){
        loadedPlaylist = PlaylistManager.getInstance().getPlaylist(plName);
        if(playStrategy == null){
            throw new RuntimeException("Play Strategy is not set");
        }
        playStrategy.setPlaylist(loadedPlaylist);
    }

    public void playSong(Song song){
        if(!DeviceManager.getInstance().hasOutputDevice()){
            throw new RuntimeException("No output device connected");
        }

        IAudioOutputDevice outputDevice = DeviceManager.getInstance().getOutputDevice();
        audioEngine.play(outputDevice, song);
    }

    public void pauseSong(Song song){
        if(!audioEngine.getCurrentSongTitle().equals(song.getTitle())){
            throw new RuntimeException("The song to be paused is not currently playing");
        }
        audioEngine.pause();
    }

    public void playAllTrack(){
        if(loadedPlaylist == null){
            throw new RuntimeException("No playlist loaded");
        }

        while(playStrategy.hasNext()){
            Song nextSong = playStrategy.next();
            IAudioOutputDevice outputDevice = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(outputDevice, nextSong);
        }
         System.out.println("Completed playlist: " + loadedPlaylist.getPlName());
    }
    public void playNextTrack() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasNext()) {
            Song nextSong = playStrategy.next();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, nextSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlName());
        }
    }

    public void playPreviousTrack() {
        if (loadedPlaylist == null) {
            throw new RuntimeException("No playlist loaded.");
        }
        if (playStrategy.hasPrevious()) {
            Song prevSong = playStrategy.previous();
            IAudioOutputDevice device = DeviceManager.getInstance().getOutputDevice();
            audioEngine.play(device, prevSong);
        } else {
            System.out.println("Completed playlist: " + loadedPlaylist.getPlName());
        }
    }

    public void enqueueNext(Song song) {
        playStrategy.addToNext(song);
    }
}
