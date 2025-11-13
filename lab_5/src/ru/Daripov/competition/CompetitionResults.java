package ru.Daripov.competition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Основной класс для обработки результатов соревнований
 */
public class CompetitionResults {

    /**
     * Чтение данных из файла с использованием Map для группировки по баллам
     */
    public static Map<Integer, List<Participant>> readFromFile(String filename) throws IOException {
        // Map: ключ - сумма баллов, значение - список участников с этой суммой
        Map<Integer, List<Participant>> scoreMap = new HashMap<>();
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            int n = scanner.nextInt(); // читаем количество участников
            scanner.nextLine();
            
            for (int i = 0; i < n; i++) {
                if (!scanner.hasNextLine()) {
                    break; // если строк меньше чем n, выходим из цикла
                }

                String line = scanner.nextLine().trim();
                // Пропускаем пустые строки
                if (line.isEmpty()) {
                    continue;
                }

                // Разбиваем строку на части и проверяем количество
                String[] parts = line.split("\\s+");
                // Проверяем, что есть как минимум 6 частей (фамилия, имя, 4 балла)
                if (parts.length < 6) {
                    continue;
                }

                String lastName = parts[0];
                String firstName = parts[1];
                int[] scores = new int[4];
            
                for (int j = 0; j < 4; j++) {
                    scores[j] = Integer.parseInt(parts[2 + j]);
                }

                Participant participant = new Participant(lastName, firstName, scores);
                // Добавляем участника в Map
                scoreMap.computeIfAbsent(participant.getTotalScore(), k -> new ArrayList<>()).add(participant);
            }
        }
        
        return scoreMap;
    }

    /**
     * Поиск трех лучших участников с использованием Map (оптимально)
     */
    public static List<Participant> findTopThree(Map<Integer, List<Participant>> scoreMap) {
        List<Participant> result = new ArrayList<>();
        
        if (scoreMap.isEmpty()) {
            return result;
        }
        
        // Получаем все баллы и сортируем по убыванию
        List<Integer> sortedScores = new ArrayList<>(scoreMap.keySet());
        Collections.sort(sortedScores, Collections.reverseOrder());
        
        // Берем три лучших различных балла (или меньше, если баллов меньше)
        int count = 0;
        for (int score : sortedScores) {
            result.addAll(scoreMap.get(score)); // Добавляем всех участников с этим баллом
            count++;
            if (count >= 3) break;
        }
        
        return result;
    }
}
