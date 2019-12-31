public class Task {

    public String collapseWhiteSpace(String str) {
        if(str == null || str.isEmpty()) return "";

        return str.replaceAll(" ", "");
    }

}