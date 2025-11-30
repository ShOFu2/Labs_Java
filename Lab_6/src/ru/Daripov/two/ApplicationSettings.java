package ru.Daripov.two;

/**
 * Класс ApplicationSettings с аннотацией {@link Two} для демонстрации настроек приложения.
 * 
 * <p>Демонстрирует использование аннотации @Two для хранения
 * основных настроек приложения.
 * 
 * @author Дарипов Александр
 * @version 1.0
 * @see Two
 */
@Two(first = "Production Mode", second = 8080)
public class ApplicationSettings {
    // Поля
    private String appName;
    private String version;
    private boolean debugMode;
    
    // Геттеры и сеттеры
    public String getAppName() { 
        return appName; 
    }

    public void setAppName(String appName) { 
        this.appName = appName; 
    }
    
    public String getVersion() { 
        return version; 
    }

    public void setVersion(String version) { 
        this.version = version; 
    }
    
    public boolean isDebugMode() { 
        return debugMode; 
    }

    public void setDebugMode(boolean debugMode) { 
        this.debugMode = debugMode; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public ApplicationSettings() {
        this.appName = "MyApplication";
        this.version = "1.0.0";
        this.debugMode = false;
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param appName название приложения
     * @param version версия
     * @param debugMode режим отладки
     */
    public ApplicationSettings(String appName, String version, boolean debugMode) {
        this.appName = appName;
        this.version = version;
        this.debugMode = debugMode;
    }
    
    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "ApplicationSettings{appName='%s', version='%s', debugMode=%s}",
            appName, version, debugMode
        );
    }
}