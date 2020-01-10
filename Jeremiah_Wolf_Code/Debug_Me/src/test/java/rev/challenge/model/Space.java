package rev.challenge.model;

public class Space {
    private Weapon weapon;
    private boolean visited;
    private boolean current;
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    public boolean isCurrent() {
        return current;
    }
    public void setCurrent(boolean current) {
        this.current = current;
    }
    @Override
    public String toString() {
        if(isCurrent())
            return "P";
        else if(isVisited())
            return "O";
        else return "X";
    }



}