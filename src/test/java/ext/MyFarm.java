package ext;

public class MyFarm {
    public static void main(String[] args) {
        Cat oli = new Cat ("Oli");
        //Cat oli2 = new Cat ("Murka");
        Dog dog1 = new Dog ("Bobik");

        oli.eat();
        oli.say();

        dog1.eat();
        dog1.say();
        System.out.println(dog1.getName());
        dog1.setName("Geralt");
        System.out.println(dog1.getName());
        dog1.getColor();
    }

}
