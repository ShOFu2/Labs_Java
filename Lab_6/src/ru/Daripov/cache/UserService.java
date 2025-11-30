package ru.Daripov.cache;

/**
 * Класс UserService с аннотацией {@link Cache} для демонстрации кэширования пользователей.
 * 
 * <p>Демонстрирует использование аннотации @Cache с несколькими
 * областями кэширования, связанными с пользователями.
 * 
 * @author Дарипов Александр
 * @see Cache
 */
@Cache({"users", "profiles", "permissions"})
public class UserService {
    // Поля
    private String serviceName;
    private int maxUsers;
    private boolean isActive;
    
    // Свойства
    public String getServiceName() { 
        return serviceName; 
    }

    public void setServiceName(String serviceName) { 
        this.serviceName = serviceName; 
    }
    
    public int getMaxUsers() { 
        return maxUsers; 
    }

    public void setMaxUsers(int maxUsers) { 
        this.maxUsers = maxUsers; 
    }
    
    public boolean isActive() { 
        return isActive; 
    }

    public void setActive(boolean isActive) { 
        this.isActive = isActive; 
    }
    
    /**
     * Конструктор по умолчанию.
     */
    public UserService() {
        this.serviceName = "User Management Service";
        this.maxUsers = 1000;
        this.isActive = true;
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param serviceName название сервиса
     * @param maxUsers максимальное количество пользователей
     * @param isActive активен ли сервис
     */
    public UserService(String serviceName, int maxUsers, boolean isActive) {
        this.serviceName = serviceName;
        this.maxUsers = maxUsers;
        this.isActive = isActive;
    }
    
    /**
     * Стандартный метод toString().
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format(
            "UserService{serviceName='%s', maxUsers=%d, isActive=%s}",
            serviceName, maxUsers, isActive
        );
    }
}