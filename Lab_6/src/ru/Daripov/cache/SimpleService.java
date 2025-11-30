package ru.Daripov.cache;

/**
 * Класс SimpleService с аннотацией {@link Cache} без указания областей.
 * 
 * <p>Демонстрирует использование аннотации @Cache без указания
 * конкретных областей кэширования (пустой массив по умолчанию).
 * 
 * @author Дарипов Александр
 * @see Cache
 */
@Cache
public class SimpleService {
    // Поля
    private String name;
    private String description;
    
    // Свойства
    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }
    
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public SimpleService() {
        this.name = "Simple Service";
        this.description = "A service without specific cache areas";
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param name название сервиса
     * @param description описание
     */
    public SimpleService(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "SimpleService{name='%s', description='%s'}",
            name, description
        );
    }
}