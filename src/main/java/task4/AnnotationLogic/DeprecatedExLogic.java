package task4.AnnotationLogic;

import task4.Annotations.DeprecatedEx;

import java.lang.reflect.Method;

public class DeprecatedExLogic {
    public static void deprecatedExHandler(Class<?> clazz) {
        if (clazz == null) {
            System.out.println("Класс отсутствует!");
            return;
        }
        if (clazz.isAnnotationPresent(DeprecatedEx.class)){
            DeprecatedEx annotation = clazz.getAnnotation(DeprecatedEx.class);
            System.out.println("! класс '" + clazz.getSimpleName() + "' устарел – альтернатива: '" + annotation.message() + "'");
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(DeprecatedEx.class))
            {
                DeprecatedEx annotation = method.getAnnotation(DeprecatedEx.class);
                System.out.println("! метод '" + method.getName() + "' устарел – альтернатива: '" + annotation.message() + "'");

            }
        }
    }
}
