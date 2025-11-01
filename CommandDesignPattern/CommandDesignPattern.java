package CommandDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface ICommand{
    void execute();
    void undo();
}
class Light{
    public void turnOn(){
        System.out.println("Light is ON");
    }
    public void turnOff(){
        System.out.println("Light is OFF");
    }
}
class Fan{
    public void start(){
        System.out.println("Fan is STARTED");
    }
    public void stop(){
        System.out.println("Fan is STOPPED");
    }
}
class LightCommand implements ICommand{
    private Light light;
    public LightCommand(Light light){
        this.light =light;
    }
    @Override
    public void execute(){
        light.turnOn();
    }
    @Override 
    public void undo(){
        light.turnOff();
    }
}
class FanCommand implements ICommand{
    private Fan fan;
    public FanCommand(Fan fan){
        this.fan =fan;
    }
    @Override
    public void execute(){
        fan.start();
    }
    @Override 
    public void undo(){
        fan.stop();
    }
}
class RemoteControl{
    protected List<ICommand> commands;
    protected List<Integer> buttonPressed;

    public RemoteControl(){
        this.commands = new ArrayList<>();
        this.buttonPressed = new ArrayList<>();
    }

    public void setCommand(ICommand command){
        commands.add(command);
        buttonPressed.add(0);
    }

    public void buttonPressed(int idx){
        if(buttonPressed.get(idx)==0){
            commands.get(idx).execute();
            buttonPressed.set(idx,1);
        }
        else{
            commands.get(idx).undo();
            buttonPressed.set(idx,0 );
        }
    }
}
public class CommandDesignPattern {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        
        Light light = new Light();
        Fan fan = new Fan();

        ICommand ligCommand = new LightCommand(light);
        ICommand fanCommand = new FanCommand(fan);

        remote.setCommand(fanCommand);
        remote.setCommand(ligCommand);

        remote.buttonPressed(0);
        remote.buttonPressed(0);
        remote.buttonPressed(1);
        remote.buttonPressed(1);
    }
}
