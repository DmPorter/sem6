package lab4.dop;

import lab4.dop.message.Message;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public final class DIServiceLoader {

    private static final String PATH = "src/main/resources/META-INF/services/";
    String name; // имя нашего интерфейса
    ServiceLoader<Message> serviceLoader; // сервис лоадер для загрузки информации из META-INF
    Map<String, Message> beans; //map для хранения уже загруженных классов

    private DIServiceLoader(Class<Message> cl) {
        name = cl.getName();
        beans = new HashMap<>();
        serviceLoader = ServiceLoader.load(cl);
    }

    public static DIServiceLoader load(Class<Message> cl) {
        return new DIServiceLoader(cl);
    }

    public Message getBean(String beanName) throws ClassNotFoundException, IOException {
        FileReader fileReader = new FileReader(PATH + name);
        try (BufferedReader reader = new BufferedReader(fileReader)) {

            int i;
            for (i = 0; true; i++) {
                String line = reader.readLine(); //берем из файла строчку
                if (line == null) {
                    throw new ClassNotFoundException(beanName + " not found in" + PATH + name);
                }
                String[] value = line.split("#"); // разделяем на название бина и его значение
                String name1 = value[value.length - 1];
                if (beans.containsKey(name1) && name1.equals(beanName)) { // проверяем есть ли такой бин уже(загружен ли он уже)
                    System.out.print("Bean->");
                    return beans.get(name1);
                } else if (name1.equals(beanName)) { // если такого бина нет, то находим его в ServiceLoader и помещаем в наш map
                    Iterator<Message> iterator = serviceLoader.iterator();
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
        return serviceLoader.stream()
                .filter(o -> o.get().getClass().equals(beanClass)) //проходит проверка на совпадение классов
                .findFirst()//берем первый
                .get()//выдаем этот первый найденный бин
                .get();
    }

    public Iterator<Message> iterator() {
        return serviceLoader.iterator();
    } // возвращаем итератор ServiceLoader
}