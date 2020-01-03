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
        if(currentElementPosition == elements.length) elements = Arrays.copyOf(elements, elements.length + 1);
        elements[currentElementPosition++] = newString;
}
    public String pop() {

        // Provide your implementation here
        if(currentElementPosition == 0) throw new EmptyStackException();
        String value = elements[currentElementPosition - 1];
        elements[currentElementPosition - 1] = null;
        return value;
    }

    public String peek(){

       if (currentElementPosition == 0) throw new EmptyStackException();
        return elements[currentElementPosition - 1];
    }

    public int size() {
        return elements.length;
    }

}