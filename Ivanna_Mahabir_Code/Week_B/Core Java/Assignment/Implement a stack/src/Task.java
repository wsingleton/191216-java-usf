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
        if (currentElementPosition == elements.length) elements = Arrays.copyOf(elements, elements.length +1);
            elements[currentElementPosition++] = newString;
    }

    public String pop() {

        if(currentElementPosition == 0) throw new EmptyStackException();
            String newString = elements[currentElementPosition-1];
            elements[currentElementPosition-1] = null;
            return newString;

    }

    public String peek(){
        if(currentElementPosition == 0) throw new EmptyStackException();
            String newString = elements[currentElementPosition -1];
            return newString;
    }

    public int size() {
        return elements.length;
    }

}