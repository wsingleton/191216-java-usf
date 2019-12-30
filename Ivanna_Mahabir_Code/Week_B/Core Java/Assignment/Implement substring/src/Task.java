public class Task {

    public String substring(String mainString, int start, int end) {

        mainString = "For this challenge: implement a substring method.";
        start = 2;
        end = 8;

        for(int i = start; i <= end; i++){
            char ch = mainString.charAt(i);
            System.out.println(ch);

        }

    }
}