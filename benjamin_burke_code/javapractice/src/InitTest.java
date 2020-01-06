import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InitTest{
    public static void main(String args[ ] ){
        byte b = -128 ;
        int i = b ;
        b = (byte) i;
        System.out.println(i+" "+b);
    }
}