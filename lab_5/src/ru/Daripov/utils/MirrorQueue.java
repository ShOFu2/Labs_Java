package ru.Daripov.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Утилитный класс для демонстрации работы с очередью
 */
public class MirrorQueue {
    public static <T> Queue<T> buildMirrorQueue(List<T> list) {
        Queue<T> queue = new LinkedList<>();
        
        for (T element : list) {
            queue.add(element);
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.offer(list.get(i));
        }
        
        return queue;
    }
}
