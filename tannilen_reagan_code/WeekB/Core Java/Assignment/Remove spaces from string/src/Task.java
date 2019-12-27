public class Task {

    public String collapseWhiteSpace(String str) {

        if (str==null || str.trim()=="") {
            return "";
        }
        str=str.replaceAll(" ", "");
        return str;

    }

}