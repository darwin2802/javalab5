package task3;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task3Main {
    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        } catch (Exception ignored) {}

        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        try {
            System.out.println("Шифрування / дешифрування файлу");
            System.out.println("--------------------------------");

            System.out.print("Введіть текст: ");
            String text = sc.nextLine();

            System.out.print("Введіть ключовий символ: ");
            char key = sc.nextLine().charAt(0);

            System.out.print("Введіть назву файлу для збереження: ");
            String path = sc.nextLine();

            FileWorker fw = new FileWorker();

            fw.saveEncrypted(text, key, path);
            System.out.println("Текст зашифровано.");

            String decoded = fw.loadDecrypted(key, path);
            System.out.println("Розшифрований текст: " + decoded);

        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
