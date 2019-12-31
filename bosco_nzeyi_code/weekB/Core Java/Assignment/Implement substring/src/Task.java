public class Task {

    public String substring(String mainString, int start, int end) {




        String str = "";

        if(mainString != null && !(start>mainString.length()) && !(end>mainString.length())
        && !(end < start) && !(start>end) && !(start<0)){
            str = mainString.substring(start, end);
            return str;
        } else{
            return str;
        }

    }
}