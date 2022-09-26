package lab4.zad9;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class MyToString {
    public static String myToString(Object o) throws Exception {
        int numObj = 0;
        if(o == null) return "null";

        Class<?> cl = o.getClass();
        if(isPrimitiveOrPrimitiveWrapperOrString(cl)) return o.toString();


        if(cl.isArray()){
            StringBuilder stringBuilder = new StringBuilder(cl.getComponentType() + "[]{");
            for(int i = 0; i < Array.getLength(o); i++){
                Object val = Array.get(o, i);
                stringBuilder.append(myToString(val));
                if(Array.getLength(o) - 1 != i) stringBuilder.append(", ");
            }
            return stringBuilder.append("}").toString();
        }

        StringBuilder builder = new StringBuilder(cl.getName());

        do {
            numObj++;
            builder.append(" [");
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            for (Field f : fields) {
                if (!builder.toString().endsWith(" [")) {
                    builder.append(",");
                }
                builder.append((f.getName())).append("=");
                try {
                    //Class<?> cl2 = f.getType();
                    Object objField = f.get(o);
                    builder.append(objField);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            cl = cl.getSuperclass();
        }while (cl != Object.class);

        for(int i = 0; i < numObj; i++) builder.append("]");
        return builder.toString();
    }


    private static boolean isPrimitiveOrPrimitiveWrapperOrString(Class<?> type) {
        return (type.isPrimitive() && type != void.class) ||
                type == Double.class || type == Float.class || type == Long.class ||
                type == Integer.class || type == Short.class || type == Character.class ||
                type == Byte.class || type == Boolean.class || type == String.class;
    }
}
