import java.util.ArrayList;

public class DatabaseWrapper {

    public static void main( String[] args){
        try{
            int i = 0;
            i =  Integer.parseInt( args[0] );
        }
        catch(NumberFormatException e){
            System.out.println("Problem in " + i );
        }
    }
}
