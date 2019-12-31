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

        // copy all the elements and make it equal to the new string

        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = newString;
    }

    public String pop() {

        // Check is stack is empty
        // move element to the top and remove it
        if(elements.length == 0){
            throw new EmptyStackException();
        }

        String popped= elements[elements.length -1];
        elements[elements.length - 1] = null;
        return popped;

    }

    public String peek(){
        // same check

        if(elements.length == 0){
            throw new EmptyStackException();
        }
        // gives the first element
        return elements[elements.length -1];
    }

    public int size() {
        //number of currentElement increases for each string

        for (String len: elements
             ) {
            currentElementPosition++;
        }
        return currentElementPosition;
    }

}