import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitBasket {

    public static void main(String[] args) {
        String filePath = "input.txt"; // Чтение файла input.txt

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Подсчет общего количества слов, нахождение самого длинного слова и использование коллекции
            int wordCount = 0;
            String longestWord = "";
            Map<String, Integer> wordFrequency = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next();
                wordCount++;

                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }

                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            scanner.close();
            // Вывод количества частоты слов
            System.out.println("Общее количество слов: " + wordCount);
            System.out.println("Самое длинное слово: " + longestWord);

            
            System.out.println("Частота слов:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        //Обработка исключения при отсутствии файла 
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
    }
}