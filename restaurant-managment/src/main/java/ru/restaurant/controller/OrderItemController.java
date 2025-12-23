package ru.restaurant.controller;

import ru.restaurant.entity.Order;
import ru.restaurant.entity.OrderItem;
import ru.restaurant.service.OrderItemService;
import ru.restaurant.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления позициями заказа.
 * Обрабатывает CRUD операции для сущности OrderItem.
 *
 * @author Дарипов Александр
 */
@Controller
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    /**
     * Отображает список всех позиций заказа
     *
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона для отображения списка позиций
     */
    @GetMapping
    public String listOrderItems(Model model) {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("orderItem", new OrderItem());
        return "order-items/list";
    }

    /**
     * Отображает форму для добавления новой позиции заказа
     *
     * @param orderId ID заказа для автоматического выбора (опционально)
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона формы добавления позиции
     */
    @GetMapping("/new")
    public String showAddForm(@RequestParam(required = false) Long orderId, Model model) {
        OrderItem orderItem = new OrderItem();

        // Если передан orderId, устанавливаем его
        if (orderId != null) {
            Order order = orderService.getOrderById(orderId);
            orderItem.setOrder(order);
        }

        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orderItem", orderItem);
        model.addAttribute("orders", orders);
        return "order-items/form";
    }

    /**
     * Обрабатывает добавление новой позиции заказа
     *
     * @param orderItem Данные позиции заказа из формы
     * @param result Результат валидации
     * @param model Модель для передачи данных в представление
     * @return Перенаправление на список позиций или возврат к форме при ошибках
     */
    @PostMapping
    public String addOrderItem(@Valid @ModelAttribute OrderItem orderItem,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Order> orders = orderService.getAllOrders();
            model.addAttribute("orders", orders);
            return "order-items/form";
        }

        orderItemService.saveOrderItem(orderItem);
        return "redirect:/order-items";
    }

    /**
     * Отображает форму для редактирования существующей позиции заказа
     *
     * @param id ID позиции заказа для редактирования
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона формы редактирования позиции
     * @throws RuntimeException если позиция не найдена
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orderItem", orderItem);
        model.addAttribute("orders", orders);
        return "order-items/form";
    }

    /**
     * Обрабатывает обновление данных позиции заказа
     *
     * @param id ID позиции заказа для обновления
     * @param orderItem Обновленные данные позиции
     * @param result Результат валидации
     * @param model Модель для передачи данных в представление
     * @return Перенаправление на список позиций или возврат к форме при ошибках
     */
    @PostMapping("/update/{id}")
    public String updateOrderItem(@PathVariable Long id,
                                  @Valid @ModelAttribute OrderItem orderItem,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Order> orders = orderService.getAllOrders();
            orderItem.setId(id);
            model.addAttribute("orders", orders);
            return "order-items/form";
        }

        orderItem.setId(id);
        orderItemService.saveOrderItem(orderItem);
        return "redirect:/order-items";
    }

    /**
     * Удаляет позицию заказа по ID
     *
     * @param id ID позиции заказа для удаления
     * @return Перенаправление на список позиций
     * @throws RuntimeException если позиция не найдена
     */
    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return "redirect:/order-items";
    }
}