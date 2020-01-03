public class Task {

    public String substring(String mainString, int start, int end) {
        if (mainString == null || mainString.length() == 0 ) return "";
        if(start == 0 && end == mainString.length()-1) return mainString;
        if(end > mainString.length() - 1) return "";
        if(start < 0) return "";
        if(start >= end) return "";
        int length = end-start;
        char[] charSub = new char[length];
        for(int i = 0; i < length; i++) {
            charSub[i] = mainString.charAt(start + i);
        }
        String subStr = "";
        for(char c : charSub) {
            subStr = subStr.concat(String.valueOf(c));
        }
        return subStr;
    }
}