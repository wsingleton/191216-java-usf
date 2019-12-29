public class Task {

    public String substring(String mainString, int start, int end) {

        if (mainString == null || mainString.length() == 0) {
            return new String("");
        }

        StringBuilder newString = new StringBuilder("");

        if (start < 0 || end < 0){
            return new String("");
        }
        else if(start > end){
            return new String("");
        }
        else {

            for (int i = 0; i < end; i++){
                if (i >= start)
                    newString.append(mainString.charAt(i));
            }
        }
        return newString.toString();

    }
}