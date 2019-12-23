package Interface;

public class Apple implements FoundObject, Eatable {
    private String name;

    public Apple(String name) {
        this.name=name;
    }

    @Override
    public void eat() {


            System.out.println("Yummy! you eat some " + this.name);

    }
}
