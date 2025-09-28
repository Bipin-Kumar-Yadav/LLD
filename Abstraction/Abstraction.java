interface Car{
    void startEngine();
    void stopEngine();
    void accelerate();
    void brake();
    void shiftGear(int gear);
}

class SportCar implements Car{
    String brand;
    String model;
    boolean isEngineOn;
    int currentSpeed=0;
    int currentGear=0;

    public SportCar(String brand, String model){
        this.brand=brand;
        this.model=model;
    }

    @Override
    public void startEngine() {
        isEngineOn=true;
        System.out.println("Engine started.");
    }
    @Override
    public void stopEngine() {
        isEngineOn=false;
        currentSpeed=0;
        currentGear=0;
        System.out.println("Engine stopped.");  
    }

    @Override
    public void accelerate(){
        if(isEngineOn){
            currentSpeed+=20;
            System.out.println("Accelerating. Current speed: "+currentSpeed+" km/h");
        }
        else{
            System.out.println("Start the engine first.");
        }
    }
    @Override
    public void brake(){
        currentSpeed-=20;
        if(currentSpeed<0){
            currentSpeed=0;
        }
        System.out.println("Braking. Current speed: "+currentSpeed+" km/h");
    }@Override
    public void shiftGear(int gear){
        if(!isEngineOn){
            System.out.println("Start the engine first.");
            return;
        }
        currentGear=gear;
        System.out.println("Shifted to gear: "+currentGear);
    }
}

public class Abstraction{
    public static void main(String[] args){
        Car myCar = new SportCar("Ford", "Mustang");
        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}
