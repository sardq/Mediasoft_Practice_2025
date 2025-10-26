package task4;

import task4.AnnotationLogic.DeprecatedExLogic;
import task4.AnnotationLogic.JsonFieldSerializer;
import task4.Classes.*;
import task4.Interfaces.Printable;

import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        //Лямбда выражение для интерфейса Printable
        Printable printable = ()  -> System.out.println("Вызов printable");
        printable.print();
        //Проверка пустой строки
        Predicate<String> notNullString = str -> str != null;
        Predicate<String> notEmptyString = str -> !str.isEmpty();
        Predicate<String> notEmptyAndNotNull = notNullString.and(notEmptyString);
        String test1 = "Тест";
        String test2 = "";
        String test3 = null;
        System.out.println("Проверка пустой строки");
        System.out.println(test1 +": " + notEmptyAndNotNull.test(test1));
        System.out.println(test2 +": " +notEmptyAndNotNull.test(test2));
        System.out.println(test3 +": " +notEmptyAndNotNull.test(test3));
        // Проверка строки
        Predicate<String> stringStartWithJorN = str -> {
            str = str.toUpperCase();
            return str.startsWith("J") || str.startsWith("N");
        };
        Predicate<String> stringEndWithA = str -> {
            str = str.toUpperCase();
            return str.endsWith("A");
        };
        Predicate<String> checkString = notEmptyAndNotNull.and(stringStartWithJorN.and(stringEndWithA));
        test1 = "java";
        test2 = "NINA";
        test3 = "Ace";
        System.out.println("Проверка строки на совпадение первого(N,J) и последнего символа(A)");
        System.out.println(test1 +": " +checkString.test(test1));
        System.out.println(test2 +": " +checkString.test(test2));
        System.out.println(test3 +": " +checkString.test(test3));
        //Лямбда выражение для HeavyBox
        Consumer<HeavyBox> heavyBoxShip = heavyBox -> {
            if(heavyBox != null)
                System.out.println("Отгрузили ящик с весом " + heavyBox.getWeight());
            else
                System.out.println("Получен пустой ящик!");
        };
        Consumer<HeavyBox> heavyBoxDeliver = heavyBox -> {
            if (heavyBox != null)
                System.out.println("Отправляем ящик с весом " + heavyBox.getWeight());
             else
                System.out.println("Отправляем пустой ящик!");
        };

        final HeavyBox box1 = new HeavyBox(15);
        final HeavyBox box2 = new HeavyBox(11);
        final HeavyBox box3 = null;
        System.out.println("Лямбда выражение для HeavyBox. Получение и отправка ящика");
        heavyBoxShip.andThen(heavyBoxDeliver).accept(box1);
        heavyBoxShip.andThen(heavyBoxDeliver).accept(box2);
        heavyBoxShip.andThen(heavyBoxDeliver).accept(box3);
        //Лямбда для Function
        Function<Integer, String> checkIntFunction = integer -> {
                if (integer == null)
                    return "Число отсутствует";
                if (integer < 0)
                    return "Отрицательное число";
                else if (integer > 0)
                    return "Положительное число";
                else
                    return "Ноль";
        };
        System.out.println("Лямбда для Function. Проверка числа");
        System.out.println(checkIntFunction.apply(null));
        System.out.println(checkIntFunction.apply(143));
        System.out.println(checkIntFunction.apply(0));
        System.out.println(checkIntFunction.apply(-11));
        //Лямбда для Supplier
        Supplier<Integer> randomIntSupplier = () -> {
            Random random = new Random();
            return random.nextInt(11);
        };
        System.out.println("Лямбда для Supplier. Число от 0 до 10");
        System.out.println(randomIntSupplier.get());
        System.out.println(randomIntSupplier.get());
        System.out.println(randomIntSupplier.get());
        //Кастомная аннотация @DeprecatedEx
        System.out.println("Кастомная аннотация @DeprecatedEx");
        DeprecatedExLogic.deprecatedExHandler(OldClass.class);
        DeprecatedExLogic.deprecatedExHandler(null);
        //Кастомная сериализация в JSON с аннотацией @JsonField
        System.out.println("Кастомная сериализация в JSON с аннотацией @JsonField");
        Room room = new Room(101, 4, 800, false);
        String jsonRoom = JsonFieldSerializer.jsonFieldsSerialize(room);
        String jsonBox1 = JsonFieldSerializer.jsonFieldsSerialize(box1);
        String jsonBox2 = JsonFieldSerializer.jsonFieldsSerialize(box2);
        String jsonBox3 = JsonFieldSerializer.jsonFieldsSerialize(box3);
        System.out.println(jsonRoom);
        System.out.println(jsonBox1);
        System.out.println(jsonBox2);
        System.out.println(jsonBox3);
    }
}
