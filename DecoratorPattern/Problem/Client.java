package DecoratorPattern.Problem;

public class Client {
    public static void main(String[] args) {
        Pizza basicPizza = new BasicPizza();
        System.out.println(basicPizza.getDescription());
        System.out.println(basicPizza.getCost());

        Pizza cheeseOlivePiza = new CheeseOlivePiza();
        System.out.println(cheeseOlivePiza.getDescription());
        System.out.println(cheeseOlivePiza.getCost());
    }
}
