public class Task {

    public String collapseWhiteSpace(String str) {

        if(str== null|| str.isEmpty()){return new String ("");}
str =str.replaceAll("\\s","");
return str;
    }

}