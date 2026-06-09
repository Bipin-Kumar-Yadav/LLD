package FacadeAndFlyExercise;

public class Gateway {
    public static void main(String[] args) {
        GameFacade game = new GameFacade();

        game.startGame();

        game.spawnPlayer("Bipin", "ak47", 80, 20, 30, "red");
        game.spawnPlayer("Shradha", "m416", 70, 40, 32, "green");
        game.spawnPlayer("Vishnu", "m416", 70, 43, 23, "green");

        game.fireWeapon("Bipin");
        game.fireWeapon("Shradha");
        game.fireWeapon("Vishnu");

        game.endGame();
    }
}
