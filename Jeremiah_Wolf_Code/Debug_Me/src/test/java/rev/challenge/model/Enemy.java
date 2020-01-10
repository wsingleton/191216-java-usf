package rev.challenge.model;

public class Enemy {
    private int health;
    private String type;
    private double strength;
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getStrength() {
        return strength;
    }
    public void setStrength(double strength) {
        this.strength = strength;
    }
    public Enemy(int health, String type, double strength) {
        super();
        this.health = health;
        this.type = type;
        this.strength = strength;
    }
    public Enemy() {
        this(5,"goblin",3);
    }
    @Override
    public String toString() {
        return "Enemy [health=" + health + ", type=" + type + ", strength=" + strength + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + health;
        long temp;
        temp = Double.doubleToLongBits(strength);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Enemy other = (Enemy) obj;
        if (health != other.health)
            return false;
        if (Double.doubleToLongBits(strength) != Double.doubleToLongBits(other.strength))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }


}
