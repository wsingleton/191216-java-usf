

public class Task {

    public String substring(String mainString, int start, int end) {

        StringBuilder str = new StringBuilder("");

       if(mainString == null || mainString.equals("") || start < 0 || start >= end){
            return str.toString();
        }

           for(int i = 0; i< end; i++){
               if(i>= start) str.append(mainString.charAt(i));
           }

       return str.toString();

    }
}