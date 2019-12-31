public class Task {

    public String substring(String mainString, int start, int end) {

        // Provide your implementation here

        if ((mainString == null) || mainString.equals("")) {
            return "";
        }
        //string of characters
        String sub = "";
        String[] stringArray= mainString.split("");

        //iterate over each character for the length of main string
        if ((start > -1) && (end >=0 )) {
            for (int i = start; i < end; i++) {
                sub += stringArray[i];
            }
        }
        return sub;
    }
}