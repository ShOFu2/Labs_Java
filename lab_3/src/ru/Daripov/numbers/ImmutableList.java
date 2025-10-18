package ru.Daripov.numbers;
/*
 * Класс, описывающий сущность Неизменяемый список
 */
import java.util.Arrays;

public final class ImmutableList {
    // поля
    private final int[] values;
    
    // конструкторы
    public ImmutableList (int... values) {
        this.values = Arrays.copyOf(values, values.length);
    }
    
    public ImmutableList (ImmutableList other) {
        if (other == null) {
            this.values = new int[0];
        } else {
            this.values = Arrays.copyOf(other.values, other.values.length);
        }
    }
    
    // методы
    @Override
    public String toString () {
        return Arrays.toString(values);
    }
    
    public int get (int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException(
                "Позиция " + index + " выходит за границы списка [0, " + (values.length - 1) + "]");
        }
        return values[index];
    }
    
    public ImmutableList set (int index, int newValue) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException(
                "Позиция " + index + " выходит за границы списка [0, " + (values.length - 1) + "]");
        }
        
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = newValue;
        return new ImmutableList(newValues);
    }

    public boolean isEmpty () {
        return values.length == 0;
    }

    public int length () {
        return values.length;
    }

    public int[] toArray () {
        return Arrays.copyOf(values, values.length);
    }
}