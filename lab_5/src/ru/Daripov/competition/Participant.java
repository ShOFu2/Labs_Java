package ru.Daripov.competition;

/**
 * Класс для представления участника соревнований
 */
public class Participant {
    // Поля
    private final String lastName;
    private final String firstName;
    private final int[] scores;
    private final int totalScore;

    // Свойства
    public int getTotalScore() {
        return totalScore;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    // Конструктор
    public Participant(String lastName, String firstName, int[] scores) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.scores = scores;
        this.totalScore = calculateTotalScore();
    }
    
    // Методы
    @Override
    public String toString() {
        return lastName + " " + firstName + " " + totalScore;
    }

    private int calculateTotalScore() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }
}
