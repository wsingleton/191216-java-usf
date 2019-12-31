public class Task {

    public String collapseWhiteSpace(String str) {

        if(str ==null || str.length() ==0 ){
            return new String("");
        }
        String noSpace = str.replace(" ", "");
        return noSpace;

    }

}