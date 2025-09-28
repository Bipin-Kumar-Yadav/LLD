package Inheritance;

class Car{
    
    private String brand;
    private String model;
    private boolean isEngineOn;
    private int currentSpeed;

    public Car(String brand, String model){
        this.brand=brand;
        this.model=model;
        this.isEngineOn=false;
        this.currentSpeed=0;
    }
   public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public void startEngine(){
        isEngineOn=true;
        System.out.println("Engine started.");
    }
    public void stopEngine(){
        isEngineOn=false;
        currentSpeed=0;
        System.out.println("Engine stopped.");
    }
    public void accelerate(){
        if(!isEngineOn){
            System.out.println("Start the engine first.");
            return;
        }
        currentSpeed+=10;
        System.out.println("Accelerating. Current speed: "+currentSpeed+" km/h");
    }
    public void brake(){
        currentSpeed-=10;
        if(currentSpeed<0){
            currentSpeed=0;
        }
        System.out.println("Braking. Current speed: "+currentSpeed+" km/h");
    }
}

class ManualCar extends Car{
    private int currentGear;

    public ManualCar(String brand,String model){
        super(brand,model);
        this.currentGear=0;
    }

    public void shiftGear(int gear){
        this.currentGear=gear;
        System.out.println("Shifted to gear: "+currentGear);
    }
}

class ElectricCar extends Car{
    private int batteryLevel;

    public ElectricCar(String brand,String model){
        super(brand,model);
        this.batteryLevel=100;
    }

    public void chargeBattery(int amount){
        batteryLevel+=amount;
        if(batteryLevel>100){
            batteryLevel=100;
        }
        System.out.println("Battery charged. Current level: "+batteryLevel+"%");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        ManualCar myManualCar = new ManualCar("Toyota", "Corolla");
        myManualCar.startEngine();
        myManualCar.shiftGear(1);
        myManualCar.accelerate();
        myManualCar.shiftGear(2);
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        ElectricCar myElectricCar = new ElectricCar("Tesla", "Model 3");
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.chargeBattery(20);
        myElectricCar.stopEngine(); 

    }


}
