import java.util.Arrays;

public class Task {

    public String substring(String mainString, int start, int end) {

        if(mainString == null || mainString == "" || start < 0 || start >= end)
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < end; i++){
            if (i >= start)stringBuilder = stringBuilder.append(mainString.charAt(i));
        }

        return stringBuilder.toString();

    }
}