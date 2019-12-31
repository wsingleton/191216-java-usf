public class Task {

    public String collapseWhiteSpace(String str) {

        if(str == null || str.equals("")){
            return "";
        }
        str = str.replaceAll("\\s", "");
        return str;

    }

}