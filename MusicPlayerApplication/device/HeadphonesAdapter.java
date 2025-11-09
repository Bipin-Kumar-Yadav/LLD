package MusicPlayerApplication.device;

import MusicPlayerApplication.external.HeadphonesAPI;
import MusicPlayerApplication.model.Song;

public class HeadphonesAdapter implements IAudioOutputDevice {
    private HeadphonesAPI headphonesAPI;

    public HeadphonesAdapter(HeadphonesAPI headphonesAPI) {
        this.headphonesAPI = headphonesAPI;
    }

    @Override
     public void playAudio(Song song){
        String payload = song.getTitle() + " by " + song.getSinger();

        headphonesAPI.playSoundViaHeadphones(payload);
     }
}
