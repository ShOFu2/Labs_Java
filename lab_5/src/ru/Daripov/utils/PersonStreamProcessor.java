package ru.Daripov.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonStreamProcessor {
    /**
     * Основной метод обработки данных
     */
    public static Map<Integer, List<String>> processFile(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                // 1. Фильтруем пустые строки
                .filter(line -> !line.trim().isEmpty())
                // 2. Разбираем строку на имя и номер
                .map(line -> {
                    String[] parts = line.split(":");
                    String name = parts[0].trim();
                    String numberStr = parts.length > 1 ? parts[1].trim() : "";
                    return new String[]{name, numberStr};
                })
                // 3. Убираем людей без номеров
                .filter(parts -> !parts[1].isEmpty())
                // 4. Преобразуем имена к нужному формату (первая буква заглавная, остальные строчные)
                .map(parts -> {
                    String originalName = parts[0];
                    String formattedName = formatName(originalName);
                    String numberStr = parts[1];
                    return new String[]{formattedName, numberStr};
                })
                // 5. Группируем по номеру
                .collect(Collectors.groupingBy(
                    parts -> Integer.valueOf(parts[1]),  // ключ - номер
                    Collectors.mapping(
                        parts -> parts[0],                // значение - имя
                        Collectors.toList()               // собираем в список
                    )
                ));
    }
    
    /**
     * Форматирование имени: первая буква заглавная, остальные строчные
     */
    private static String formatName(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        // Приводим всю строку к нижнему регистру
        String lowerCaseName = name.toLowerCase();
        // Первую букву делаем заглавной
        return lowerCaseName.substring(0, 1).toUpperCase() + lowerCaseName.substring(1);
    }
}
