package ru.restaurant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность, представляющая клиента ресторана.
 * Содержит информацию о клиенте и его заказах.
 *
 * @author Дарипов Александр
 */
@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    /**
     * Уникальный идентификатор клиента
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    /**
     * Номер телефона клиента
     * Должен быть уникальным и соответствовать формату
     */
    @NotBlank(message = "Номер телефона обязателен")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Неверный формат телефона")
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    /**
     * Имя клиента
     */
    @NotBlank(message = "Имя клиента обязательно")
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    /**
     * Флаг, указывающий является ли клиент новым
     */
    @NotNull
    @Column(name = "is_new_customer")
    private Boolean isNewCustomer = true;

    /**
     * Дата регистрации клиента
     */
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    /**
     * Список заказов клиента
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    /**
     * Устанавливает дату регистрации перед сохранением
     * Если дата не установлена, устанавливается текущая дата
     */
    @PrePersist
    protected void onCreate() {
        if (registrationDate == null) {
            registrationDate = LocalDate.now();
        }
    }
}