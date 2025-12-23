package ru.restaurant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность, представляющая заказ в ресторане.
 * Содержит информацию о заказе и связанных позициях.
 *
 * @author Дарипов Александр
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * Уникальный идентификатор заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    /**
     * Дата оформления заказа
     */
    @NotNull(message = "Дата заказа обязательна")
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    /**
     * Время оформления заказа
     */
    @NotNull(message = "Время заказа обязательно")
    @Column(name = "order_time", nullable = false)
    private LocalTime orderTime;

    /**
     * Клиент, сделавший заказ
     */
    @NotNull(message = "Клиент обязателен")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /**
     * Идентификатор сотрудника, принявшего заказ
     */
    @NotNull(message = "ID сотрудника обязательно")
    @Min(value = 1, message = "ID сотрудника должен быть положительным")
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    /**
     * Имя сотрудника, принявшего заказ
     */
    @NotBlank(message = "Имя сотрудника обязательно")
    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    /**
     * Дата смены сотрудника
     */
    @NotNull(message = "Дата смены обязательна")
    @Column(name = "shift_date", nullable = false)
    private LocalDate shiftDate;

    /**
     * Способ оплаты заказа
     */
    @NotBlank(message = "Способ оплаты обязателен")
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    /**
     * Общая сумма заказа
     */
    @NotNull(message = "Сумма заказа обязательна")
    @DecimalMin(value = "0.01", message = "Сумма должна быть больше 0")
    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    /**
     * Список позиций в заказе
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();
}