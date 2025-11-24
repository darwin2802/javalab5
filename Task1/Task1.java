import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {

    public static String findMaxWordLine(String filePath) {
        String maxWordLine = null;
        int maxWords = -1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] words = currentLine.trim().split("\\s+");
                int currentWordCount = 0;

                for (String word : words) {
                    if (!word.isEmpty()) {
                        currentWordCount++;
                    }
                }

                if (currentWordCount > maxWords) {
                    maxWords = currentWordCount;
                    maxWordLine = currentLine;
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            return null;
        }
        return maxWordLine;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "";

        while (true) {
            try {
                System.out.print("Введіть шлях до файлу: ");
                filePath = scanner.nextLine();
                if (filePath.trim().isEmpty()) {
                    throw new IllegalArgumentException("Шлях до файлу не може бути порожнім.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("Помилка введення: " + e.getMessage());
            }
        }

        String resultLine = findMaxWordLine(filePath);

        if (resultLine != null) {
            System.out.println("\nРядок із максимальною кількістю слів:");
            System.out.println("-> " + resultLine);
            String[] words = resultLine.trim().split("\\s+");
            int maxWords = 0;
            for (String word : words) {
                if (!word.isEmpty()) {
                    maxWords++;
                }
            }
            System.out.println("Кількість слів: " + maxWords);
        } else if (filePath != null) {
            System.out.println("\nНе вдалося знайти рядок або файл порожній.");
        }
    }
}