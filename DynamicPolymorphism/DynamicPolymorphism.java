package DynamicPolymorphism;

abstract class Car{
    private String brand;
    private String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

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
        isEngineOn = true;
        System.out.println("Engine started.");
    }

    public void stopEngine(){
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println("Engine stopped.");
    }

    public abstract void accelerate();
    public abstract void breake();
}

class ManualCar extends Car{
    private int currentGear;
    public ManualCar(String brand,String model){
        super(brand,model);
        this.currentGear=0;
    }
    @Override
    public void accelerate(){
        if(!isEngineOn){
            System.out.println("Start the engine first.");
            return;
        }
        currentSpeed+=20;
        System.out.println(getBrand() + " " + getModel() + " : Accelerating to " + currentSpeed + " km/h");
    }

    @Override
    public void breake(){
        currentSpeed-=20;
        if(currentSpeed<0){
            currentSpeed=0;
        }
         System.out.println(getBrand() + " " + getModel() + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void shiftGear(int gear){
        if(!isEngineOn){
            System.out.println("Start the engine first.");
            return;
        }
        currentGear=gear;
        System.out.println("Shifted to gear: "+currentGear);
    }
}

class ElectricCar extends Car{
    private int batteryLevel;
    public ElectricCar(String brand,String model){
        super(brand,model);
        this.batteryLevel=50;
    }
    @Override
    public void accelerate(){
        if(!isEngineOn){
            System.out.println("Start the engine first.");
            return;
        }
        if(batteryLevel<=0){
            System.out.println(getBrand() + " " + getModel() + " : Battery dead! Cannot accelerate.");

            return;
        }
        currentSpeed+=15;
        batteryLevel-=5;
        System.out.println(getBrand() + " " + getModel() + " : Accelerating to " + currentSpeed
                           + " km/h. Battery at " + batteryLevel + "%.");
    }
    @Override
    public void breake(){
        currentSpeed-=15;
        if(currentSpeed<0){
            currentSpeed=0;
        }
        System.out.println(getBrand() + " " + getModel() + " : Regenerative braking! Speed is now "
                           + currentSpeed + " km/h. Battery at " + batteryLevel + "%.");
    }

    public void chargeBattery(int amount){
        batteryLevel+=amount;
        if(batteryLevel>100){
            batteryLevel=100;
        }
        System.out.println("Battery charged. Current level: "+batteryLevel+"%");
    }
}
public class DynamicPolymorphism {
    public static void main(String[] args) {
        Car myManualCar = new ManualCar("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.breake();
        myManualCar.stopEngine();

        Car myElectricCar = new ElectricCar("Testla", "Model X");
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.accelerate();
        myElectricCar.breake();
        myElectricCar.stopEngine();
    }
}
