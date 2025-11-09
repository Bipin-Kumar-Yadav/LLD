package MusicPlayerApplication.device;

import MusicPlayerApplication.external.WiredSpeakerAPI;
import MusicPlayerApplication.model.Song;

public class WiredSpeakerAdapter implements IAudioOutputDevice{
    private WiredSpeakerAPI wiredSpeakerAPI;

    public WiredSpeakerAdapter(WiredSpeakerAPI wiredSpeakerAPI) {
        this.wiredSpeakerAPI = wiredSpeakerAPI;
    }

    @Override
    public void playAudio(Song song){
        String payload = song.getTitle() + " by " + song.getSinger();
        wiredSpeakerAPI.playSoundViaWiredSpeaker(payload);
    }
}
