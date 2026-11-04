# Сервис для вывода метеорологических данных

Простой API клиент для взаимодействия с [Яндекс.Погодой](https://yandex.ru/pogoda/b2b/console/home). По умолчанию присылает статистику по Москве.

- Для добавления ключа используется класс `Main`:
```java
YandexWeatherApi weatherApi = new YandexWeatherApi("yourApiKey", limit);
```

- Для получения прогноза по другому городу, задайте нужную ширину и долготу:
```java
YandexWeatherApi weatherApi = new YandexWeatherApi(
        "yourApiKey",
        "51.5074",   // lat — Лондон
        "-0.1278",   // lon — Лондон
        limit
);
```
- Для получения средней температуры за более чем 1 день, необходимо изменить переменную `limit` в классе `Main`:
```java
public class Main {
    public static void main() {
        int limit = 5; // 5 дней
        YandexWeatherApi weatherApi = new YandexWeatherApi(
                "yourApiKey",
                "51.5074",   // lat — Лондон
                "-0.1278",   // lon — Лондон
                limit
        );
        ...
```

- Ожидаемый результат после выполнения:
```bash
{
  "now":1793827864,
  "now_dt":"2026-11-04T21:31:04.631160Z",
  "info":{"n":true,
  ...
}

Текущая температура: 9°C
Средняя температура: 10°C за 1 суток
}
```