public class Task {

    public String substring(String mainString, int start, int end) {

        StringBuilder stringbuilder = new StringBuilder("");

        if (mainString == null || mainString.equals("") || start >= end || start < 0) {
            return stringbuilder.toString();
        }

        String s = "";
        for (int i = start; i < end; i ++) {
            if (mainString.length() - 1 > i){
                s = s + mainString.charAt(i);
            }
            else{
                break;
            }
        }
        return s;

    }
}