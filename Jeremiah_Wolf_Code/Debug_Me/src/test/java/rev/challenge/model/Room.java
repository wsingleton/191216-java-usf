package rev.challenge.model;

public class Room extends Space{
    private Enemy enemy;

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public String toString() {
        if(isVisited()) {
            return "S";

        }
        return "R";
    }

    public Room() {
        enemy=new Enemy();
    }



}