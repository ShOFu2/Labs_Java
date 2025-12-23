package ru.restaurant.service;

import ru.restaurant.entity.Customer;
import ru.restaurant.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с клиентами.
 * Содержит бизнес-логику для операций с клиентами.
 *
 * @author Дарипов Александр
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Получает список всех клиентов
     *
     * @return Список всех клиентов
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Получает клиента по идентификатору
     *
     * @param id Идентификатор клиента
     * @return Найденный клиент
     * @throws RuntimeException если клиент не найден
     */
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(() -> new RuntimeException("Клиент не найден с ID: " + id));
    }

    /**
     * Сохраняет клиента (создание или обновление)
     *
     * @param customer Клиент для сохранения
     * @return Сохраненный клиент
     */
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Удаляет клиента по идентификатору
     *
     * @param id Идентификатор клиента для удаления
     * @throws RuntimeException если клиент не найден
     */
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Клиент не найден с ID: " + id);
        }
        customerRepository.deleteById(id);
    }

    /**
     * Ищет клиентов по имени (частичное совпадение, без учета регистра)
     *
     * @param name Имя или часть имени для поиска
     * @return Список найденных клиентов
     */
    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.findByCustomerNameContainingIgnoreCase(name);
    }

    /**
     * Находит клиента по номеру телефона
     *
     * @param phoneNumber Номер телефона для поиска
     * @return Найденный клиент или null
     */
    public Customer findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }
}