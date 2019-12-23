package Interface;

public class Rasberry implements FoundObject, Eatable {
private String name;

    public Rasberry(String name) {
        this.name = name;
    }

    @Override
    public void eat(){
        System.out.println("Yummy you ate a: " + this.name);
    }
}
