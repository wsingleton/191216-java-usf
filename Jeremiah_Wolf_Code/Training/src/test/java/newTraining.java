// File: WordCounter.java
// Program from Section 5.7 to illustrate the use of TreeMaps and Iterators.
// The program opens and reads a file called words.txt. Each line in this
// file should consist of one or more English words separated by spaces.
// The end of each line must not have any extra spaces after the last word.
// The program reads the file and then a table is printed of
// all words and their counts.

import java.util.*;  // Provides TreeMap, Iterator, Scanner
import java.io.*;    // Provides FileReader, FileNotFoundException

class WordCounter
{
    public static void main(String[ ] args)
    {
        TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );

        readWordFile(frequencyData);
        printAllCounts(frequencyData);
    }

    public static int getCount
            (String word, TreeMap<String, Integer> frequencyData)
    {
        if (frequencyData.containsKey(word))
        {  // The word has occurred before, so get its count from the map
            return frequencyData.get(word); // Auto-unboxed
        }
        else
        {  // No occurrences of this word
            return 0;
        }
    }

    public static void printAllCounts(TreeMap<String, Integer> frequencyData)
    {
        System.out.println("-----------------------------------------------");
        System.out.println("    Occurrences    Word");

        for(String word : frequencyData.keySet( ))
        {
            System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }

        System.out.println("-----------------------------------------------");
    }

    public static void readWordFile(TreeMap<String, Integer> frequencyData)
    {
        Scanner wordFile;
        String word;     // A word read from the file
        Integer count;   // The number of occurrences of the word

        try
        {
            wordFile = new Scanner(new FileReader("words.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e);
            return;
        }

        while (wordFile.hasNext( ))
        {
            // Read the next word and get rid of the end-of-line marker if needed:
            word = wordFile.next( );

            // Get the current count of this word, add one, and then store the new count:
            count = getCount(word, frequencyData) + 1;
            frequencyData.put(word, count);
        }
    }

}