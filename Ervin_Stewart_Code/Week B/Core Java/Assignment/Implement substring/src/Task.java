public class Task {

    public String substring(String mainString, int start, int end) {

        char[] originalString = mainString.toCharArray();
        char[] substring = new char[mainString.length()-start];
        int x = 0;
        for(int i = start; i<=end; i++){
            substring[x++] = originalString[start++];

        }
        String subString = substring.toString();
        return subString;
    }
}