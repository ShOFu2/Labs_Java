package ru.restaurant.service;

import ru.restaurant.entity.Customer;
import ru.restaurant.entity.Order;
import ru.restaurant.repository.CustomerRepository;
import ru.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с заказами.
 * Содержит бизнес-логику для операций с заказами.
 *
 * @author Дарипов Александр
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Получает список всех заказов
     *
     * @return Список всех заказов
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Получает заказ по идентификатору
     *
     * @param id Идентификатор заказа
     * @return Найденный заказ
     * @throws RuntimeException если заказ не найден
     */
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new RuntimeException("Заказ не найден с ID: " + id));
    }

    /**
     * Сохраняет заказ (создание или обновление)
     * Проверяет существование клиента перед сохранением
     *
     * @param order Заказ для сохранения
     * @return Сохраненный заказ
     * @throws RuntimeException если клиент не указан или не найден
     */
    public Order saveOrder(Order order) {
        // Проверяем существование клиента
        if (order.getCustomer() == null || order.getCustomer().getId() == null) {
            throw new RuntimeException("Клиент не указан");
        }

        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Клиент не найден с ID: " + order.getCustomer().getId()));

        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    /**
     * Удаляет заказ по идентификатору
     *
     * @param id Идентификатор заказа для удаления
     * @throws RuntimeException если заказ не найден
     */
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Заказ не найден с ID: " + id);
        }
        orderRepository.deleteById(id);
    }

    /**
     * Получает список заказов по идентификатору клиента
     *
     * @param customerId Идентификатор клиента
     * @return Список заказов клиента
     */
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }
}