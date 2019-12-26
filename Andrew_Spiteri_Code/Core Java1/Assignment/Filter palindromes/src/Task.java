import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Task {

    public String[] filterPalindromes(String[] wordArray) {

        String[] answer = new String[0];
        if(wordArray == null){
            return new String[0];
        }
        int i = 0;
        for (String s:
             wordArray) {
            s = s.replaceAll(" ", "");
            if(isPalindrome(s)){
                answer[i] = s;
                i++;
            }
        }
        return answer;
    }

    public boolean isPalindrome(String word) {

        if(word == null || word == ""){
            return false;
        }
        char[] charArray = word.toCharArray();
        Deque<Character> characterDeque = new Deque<Character>() {
            char[] dequeCharArray = new char[0];
            @Override
            public void addFirst(Character character) {
                dequeCharArray = Arrays.copyOf(dequeCharArray, dequeCharArray.length+1);
                for (int i = dequeCharArray.length - 1; i > 0; i--) {
                    dequeCharArray[i] = dequeCharArray[i-1];
                }
                dequeCharArray[0]= character;
            }

            @Override
            public void addLast(Character character) {
                dequeCharArray = Arrays.copyOf(dequeCharArray, dequeCharArray.length+1);

            }

            @Override
            public boolean offerFirst(Character character) {
                return false;
            }

            @Override
            public boolean offerLast(Character character) {
                return false;
            }

            @Override
            public Character removeFirst() {
                return null;
            }

            @Override
            public Character removeLast() {
                return null;
            }

            @Override
            public Character pollFirst() {
                return null;
            }

            @Override
            public Character pollLast() {
                return null;
            }

            @Override
            public Character getFirst() {
                return null;
            }

            @Override
            public Character getLast() {
                return null;
            }

            @Override
            public Character peekFirst() {
                return null;
            }

            @Override
            public Character peekLast() {
                return null;
            }

            @Override
            public boolean removeFirstOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean removeLastOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean add(Character character) {
                return false;
            }

            @Override
            public boolean offer(Character character) {
                return false;
            }

            @Override
            public Character remove() {
                return null;
            }

            @Override
            public Character poll() {
                return null;
            }

            @Override
            public Character element() {
                return null;
            }

            @Override
            public Character peek() {
                return null;
            }

            @Override
            public void push(Character character) {

            }

            @Override
            public Character pop() {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterator<Character> iterator() {
                return null;
            }

            @Override
            public Iterator<Character> descendingIterator() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Character> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        }

    }

}