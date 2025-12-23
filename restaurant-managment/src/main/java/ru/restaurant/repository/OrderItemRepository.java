package ru.restaurant.repository;

import ru.restaurant.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Репозиторий для работы с сущностью OrderItem.
 * Предоставляет методы для доступа к данным позиций заказа.
 *
 * @author Дарипов Александр
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * Находит позиции заказа по идентификатору заказа
     *
     * @param orderId Идентификатор заказа
     * @return Список позиций указанного заказа
     */
    List<OrderItem> findByOrderId(Long orderId);

    /**
     * Находит позиции заказа по категории продукта
     *
     * @param category Категория продукта
     * @return Список позиций заказа с указанной категорией продукта
     */
    List<OrderItem> findByProductCategory(String category);
}