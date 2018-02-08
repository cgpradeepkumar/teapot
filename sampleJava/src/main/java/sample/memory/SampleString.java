package sample.memory;

/**
 * Created by pradeepkumar on 8/2/18.
 */
public class SampleString {

    public static void main(String[] args) {
        String s1 = "abc"; // stored in String Constant Pool

        String s2 = "abc"; // it wont create a new string, instead it uses the reference from String Constant Pool

        System.out.println(s1==s2); // true

        String s3 = new String("xyz"); // create new object in heap

        String s4 = new String("xyz"); // create new object in heap

        System.out.println(s2==s3); // false
    }
}
