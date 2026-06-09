package FacadeAndFlyExercise;

public class Player {
    private String name;
    private Weapon weapon;

    public Player(String name, Weapon weapon){
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
