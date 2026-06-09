package FacadeAndFlyExercise;

public class WeaponType {
    private String name;
    private String color;
    private int damage;

    public WeaponType(String name, String color, int damage){
        this.name = name;
        this.color = color;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getDamage() {
        return damage;
    }
}
