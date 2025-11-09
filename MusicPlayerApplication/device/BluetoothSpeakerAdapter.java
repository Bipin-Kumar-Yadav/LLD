package MusicPlayerApplication.device;

import MusicPlayerApplication.external.BluetoothSpeakerAPI;
import MusicPlayerApplication.model.Song;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice{
    private BluetoothSpeakerAPI bluetoothSpeakerAPI;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI bluetoothSpeakerAPI) {
        this.bluetoothSpeakerAPI = bluetoothSpeakerAPI;
    }

    @Override
    public void playAudio(Song song){
        String payload = song.getTitle() + " by " + song.getSinger();
        bluetoothSpeakerAPI.playSoundViaBluetooth(payload);
    }
}
