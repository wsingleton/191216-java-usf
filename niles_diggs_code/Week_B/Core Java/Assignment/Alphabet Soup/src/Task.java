import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task {

    public String createAcronymFromPhrase(String phrase) {
        String acronym = "";

        String word = "";


        if (phrase == null || phrase.equals("")) {

            return "";

        }

        String[] phraseHolder;

        word = phrase.trim().replaceAll("'", "");

        word = word.replaceAll("[0-9]", "").replaceAll("[^a-zA-Z]+", " ");

        phraseHolder = word.split(" ");

        try {

            for (String phrase1 : phraseHolder

            ) {

                acronym += phrase1.charAt(0);

            }

        } catch (Exception E) {


        }


        return acronym.toUpperCase();
    }
}
