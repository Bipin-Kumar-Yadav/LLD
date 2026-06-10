package Solution;

public class BulletType {
    private String color;

    public BulletType(String color){
        this.color = color;
        System.out.println(String.format("Creating bullet type with color %s", color));
    }
}
