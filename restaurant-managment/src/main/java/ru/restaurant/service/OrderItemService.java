package ru.restaurant.service;

import ru.restaurant.entity.Order;
import ru.restaurant.entity.OrderItem;
import ru.restaurant.repository.OrderItemRepository;
import ru.restaurant.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с позициями заказа.
 * Содержит бизнес-логику для операций с позициями заказа.
 *
 * @author Дарипов Александр
 */
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Получает список всех позиций заказа
     *
     * @return Список всех позиций заказа
     */
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    /**
     * Получает позицию заказа по идентификатору
     *
     * @param id Идентификатор позиции заказа
     * @return Найденная позиция заказа
     * @throws RuntimeException если позиция не найдена
     */
    public OrderItem getOrderItemById(Long id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        return orderItem.orElseThrow(() -> new RuntimeException("Позиция заказа не найдена с ID: " + id));
    }

    /**
     * Сохраняет позицию заказа (создание или обновление)
     * Проверяет существование заказа перед сохранением
     *
     * @param orderItem Позиция заказа для сохранения
     * @return Сохраненная позиция заказа
     * @throws RuntimeException если заказ не указан или не найден
     */
    public OrderItem saveOrderItem(OrderItem orderItem) {
        // Проверяем существование заказа
        if (orderItem.getOrder() == null || orderItem.getOrder().getId() == null) {
            throw new RuntimeException("Заказ не указан");
        }

        Order order = orderRepository.findById(orderItem.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Заказ не найден с ID: " + orderItem.getOrder().getId()));

        orderItem.setOrder(order);
        return orderItemRepository.save(orderItem);
    }

    /**
     * Удаляет позицию заказа по идентификатору
     *
     * @param id Идентификатор позиции заказа для удаления
     * @throws RuntimeException если позиция не найдена
     */
    public void deleteOrderItem(Long id) {
        if (!orderItemRepository.existsById(id)) {
            throw new RuntimeException("Позиция заказа не найдена с ID: " + id);
        }
        orderItemRepository.deleteById(id);
    }

    /**
     * Получает список позиций заказа по идентификатору заказа
     *
     * @param orderId Идентификатор заказа
     * @return Список позиций указанного заказа
     */
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}