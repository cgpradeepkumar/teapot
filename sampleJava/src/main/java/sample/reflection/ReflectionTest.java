package sample.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

            Calendar calendar = new GregorianCalendar();
            testGetClass(calendar);

            testDotClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testGetClass(Object object) {
        Class clazz = object.getClass();
        System.out.println(clazz.getName());
    }

    private static void testDotClass(){
        Class clazz = int.class;
        Method method[] = clazz.getMethods();
        System.out.println(clazz.getName());
        System.out.println(clazz.isPrimitive());
    }
}
