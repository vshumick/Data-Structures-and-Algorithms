import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test43 {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        String filename = "person.json";

        // Сохранить объект в файл в формате JSON
        saveObjectToJson(person, filename);

        // Загрузить объект из файла
        Person loadedPerson = loadObjectFromJson(filename, Person.class);
        System.out.println(loadedPerson);
    }

    public static <T> void saveObjectToJson(T object, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new Gson();
            gson.toJson(object, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T loadObjectFromJson(String filename, Class<T> clazz) {
        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
