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
        if(currentElementPosition == elements.length) { elements = Arrays.copyOf(elements, elements.length + 1); }
        elements[currentElementPosition++] = newString;
    }

    public String pop() {

        if(currentElementPosition == 0) throw new EmptyStackException();
        String temp = peek();
        elements[currentElementPosition - 1] = null;
        return temp;
    }

    public String peek(){
        if(currentElementPosition == 0) throw new EmptyStackException();
        return elements[currentElementPosition - 1];
    }

    public int size() {
        return elements.length;
    }

}