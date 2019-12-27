public class Task {

    public String collapseWhiteSpace(String str) {
        if (str == null) {
            return "";
        }
        String s = str.replaceAll(" ","");
        return s;

    }

}