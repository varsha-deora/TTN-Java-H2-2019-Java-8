import java.util.*;
public class LambdaExpressionExample7{
    public static void main(String[] args) {

        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n)
        );

        System.out.println("----------foreach without lambda----- ");

        for (String a:list) {
            System.out.println(a);
        }
    }
}