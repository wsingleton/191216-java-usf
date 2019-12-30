public class Task {

    public String substring(String mainString, int start, int end) {



        if (mainString == null || mainString.equals("") || start < 0 || start >= end) {
            return "";
        }

        String out = "";
        for (int i = start; i <= end; i++) {
            out = out + mainString.charAt(i);
        }
        out = out.replace(" ", "");
        return out;

    }
}