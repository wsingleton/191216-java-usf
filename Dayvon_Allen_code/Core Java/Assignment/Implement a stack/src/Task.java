import sun.security.util.ArrayUtil;

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
        elements[elements.length - 1] = newString;
    }

    public String pop() {
        if(elements.length == 0){
            throw new EmptyStackException();
        }
        String temp = elements[elements.length -1];
        elements[elements.length - 1] = null;

        return temp;

    }

    public String peek(){

        if(elements.length == 0){
            throw new EmptyStackException();
        }

        return elements[elements.length -1];
    }

    public int size() {
        for (String s: elements
             ) {
            currentElementPosition++;
        }
        return currentElementPosition;
    }

}