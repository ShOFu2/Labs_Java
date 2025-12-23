package ru.restaurant.repository;

import ru.restaurant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Репозиторий для работы с сущностью Customer.
 * Предоставляет методы для доступа к данным клиентов.
 *
 * @author Дарипов Александр
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Находит клиентов по имени (частичное совпадение, без учета регистра)
     *
     * @param name Имя или часть имени для поиска
     * @return Список клиентов, чье имя содержит указанную строку
     */
    List<Customer> findByCustomerNameContainingIgnoreCase(String name);

    /**
     * Находит клиента по номеру телефона
     *
     * @param phoneNumber Номер телефона для поиска
     * @return Клиент с указанным номером телефона или null
     */
    Customer findByPhoneNumber(String phoneNumber);

    /**
     * Находит клиентов по статусу (новый/постоянный)
     *
     * @param isNew Статус клиента (true - новый, false - постоянный)
     * @return Список клиентов с указанным статусом
     */
    List<Customer> findByIsNewCustomer(Boolean isNew);
}