public class Task {

    public String substring(String mainString, int start, int end) {

        // Provide your implementation here
        StringBuilder substrBuilder = new StringBuilder();

        if (mainString == null || mainString.equals("") || start < 0 || start >= end) {
            return substrBuilder.toString();
        }

        for (int i = 0; i < end; i++) {
            if (i >= start) substrBuilder.append(mainString.charAt(i));
        }

        return substrBuilder.toString();
    }
}