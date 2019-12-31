public class Task {

    public String collapseWhiteSpace(String str) {

        // Provide your implementation here
        if (str == null) {
            return "";
        }
        return str.trim().replaceAll(" ","" );

    }

}