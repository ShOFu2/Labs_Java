package ru.Daripov.utils;

import java.io.*;
import java.util.*;

/*
 * Утилитный класс для подсчёта различных русских букв в файле
 */
public class LetterCounter {
    public static int countUniqueLetters(String filename) throws IOException {
        Set<Character> letters = new HashSet<>();
        
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я') || c == 'Ё' || c == 'ё') {
                        letters.add(Character.toLowerCase(c));
                    }
                }
            }
        }
        
        return letters.size();
    }
}
