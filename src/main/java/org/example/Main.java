import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newBuilder().build();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.weather.yandex.ru/v2/forecast?lat=52.37125&lon=4.89388"))
                    .GET()
                    .header("X-Yandex-Weather-Key", "test")
                    .build();

            System.out.println("Отправка запроса...");
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Статус-код: " + response.statusCode());
            System.out.println("Тело ответа:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

yandexWeather