public class Task {

    public String collapseWhiteSpace(String str) {

        if(str == null || str.trim().equals("")){
            return "";
        }
        String a = str.replace(" ", "");
        return a;

    }

}