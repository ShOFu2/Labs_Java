package ru.Daripov.tostring;

import ru.Daripov.validate.Validate;

/**
 * Класс Product с различными типами полей для демонстрации аннотации {@link ToString}
 * и с аннотацией {@link Validate} для демонстрации валидации товаров.
 * 
 * <p>Демонстрирует использование аннотации @Validate с типами,
 * характерными для товаров и продуктов.
 * 
 * <p>Содержит поля разных типов данных для тестирования форматирования
 * строкового представления.
 * 
 * @author Дарипов Александр
 * @see ToString
 */
@Validate({String.class, Double.class, Boolean.class, Integer.class})
@ToString(Mode.YES)
public class Product {
    private String name;
    private Double price;
    private Integer quantity;
    private Boolean available;
    
    /**
     * Поле исключено из строкового представления.
     */
    @ToString(Mode.NO)
    private String internalCode;
    
    /**
     * Еще одно исключенное поле.
     */
    @ToString(Mode.NO)
    private String temporaryData;
    
    // Геттеры и сеттеры
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public double getPrice() { 
        return price; 
    }
    
    public void setPrice(double price) { 
        this.price = price; 
    }
    
    public int getQuantity() { 
        return quantity; 
    }
    
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }
    
    public boolean isAvailable() { 
        return available; 
    }
    
    public void setAvailable(boolean available) { 
        this.available = available; 
    }
    
    public String getInternalCode() { 
        return internalCode; 
    }
    
    public void setInternalCode(String internalCode) { 
        this.internalCode = internalCode; 
    }
    
    public String getTemporaryData() { 
        return temporaryData; 
    }
    
    public void setTemporaryData(String temporaryData) { 
        this.temporaryData = temporaryData; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public Product() {
        this.name = "Unnamed Product";
        this.price = 0.0;
        this.quantity = 0;
        this.available = false;
        this.internalCode = "CODE-001";
        this.temporaryData = "temp";
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param name название товара
     * @param price цена
     * @param quantity количество
     * @param available доступность
     * @param internalCode внутренний код
     * @param temporaryData временные данные
     */
    public Product(String name, double price, int quantity, boolean available, 
                   String internalCode, String temporaryData) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
        this.internalCode = internalCode;
        this.temporaryData = temporaryData;
    }

    /**
     * Конструктор с параметрами.
     * 
     * @param name название товара
     * @param price цена
     * @param available доступность
     * @param stockQuantity количество на складе
     */
    public Product(String name, Double price, Boolean available, Integer quantity) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.quantity = quantity;
        this.internalCode = "CODE-001";
        this.temporaryData = "temp";
    }

    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "Product{name='%s', price='%s', available='%s', quantity='%s'}",
            name, price, available, quantity
        );
    }
}