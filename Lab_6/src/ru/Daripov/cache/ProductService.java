package ru.Daripov.cache;

/**
 * Класс ProductService с аннотацией {@link Cache} для демонстрации кэширования товаров.
 * 
 * <p>Демонстрирует использование аннотации @Cache с областями
 * кэширования, связанными с товарами и заказами.
 * 
 * @author Дарипов Александр
 * @see Cache
 */
@Cache({"products", "categories", "inventory", "orders"})
public class ProductService {
    // Поля
    private String catalogName;
    private double version;
    private boolean isCacheEnabled;
    
    // Геттеры и сеттеры
    public String getCatalogName() { 
        return catalogName; 
    }

    public void setCatalogName(String catalogName) { 
        this.catalogName = catalogName; 
    }
    
    public double getVersion() { 
        return version; 
    }

    public void setVersion(double version) { 
        this.version = version; 
    }
    
    public boolean isCachingEnabled() { 
        return isCacheEnabled; 
    }

    public void setCachingEnabled(boolean isCacheEnabled) { 
        this.isCacheEnabled = isCacheEnabled; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public ProductService() {
        this.catalogName = "Product Catalog";
        this.version = 1.0;
        this.isCacheEnabled = true;
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param catalogName название каталога
     * @param version версия
     * @param isCacheEnabled включено ли кэширование
     */
    public ProductService(String catalogName, double version, boolean isCacheEnabled) {
        this.catalogName = catalogName;
        this.version = version;
        this.isCacheEnabled = isCacheEnabled;
    }
    
    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "ProductService{catalogName='%s', version=%.1f, isCacheEnabled=%s}",
            catalogName, version, isCacheEnabled
        );
    }
}