package MusicPlayerApplication.device;

import MusicPlayerApplication.model.Song;

public interface IAudioOutputDevice {
    void playAudio(Song song);
}
