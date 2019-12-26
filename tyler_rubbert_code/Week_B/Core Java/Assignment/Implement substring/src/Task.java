public class Task {

    public String substring(String mainString, int start, int end) {

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