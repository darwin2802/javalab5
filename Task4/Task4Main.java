import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class Task4Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url;

        while (true) {
            try {
                System.out.print("Введіть URL сторінки: ");
                url = scanner.nextLine().trim();
                if (url.isEmpty()) throw new IllegalArgumentException("URL не може бути порожнім.");
                break;
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        Map<String, Integer> tags = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            String line;
            Pattern pattern = Pattern.compile("<\\s*([a-zA-Z0-9]+)[\\s>]");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String tag = matcher.group(1).toLowerCase();
                    tags.put(tag, tags.getOrDefault(tag, 0) + 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Помилка завантаження сторінки: " + e.getMessage());
            return;
        }

        System.out.println("\n=== Теги в алфавітному порядку ===");
        tags.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        System.out.println("\n=== Теги за кількістю появи ===");
        tags.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        System.out.print("\nВведіть ім’я файлу для збереження: ");
        String filePath = scanner.nextLine().trim();

        TagResult result = new TagResult(tags);

        try {
            FileManager.saveObject(filePath, result);
            System.out.println("Файл збережено.");
        } catch (Exception e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }
}
