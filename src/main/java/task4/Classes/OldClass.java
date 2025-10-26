package task4.Classes;

import task4.Annotations.DeprecatedEx;

@DeprecatedEx(message = "Используйте NewClass вместо этого класса.")
public class OldClass {

    @DeprecatedEx(message = "Используйте newMethod() вместо этого метода.")
    public void oldMethod() {
        System.out.println("Старый метод");
    }

    public void newMethod() {
        System.out.println("Новый метод");
    }
}
