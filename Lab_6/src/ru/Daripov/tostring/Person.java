package ru.Daripov.tostring;

/**
 * Класс Person с аннотацией {@link ToString} на уровне класса и полей.
 * 
 * <p>Демонстрирует использование аннотации @ToString для настройки
 * строкового представления объекта. Некоторые поля исключены из вывода.
 * 
 * @author Дарипов Александр
 * @see ToString
 */
@ToString
public class Person {
    private String name;
    private int age;
    private String email;
    
    /**
     * Поле исключено из строкового представления.
     */
    @ToString(Mode.NO)
    private String password;
    
    /**
     * Секретное поле также исключено.
     */
    @ToString(Mode.NO)
    private String secretKey;
    
    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name; 
    }
    
    public int getAge() { 
        return age; 
    }
    public void setAge(int age) { 
        this.age = age; 
    }
    
    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public String getPassword() { 
        return password; 
    }
    public void setPassword(String password) { 
        this.password = password; 
    }
    
    public String getSecretKey() { 
        return secretKey; 
    }

    public void setSecretKey(String secretKey) { 
        this.secretKey = secretKey; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "no-email";
        this.password = "default";
        this.secretKey = "secret";
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param name имя человека
     * @param age возраст
     * @param email электронная почта
     * @param password пароль
     * @param secretKey секретный ключ
     */
    public Person(String name, int age, String email, String password, String secretKey) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.secretKey = secretKey;
    }

    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "Person{name='%s', age='%s', email='%s', password='%s', secretKey='%s'}",
            name, age, email, "***", "***"
        );
    }
}