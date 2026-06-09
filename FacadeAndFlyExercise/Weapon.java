package FacadeAndFlyExercise;

public class Weapon {
    private int x; 
    private int y;
    private WeaponType weaponType;
    public Weapon(WeaponType weaponType, int x, int y){
        this.weaponType = weaponType;
        this.x = x;
        this.y = y;
    }

    public WeaponType getWeaponType(){
        return weaponType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
