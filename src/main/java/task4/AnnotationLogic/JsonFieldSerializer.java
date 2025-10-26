package task4.AnnotationLogic;

import task4.Annotations.JsonField;

import java.lang.reflect.Field;

public class JsonFieldSerializer {
    public static String jsonFieldsSerialize(Object obj){
        if (obj == null) {
            return "{}";
        }
        StringBuilder json = new StringBuilder();
        json.append("{");

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;
        for (Field field : fields) {
            if(field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonName = annotation.name();
                try {
                    Object value = field.get(obj);
                    if (!first)
                        json.append(", ");
                    json.append("\"")
                            .append(jsonName).append("\": ");
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    first = false;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        json.append("}");
        return json.toString();
    }
}
