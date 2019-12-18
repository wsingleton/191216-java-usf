public class VarArgDriver {
    public static void main(String...args){

      varArg( "test");
      varArg( "test2", 1);
      varArg( "test3", 1,2,3);
//instantiating a 2-d array using literals
        int [][] twoDimArr ={
                {1, 2, 3},
                {4,5,6},
                {7,8,9}
        };

      show(twoDimArr);
    }
    public static void varArg(String myString,int...values) {
        System.out.println(myString);
        for (int i : values) {
            System.out.println(i);
        }
    }
    /*
    we can make our variable arguments as many dimensions as desired,jut add a set of square brackets and the eclipses to pass ina muti-dimensional array.
    */


    public static void show(int[]...my2dArray){
    for (int[] arr: my2dArray){
    for (int i: arr) {
        System.out.println(i);
    }
                 }
        }
    }

