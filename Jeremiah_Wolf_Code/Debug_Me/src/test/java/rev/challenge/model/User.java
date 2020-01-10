package rev.challenge.model;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {

    private static final long serialVersionUID = 1L;
    private int place;
    private String name;
    private int score;

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setPlace(int place) {
        this.place = place;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPlace() {
        return place;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return place+": "+name+"    score: "+score;
    }
    @Override
    public int compareTo(User o) {
        return o.score-score;
    }
    public User(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }


}