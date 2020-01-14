package Test;

public class Test {
    public String title;
    public int id;

    public Test(String title, int id){
        this.title = title;
        this.id = id;
    }

    public static void main(String[] args) {
        Test[] papers = {
                new Test("T1", 1),
                new Test("T2", 2),
                new Test("T3", 3)
        };

        System.out.println(papers);
        System.out.println(papers[1]);
        System.out.println(papers[1].id);
    }
}