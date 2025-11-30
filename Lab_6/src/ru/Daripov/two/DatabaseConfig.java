package ru.Daripov.two;

/**
 * Класс DatabaseConfig с аннотацией {@link Two} для демонстрации конфигурации.
 * 
 * <p>Демонстрирует использование аннотации @Two для хранения
 * конфигурационных параметров базы данных.
 * 
 * @author Дарипов Александр
 * @see Two
 */
@Two(first = "MySQL Database", second = 3306)
public class DatabaseConfig {
    // Поля
    private String host;
    private String username;
    private String password;
    
    // Свойства
    public String getHost() { 
        return host; 
    }

    public void setHost(String host) { 
        this.host = host; 
    }
    
    public String getUsername() { 
        return username; 
    }

    public void setUsername(String username) { 
        this.username = username; 
    }
    
    public String getPassword() { 
        return password; 
    }
    
    public void setPassword(String password) { 
        this.password = password; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public DatabaseConfig() {
        this.host = "localhost";
        this.username = "admin";
        this.password = "password";
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param host хост базы данных
     * @param username имя пользователя
     * @param password пароль
     */
    public DatabaseConfig(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }
    
    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "DatabaseConfig{host='%s', username='%s', password='%s'}",
            host, username, "***"
        );
    }
}