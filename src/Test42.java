import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test42 {
    public static void main(String[] args) {
        Person person = new Person("John2", 25);

        // Сохранить объект в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Считать объект из файла
        Person loadedPerson = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
            loadedPerson = (Person) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(loadedPerson);
    }
}
