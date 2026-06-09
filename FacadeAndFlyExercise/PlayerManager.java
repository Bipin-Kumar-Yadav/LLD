package FacadeAndFlyExercise;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {
    private Map<String,Player> players = new HashMap<>();

    public void addPlayer(Player player){
        players.put(player.getName(),player);
        System.out.println("Player spawned "+player.getName());
    }
    public void removePlayer(){
        players.clear();
        System.out.println("All player removed");
    }

    public Player getPlayer(String name){
        return players.get(name);
    }
}
