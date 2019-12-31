public class Task {

    public String collapseWhiteSpace(String str) {


       //forgot the base case!!!!! ugh
        if (str == null || str.trim().equals("")) return "";
        str = str.replaceAll("\\s", "");

        return str;

    }

}