
package rev.challenge.model;

public class Weapon {
    private String name;
    private int damage;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    private Weapon(String name, int damage) {
        super();
        this.name = name;
        this.damage = damage;
    }
    private Weapon() {
        name="fists";
        damage=1;
    }

    public static Weapon makeWeapon(String w) {
        switch(w.toLowerCase()) {
            case "sword":
                return new Weapon("sword", 5);
            default:
                return new Weapon();
        }
    }

}