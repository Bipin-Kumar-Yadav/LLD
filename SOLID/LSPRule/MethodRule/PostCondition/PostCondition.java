package SOLID.LSPRule.MethodRule.PostCondition;

// A Postcondition must be satisfied after a method is executed.
// Subclasses can strengthen the Postcondition but cannot weaken it.

class Car{
    protected int speed ;
    public Car(){
        this.speed = 0;
    }

    void accelerate(int increment){
        System.out.println("Accelerating car by " + increment);
        speed += increment;
    }

    // Postcondition: speed must reduce after break
    void breakCar(int decrement){
        System.out.println("Braking car by " + decrement);
        speed -= decrement;
        if(speed < 0) speed = 0; // Ensuring speed doesn't go negative
    }
}
class ElectricCar extends Car{
    private int batteryLevel;
    public ElectricCar(){
        super();
        this.batteryLevel = 50; // Battery level starts at 100%
    }

    @Override
    void breakCar(int decrement){
        System.out.println("Braking electric car by " + decrement);
        speed -= decrement;
        if(speed < 0) speed = 0; // Ensuring speed doesn't go negative
        batteryLevel -= 10;
        if(batteryLevel < 0) batteryLevel = 0; // Ensuring battery level doesn't go negative
    }
}
public class PostCondition {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.accelerate(50);
        myCar.breakCar(20);
        System.out.println("Car speed after braking: " + myCar.speed);

        ElectricCar myElectricCar = new ElectricCar();
        myElectricCar.accelerate(60);
        myElectricCar.breakCar(30);
        System.out.println("Electric Car speed after braking: " + myElectricCar.speed);
    }
}
