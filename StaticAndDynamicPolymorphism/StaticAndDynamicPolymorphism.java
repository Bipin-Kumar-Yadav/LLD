package StaticAndDynamicPolymorphism;

abstract class Car{
    private String brand;
    private String model;
    private boolean isEngineOn;
    private int currentSpeed;

    public Car(String brand,String model){
        this.brand=brand;
        this.model=model;
        this.isEngineOn=false;
        this.currentSpeed=0;
    }
    public String getBrand() 
    {
        return brand;
    }
    public String getModel(){
         return model;
    }
    public void setCurrentSpeed(int speed){
        this.currentSpeed=speed;
    }
    public boolean isEngineOn(){
        return isEngineOn;
    }
    public int getCurrentSpeed(){
        return currentSpeed;
    }

    public void startEngine(){
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    public void stopEngine(){
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
    public abstract void accelerate();
    public abstract void accelerate(int increment);
    public abstract void brake();
}

class ManualCar extends Car{
    private int currentGear;
    public ManualCar(String brand,String model){
        super(brand,model);
        this.currentGear = 0;
    }
    public void shiftGear(int gear){
        if(gear < 0){
            System.out.println("Invalid gear. Gear cannot be negative.");
            return;
        }
        if(gear > currentGear +1 || gear < currentGear -1){
            System.out.println("Invalid gear shift. You can only shift to adjacent gears.");
            return;
        }
        this.currentGear = gear;
        if(currentGear<0) currentGear=0;

        System.out.println(getBrand() + " " + getBrand() + " : Shifted to gear " + currentGear);
    }

    @Override 
    public void accelerate(){
        if(!isEngineOn()){
            System.out.println("Start the engine first.");
            return;
        }
        setCurrentSpeed(getCurrentSpeed() + 20);
        System.out.println(getBrand() + " " + getModel() + " : Accelerating to " + getCurrentSpeed() + " km/h");
    }

    @Override
    public void accelerate(int increment){
        if(!isEngineOn()){
            System.out.println("Start the engine first.");
            return;
        }
        setCurrentSpeed(getCurrentSpeed() + increment);
        System.out.println(getBrand() + " " + getModel() + " : Accelerating to " + getCurrentSpeed() + " km/h");
    }
    @Override
    public void brake(){
        setCurrentSpeed(getCurrentSpeed() - 20);
        if(getCurrentSpeed()<0){
            setCurrentSpeed(0); 
        }
        System.out.println(getBrand() + " " + getModel() + " : Braking! Speed is now " + getCurrentSpeed() + " km/h");
    }
}
class ElectricCar extends Car{
    private int batteryLevel;
    public ElectricCar(String brand,String model){
        super(brand,model);
        this.batteryLevel= 50;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(getBrand() + " " + getModel() + " : Battery fully charged!");
    }

    @Override
    public void accelerate(){
        if(!isEngineOn()){
            System.out.println("Start the engine first.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(getBrand() + " " + getModel() + " : Battery dead! Cannot accelerate.");
            return;
        }
        setCurrentSpeed(getCurrentSpeed()+15);
        batteryLevel -= 5;
        System.out.println(getBrand() + " " + getModel() + " : Accelerating to " + getCurrentSpeed() +
                           " km/h. Battery at " + batteryLevel + "%.");
    }

    @Override
    public void accelerate(int increment){
        if(!isEngineOn()){
            System.out.println("Start the engine first.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(getBrand() + " " + getModel() + " : Battery dead! Cannot accelerate.");
            return;
        }
        setCurrentSpeed(getCurrentSpeed()+increment);
        batteryLevel -= 5+increment;
        System.out.println(getBrand() + " " + getModel() + " : Accelerating to " + getCurrentSpeed() +
                           " km/h. Battery at " + batteryLevel + "%.");
    }

    @Override
    public void brake(){
        setCurrentSpeed(getCurrentSpeed() - 15);
        if(getCurrentSpeed()<0){
            setCurrentSpeed(0); 
        }
        System.out.println(getBrand() + " " + getModel() +
                           " : Regenerative braking! Speed is now " + getCurrentSpeed() +
                           " km/h. Battery at " + batteryLevel + "%.");
    }
}
public class StaticAndDynamicPolymorphism {
    public static void main(String[] args) {
        ManualCar manualCar = new ManualCar("Toyota", "Corolla");
        manualCar.startEngine();
        manualCar.shiftGear(1);
        manualCar.accelerate();
        manualCar.accelerate(30);
        manualCar.brake();
        manualCar.stopEngine();


        ElectricCar electricCar = new ElectricCar("Tesla", "Model 3");
        electricCar.startEngine();
        electricCar.accelerate();
        electricCar.accelerate(25);
        electricCar.brake();
        electricCar.chargeBattery();
        electricCar.stopEngine();   
    }
}
