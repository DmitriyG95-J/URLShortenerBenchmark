package MainPackage;

import strategy.*;
import java.util.Scanner;

public class URLShortener {
    private Shortener shortener;

    public URLShortener(StorageStrategy storageStrategy) {
        this.shortener = new Shortener(storageStrategy);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the original URL: ");
        String originalURL = scanner.nextLine();

        Long id = shortener.getId(originalURL); // Получаем числовой идентификатор
        System.out.println("Shortened URL: " + id);

        System.out.print("Enter the shortened URL: ");
        Long inputShortenedURL = Long.parseLong(scanner.nextLine()); // Считываем числовой идентификатор
        String restoredURL = shortener.getString(inputShortenedURL);

        System.out.println("Restored URL: " + restoredURL);

        scanner.close();
    }

    public static void main(String[] args) {
        StorageStrategy storageStrategy = new HashBiMapStorageStrategy(); // Замените на выбранную стратегию
        URLShortener app = new URLShortener(storageStrategy);
        app.run();
    }
}
