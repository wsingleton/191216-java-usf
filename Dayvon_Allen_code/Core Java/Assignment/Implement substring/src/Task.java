public class Task {

    public String substring(String mainString, int start, int end) {

        if(mainString == null || mainString.equals("") ){
            return "";
        }
        String[] substringArr = mainString.split("");
        String arr = "";
        if(start >= 0 && end >=0 ) {
            for (int i = start; i < end; i++) {
                arr += substringArr[i];
            }
        }
        else{
            return "";
        }
        return arr;
    }
}