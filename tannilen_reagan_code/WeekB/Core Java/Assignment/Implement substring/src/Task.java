public class Task {

    public String substring(String mainString, int start, int end) {

        if (mainString==null || mainString=="") {
            return "";
        }
        if (start<0) {
            return "";
        }
        if (mainString.length()-1<end) {
            end = mainString.length() - 1;
        }
        if (end<=start) {
            return "";
        }
        char[] charArray= mainString.toCharArray();
        String returnString = "";
        for (int i = start; i<end; i++) {
            returnString+=charArray[i];
        }
        return returnString;
    }
}