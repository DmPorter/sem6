package lab4.dop;

import lab4.dop.message.Message;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public final class DIServiceLoader {
    private static final String FILE = "src/main/resources/META-INF/services/";
    String nameInt;
    ServiceLoader<Message> serviceLoad;
    Map<String, Message> beans;

    private DIServiceLoader(Class<Message> cl) {
        nameInt = cl.getName();
        beans = new HashMap<>();
        serviceLoad = ServiceLoader.load(cl);
    }

    public static DIServiceLoader load(Class<Message> cl) {
        return new DIServiceLoader(cl);
    }
    public Message getBean(String beanName) throws ClassNotFoundException, IOException {
        FileReader fileReader = new FileReader(FILE + nameInt);
        try (BufferedReader reader = new BufferedReader(fileReader)) {

            int i;
            for (i = 0; true; i++) {
                String line = reader.readLine();
                if (line == null) {
                    throw new ClassNotFoundException(beanName + " not found in" + FILE + nameInt);
                }
                String[] value = line.split(":");
                String name1 = value[value.length - 1];
                if (beans.containsKey(name1) && name1.equals(beanName)) {
                    System.out.print("Bean->");
                    return beans.get(name1);
                } else if (name1.equals(beanName)) {
                    Iterator<Message> iterator = serviceLoad.iterator();
                    for (int j = 0; j < i; j++) {
                        iterator.next();
                    }
                    Message bean = iterator.next();
                    beans.put(beanName, bean);
                    System.out.print("ServiceLoader->");
                    return bean;
                }
            }

        }
    }

    public Message getBean(Class<?> beanClass) {
        return serviceLoad.stream()
                .filter(o -> o.get().getClass().equals(beanClass))
                .findFirst()
                .get()
                .get();
    }

    public Iterator<Message> iterator() {
        return serviceLoad.iterator();
    }
}