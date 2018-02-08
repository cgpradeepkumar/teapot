package sample.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

            Class c = Class.forName("sample.reflection.Sample");
            System.out.println(c.getName());

            Sample sample = (Sample) c.newInstance();
            sample.print();

//            sample.message(); //impossible as it is private

            // accessing private method of a class

            Object object = c.newInstance();
            Method privateMethod = c.getDeclaredMethod("message", null);
            privateMethod.setAccessible(true);
            privateMethod.invoke(object, null);

            Constructor constructors[] = Sample.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                Sample sample1 = (Sample) constructor.newInstance();
                sample1.print();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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

class Sample {

    private void message() {
        System.out.println("hello java");
    }

    public void print() {
        System.out.println("testing....");
    }
}
