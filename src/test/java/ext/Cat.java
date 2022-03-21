package ext;

public class Cat extends Animals implements AnimalColor {

    public Cat(String name) {
        super(name);
    }

    public void say() {
        System.out.println("Meow!");
    }

    @Override
    public void getColor() {
        System.out.println("Blue");
    }
}
