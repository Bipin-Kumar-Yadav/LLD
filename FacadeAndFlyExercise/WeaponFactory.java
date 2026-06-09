package FacadeAndFlyExercise;

import java.util.HashMap;
import java.util.Map;

public class WeaponFactory {
    private final static Map<String,WeaponType> map = new HashMap<>();

    public static WeaponType getWeaponType(String name,String color,int damage){
        String key = name + ":" + color + ":" + damage;

        if(!map.containsKey(key)){
            map.put(key, new WeaponType(name, color, damage));
            System.out.println("Weapon has created");
        }

        return map.get(key);
    }
}
