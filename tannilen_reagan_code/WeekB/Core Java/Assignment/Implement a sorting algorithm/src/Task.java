import java.util.Arrays;
import java.util.stream.IntStream;

public class Task {

    public int[] sortNumbers(int[] numbersForSorting) {

        if (numbersForSorting==null || numbersForSorting.length==0) {
                return new int[0];
            }
            for(int i=0;i<numbersForSorting.length;i++) {
                for (int x=i+1;x<numbersForSorting.length;x++) {
                    if (numbersForSorting[i]>numbersForSorting[x]) {
                        int n=numbersForSorting[x];
                        numbersForSorting[x]=numbersForSorting[i];
                        numbersForSorting[i]=n;
                    }
                }
            }
            return numbersForSorting;
        }

    }