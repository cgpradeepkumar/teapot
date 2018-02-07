package sample.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pradeepkumar on 7/2/18.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("org.apache.commons.math3.analysis.differentiation.DerivativeStructure");
            Method method[] = clazz.getMethods();
            Field field[] = clazz.getFields();

            for (Method method1 : method) {
                System.out.println(method1);
            }
            System.out.println("--------------------");
            for (Field field1 : field) {
                System.out.println(field1);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
