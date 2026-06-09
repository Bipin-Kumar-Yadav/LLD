package FacadeAndFlyExercise;

public class GameFacade {
    private PlayerManager playerManager;
    private WeaponManager weaponManager;

    public GameFacade(){
        this.playerManager = new PlayerManager();
        this.weaponManager = new WeaponManager();
    }
    public void startGame(){
        System.out.println("Game Started!!!");
    }

    public void spawnPlayer(String playerName, String weaponName, int damage, int x, int y, String color){
        Weapon weapon = weaponManager.createWeapon(weaponName, color, damage, x, y);
        Player player = new Player(playerName, weapon);
        playerManager.addPlayer(player);
    }

    public void fireWeapon(String palyerName){
        Player player = playerManager.getPlayer(palyerName);
        weaponManager.fireBullet(player);
    }

    public void endGame(){
        System.out.println("Game ended");
        playerManager.removePlayer();
    }
}
