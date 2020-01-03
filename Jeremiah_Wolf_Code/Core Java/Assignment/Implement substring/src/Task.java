public class Task {

    public String substring(String mainString, int start, int end) {
        StringBuilder sBuilder = new StringBuilder("");
        if (mainString == null || mainString.equals("") || start < 0 || start >= end) {
            return sBuilder.toString();
        }
        for (int i = 0; i < end; i++) {
            if (i >= start) sBuilder.append(mainString.charAt(i));
        }
        return sBuilder.toString();
    }
}