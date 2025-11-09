package MusicPlayerApplication.factories;

import MusicPlayerApplication.device.BluetoothSpeakerAdapter;
import MusicPlayerApplication.device.HeadphonesAdapter;
import MusicPlayerApplication.device.IAudioOutputDevice;
import MusicPlayerApplication.device.WiredSpeakerAdapter;
import MusicPlayerApplication.enums.DeviceType;
import MusicPlayerApplication.external.BluetoothSpeakerAPI;
import MusicPlayerApplication.external.HeadphonesAPI;
import MusicPlayerApplication.external.WiredSpeakerAPI;

public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType deviceType){
        switch(deviceType){
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED: 
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONES: 
                return new HeadphonesAdapter(new HeadphonesAPI());
            default:
                throw new IllegalArgumentException("Unsupported device type: " + deviceType);
        }
    }
}
