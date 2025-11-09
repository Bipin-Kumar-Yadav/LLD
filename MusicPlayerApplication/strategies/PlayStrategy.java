package MusicPlayerApplication.strategies;

import MusicPlayerApplication.model.Playlist;
import MusicPlayerApplication.model.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song next();
    boolean hasNext();
    Song previous();
    boolean hasPrevious();
    default void addToNext(Song song){};
}
