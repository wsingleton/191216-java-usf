public class Task<S>{

  //  public void genericPrinter(Object[] value) {
    //    /* Provide your implementation */
     //   for(Object i: value){
        //    System.out.println(i);
        //}
   // }

    public void genericPrinter(S... values) {
        for (S val: values) {
            System.out.println(val);
        }
    }

}