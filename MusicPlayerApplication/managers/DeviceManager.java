package MusicPlayerApplication.managers;

import MusicPlayerApplication.device.IAudioOutputDevice;
import MusicPlayerApplication.enums.DeviceType;
import MusicPlayerApplication.factories.DeviceFactory;

public class DeviceManager {
    private static DeviceManager instance = null;
    private IAudioOutputDevice currentDevice;

    private DeviceManager(){
        currentDevice = null;
    }

    public static DeviceManager getInstance(){
         if(instance == null){
             instance = new DeviceManager();
         }
         return instance;
    }

    public void connect(DeviceType deviceType){
        currentDevice = DeviceFactory.createDevice(deviceType);

        switch (deviceType){
            case BLUETOOTH:
                System.out.println("Connected to Bluetooth Speaker");
                break;
            case WIRED:
                System.out.println("Connected to Wired Speaker");
                break;
            case HEADPHONES:
                System.out.println("Connected to Headphones");
                break;
            default:
                throw new IllegalArgumentException("Unsupported device type: " + deviceType);
        }
    }

    public IAudioOutputDevice getOutputDevice(){
        if(currentDevice == null){
            throw new IllegalStateException("No device connected");
        }
        return currentDevice;
    }

    public boolean hasOutputDevice(){
        return currentDevice != null;
    }
}
