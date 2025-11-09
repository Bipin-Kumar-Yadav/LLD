package MusicPlayerApplication;

import java.util.ArrayList;

import MusicPlayerApplication.enums.DeviceType;
import MusicPlayerApplication.enums.PlayStrategyType;
import MusicPlayerApplication.managers.PlaylistManager;
import MusicPlayerApplication.model.Song;

public class MusicPlayerApp {
     private static MusicPlayerApp instance = null;
    private java.util.List<Song> songLibrary;

    private MusicPlayerApp() {
        songLibrary = new ArrayList<>();
    }

    public static synchronized MusicPlayerApp getInstance() {
        if (instance == null) {
            instance = new MusicPlayerApp();
        }
        return instance;
    }

    public void createSongInLibrary(String title, String artist, String path) {
        Song newSong = new Song(title, artist, path);
        songLibrary.add(newSong);
    }

    public Song findSongByTitle(String title) {
        for (Song s : songLibrary) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }

    public void createPlaylist(String playlistName) {
        PlaylistManager.getInstance().createPlaylist(playlistName);
    }

    public void addSongToPlaylist(String playlistName, String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found in library.");
        }
        PlaylistManager.getInstance().addSongsToPlaylist(playlistName, song);
    }

    public void connectAudioDevice(DeviceType deviceType) {
        MusicPlayerFacade.getInstance().connectDevice(deviceType);
    }

    public void selectPlayStrategy(PlayStrategyType strategyType) {
        MusicPlayerFacade.getInstance().setPlayStratedy(strategyType);
    }

    public void loadPlaylist(String playlistName) {
        MusicPlayerFacade.getInstance().loadPlaylist(playlistName);
    }

    public void playSingleSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().playSong(song);
    }

    public void pauseCurrentSong(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().pauseSong(song);
    }

    public void playAllTracksInPlaylist() {
        MusicPlayerFacade.getInstance().playAllTrack();
    }

    public void playPreviousTrackInPlaylist() {
        MusicPlayerFacade.getInstance().playPreviousTrack();
    }

    public void queueSongNext(String songTitle) {
        Song song = findSongByTitle(songTitle);
        if (song == null) {
            throw new RuntimeException("Song \"" + songTitle + "\" not found.");
        }
        MusicPlayerFacade.getInstance().enqueueNext(song);
    }
}
