public class Task {

    public String substring(String mainString, int start, int end) {

        if (mainString == null || mainString.length() == 0) {
            return new String("");
        }

        StringBuilder pooString = new StringBuilder("");

        if (start < 0 || end < 0){
            return new String("");
        }
        else if(start > end){
            return new String("");
        }
        else {

            for (int i = 0; i < end; i++){
                if (i >= start)
                    pooString.append(mainString.charAt(i));
            }
        }
        return pooString.toString();

    }
}