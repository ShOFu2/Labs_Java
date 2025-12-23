package ru.restaurant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * Сущность, представляющая позицию в заказе.
 * Содержит информацию о продукте, его количестве и цене.
 *
 * @author Дарипов Александр
 */
@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    /**
     * Уникальный идентификатор позиции заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    /**
     * Заказ, к которому относится позиция
     */
    @NotNull(message = "Заказ обязателен")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    /**
     * Идентификатор продукта
     */
    @NotNull(message = "ID продукта обязательно")
    @Min(value = 1, message = "ID продукта должен быть положительным")
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    /**
     * Название продукта
     */
    @NotBlank(message = "Название продукта обязательно")
    @Column(name = "product_name", nullable = false)
    private String productName;

    /**
     * Категория продукта (Напитки, Выпечка, Десерт)
     */
    @NotBlank(message = "Категория продукта обязательна")
    @Column(name = "product_category", nullable = false)
    private String productCategory;

    /**
     * Размер продукта (используется только для напитков)
     */
    @Column(name = "product_size")
    private String productSize;

    /**
     * Базовая цена за единицу продукта
     */
    @NotNull(message = "Базовая цена обязательна")
    @DecimalMin(value = "0.01", message = "Цена должна быть больше 0")
    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    /**
     * Количество единиц продукта
     */
    @NotNull(message = "Количество обязательно")
    @Min(value = 1, message = "Количество должно быть не менее 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * Итоговая цена (базовая цена × количество)
     */
    @NotNull(message = "Итоговая цена обязательна")
    @DecimalMin(value = "0.01", message = "Цена должна быть больше 0")
    @Column(name = "final_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal finalPrice;
}