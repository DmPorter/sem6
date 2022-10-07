package lab4.dop;

import lab4.dop.message.Message;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public final class DIServiceLoader {

    private static final String PATH = "src/main/resources/META-INF/services/";
    String name;
    private final ClassLoader classLoader;
    private final Class<?> aClass = Message.class;
    Map<String, Message> beans;

    private DIServiceLoader() {
        name = aClass.getCanonicalName();
        classLoader = ClassLoader.getSystemClassLoader();
        beans = new HashMap<>();
    }

    public static DIServiceLoader load() {
        return new DIServiceLoader();
    }

    public Message getBean(String beanName) throws Exception {
        FileReader fileReader = new FileReader(PATH + name);
        try (BufferedReader reader = new BufferedReader(fileReader)) {

            int i;
            for (i = 0; true; i++) {
                String line = reader.readLine();
                if (line == null) {
                    throw new ClassNotFoundException(beanName + " not found in" + PATH + name);
                }
                String[] value = line.split(":");
                String nameBeanFile = value[value.length - 1];
                if (beans.containsKey(nameBeanFile) && nameBeanFile.equals(beanName)) {
                    System.out.print("In map -> ");
                    return beans.get(nameBeanFile);
                } else if (nameBeanFile.equals(beanName)) {
                    System.out.print("New bean -> ");
                    Object message = classLoader.loadClass(value[0]).getConstructor().newInstance();
                    if(message instanceof Message){
                        beans.put(nameBeanFile, (Message) message);
                        return (Message) message;
                    }else {
                        throw new Exception("Класс не реализует интерфейс " + aClass.getSimpleName());
                    }
                }
            }

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Message getBean(Class<?> beanClass) throws ClassNotFoundException {
        for(Message val :beans.values()){
            if(val.getClass() == beanClass) return val;
        }
        throw new ClassNotFoundException("Такого класса не существует");
    }

    public Iterator<Message> iterator() {
        return beans.values().iterator();
    }
}