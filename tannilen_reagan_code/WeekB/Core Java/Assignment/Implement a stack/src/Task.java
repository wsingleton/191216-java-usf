import java.util.Arrays;
import java.util.EmptyStackException;

public class Task {

    protected int currentElementPosition = 0;
    protected String[] elements;

    public Task() {
        elements = new String[0];
    }

    public Task(int initialSize) {
        elements = new String[initialSize];
    }

    public void push(String newString) {
        elements=Arrays.copyOf(elements, elements.length+1);
        elements[elements.length-1]=newString;
    }

    public String pop() {
        if (elements==null || elements.length==0) {
            throw new EmptyStackException();
        }
        boolean valid;
        String ans="";
        currentElementPosition = elements.length-1;
        do {
            if (elements[currentElementPosition] != null) {
                ans = elements[currentElementPosition];
                elements[currentElementPosition]=null;
                currentElementPosition = 0;
                valid = true;
            } else {
                currentElementPosition -= 1;
                valid = false;
            }
        } while (!valid);
        return ans;
    }

    public String peek(){
        if (elements==null || elements.length==0) {
            throw new EmptyStackException();
        }
        boolean valid;
        String ans="";
        currentElementPosition = elements.length-1;
        do {
            if (elements[currentElementPosition] != null) {
                ans = elements[currentElementPosition];
                currentElementPosition = 0;
                valid = true;
            } else {
                currentElementPosition -= 1;
                valid = false;
            }
        } while (!valid);
        return ans;
    }

    public int size() {
        return elements.length;
    }

}