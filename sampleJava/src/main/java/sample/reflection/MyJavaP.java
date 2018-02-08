package sample.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by pradeepkumar on 8/2/18.
 */
public class MyJavaP {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName(args[0]);

            System.out.println("Fields.......");
            Field field[] = clazz.getFields();
            for (Field field1 : field) {
                System.out.println(field1);
            }

            System.out.println("Constructors......");
            Constructor constructors[] = clazz.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("Methods.........");
            Method methods[] = clazz.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
