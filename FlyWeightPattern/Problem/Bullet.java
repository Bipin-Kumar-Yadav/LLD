package Problem;

public class Bullet {
	private String color;
    private int x;
    private int y;
    private int velocity;

    

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println(String.format("Creating %s bullet with x,y %d , %d and velocity of %d",color, x, y, velocity));
    }

    public void display(){
        System.out.println("Bullet at "+x+" "+y+" at velocity of "+velocity );
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    
}