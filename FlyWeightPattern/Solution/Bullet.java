package Solution;

public class Bullet {
    private BulletType type;
    private int x;
    private int y;
    private int velocity;
    public Bullet(String color, int x, int y, int velocity) {
        this.type = BulletTypeFactory.getBulletType(color);
        this.x = x;
        this.y = y;
        this.velocity = velocity;

        System.out.println(String.format("Creating %s bullet with %d , %d x,y with velocity of %d ", color,x,y,velocity));
    }
   
    public void display(){
        System.out.println(String.format("Bullet is at %d,%d x,y with velocity of %d", x,y,velocity));
    }
}
