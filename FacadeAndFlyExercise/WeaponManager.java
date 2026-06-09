package FacadeAndFlyExercise;

public class WeaponManager {
    public Weapon createWeapon(String name, String color, int damage,int x,int y){
        WeaponType weaponType = WeaponFactory.getWeaponType(name, color, damage);
        return new Weapon(weaponType, x, y);
    }

    public void fireBullet(Player player){
        Weapon weapon = player.getWeapon();
        System.out.println("Player "+player.getName() + " fired " + weapon.getWeaponType().getName());
    }
}
