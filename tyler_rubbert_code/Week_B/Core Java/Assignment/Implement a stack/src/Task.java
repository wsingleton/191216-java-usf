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
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length-1] = newString;
    }

    public String pop() {

        if (currentElementPosition == 0){
            throw new EmptyStackException();
        }
        String temp = elements[elements.length-1];
        elements[elements.length - 1] = null;
        elements = Arrays.copyOf(elements, elements.length -1);
        return temp;

    }

    public String peek(){
        return elements[elements.length-1];
    }

    public int size() {
        int i = 0;
        for (String s : elements) {
            if (s != null) {
                i++;
            }
        }
        return i;
    }

}