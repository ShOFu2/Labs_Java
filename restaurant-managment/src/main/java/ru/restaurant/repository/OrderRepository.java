package ru.restaurant.repository;

import ru.restaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

/**
 * Репозиторий для работы с сущностью Order.
 * Предоставляет методы для доступа к данным заказов.
 *
 * @author Дарипов Александр
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * Находит заказы по идентификатору клиента
     *
     * @param customerId Идентификатор клиента
     * @return Список заказов указанного клиента
     */
    List<Order> findByCustomerId(Long customerId);

    /**
     * Находит заказы в указанном диапазоне дат
     *
     * @param startDate Начальная дата диапазона
     * @param endDate Конечная дата диапазона
     * @return Список заказов в указанном диапазоне дат
     */
    List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Находит заказы по способу оплаты
     *
     * @param paymentMethod Способ оплаты
     * @return Список заказов с указанным способом оплаты
     */
    List<Order> findByPaymentMethod(String paymentMethod);

    /**
     * Находит заказы по идентификатору сотрудника
     *
     * @param employeeId Идентификатор сотрудника
     * @return Список заказов, принятых указанным сотрудником
     */
    List<Order> findByEmployeeId(Integer employeeId);
}