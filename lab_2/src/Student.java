/*
 * Класс, описывающий сущность Студент
 */
public final class Student {
    // Поля
    private String name;
    private int[] marks;

    // Свойства
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks (int[] marks) {
        this.marks = marks;
    }

    public String getName() {
        return this.name;
    }

    public int[] getMarks() {
        return this.marks;
    }

    // Конструкторы
    public Student() {
        setName("Без имени");
        setMarks(new int[0]);
    }

    public Student(Student student) {
        setName(student.name);
        setMarks(student.marks);
    }

    public Student(String name, int[] marks) {
        setName(name);
        setMarks(marks);
    }

    public Student(String name) {
        this(name,new int[0]);
    }

    public Student(int[] marks) {
        this("Без имени", marks);
    }

    // Методы
    @Override
    public String toString() {
        String result = this.name + ": [";
        for(int i = 0; i < marks.length; i++) {
            if (i != marks.length-1) {
            result += marks[i] + ", ";
            } else {
                result += marks[i];
            }
        }
        result += "]";
        return result; 
    }
}