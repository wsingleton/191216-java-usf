public class Task {

    public String collapseWhiteSpace(String str) {

        if (str == null || str.trim().equals("")) return "";
        str = str.replaceAll(" ", "");
        return str;
    }

}