package utils;

import model.Shape;
import java.io.*;

public class ShapeFileHandler {

    public static boolean saveShapesToFile(Shape[] shapes, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(shapes);
            return true;
        } catch (IOException e) {
            System.err.println("Помилка збереження об'єктів у файл '" + filePath + "': " + e.getMessage());
            return false;
        }
    }

    public static Shape[] loadShapesFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof Shape[]) {
                return (Shape[]) obj;
            } else {
                System.err.println("Помилка: Файл не містить очікуваного масиву об'єктів Shape.");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Помилка: Файл '" + filePath + "' не знайдено.");
            return null;
        } catch (IOException e) {
            System.err.println("Помилка читання/доступу до файлу '" + filePath + "': " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("Помилка: Клас об'єкта не знайдено під час десеріалізації: " + e.getMessage());
            return null;
        }
    }
}