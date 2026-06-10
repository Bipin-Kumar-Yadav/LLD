package Problem;
public class Game {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Bullet bullet = new Bullet("red", i*10, i*20, 5);
        }

        for(int i=0;i<5;i++){
            Bullet bullet = new Bullet("green", i*10, i*20, 5);
        }
    }
}
