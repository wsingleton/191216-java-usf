package menus;

public abstract class Menu {
    private String address;
    private String name;
    protected Menu(String address, String name) {
        this.address=address;
        this.name=name;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
    public abstract void render();
}
