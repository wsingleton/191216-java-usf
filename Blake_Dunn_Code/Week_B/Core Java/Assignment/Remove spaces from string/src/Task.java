public class Task {

    public String collapseWhiteSpace(String str) {


        if (str == null || str.length() == 0)
            return new String("");

        str = str.replaceAll("\\s","");

        return str;

    }

}