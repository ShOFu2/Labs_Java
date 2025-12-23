package ru.restaurant.controller;

import ru.restaurant.entity.Customer;
import ru.restaurant.entity.Order;
import ru.restaurant.service.CustomerService;
import ru.restaurant.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления заказами ресторана.
 * Обрабатывает CRUD операции для сущности Order.
 *
 * @author Дарипов Александр
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    /**
     * Отображает список всех заказов
     *
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона для отображения списка заказов
     */
    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("order", new Order());
        return "orders/list";
    }

    /**
     * Отображает форму для создания нового заказа
     *
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона формы создания заказа
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customers);
        return "orders/form";
    }

    /**
     * Обрабатывает создание нового заказа
     *
     * @param order Данные заказа из формы
     * @param result Результат валидации
     * @param model Модель для передачи данных в представление
     * @return Перенаправление на список заказов или возврат к форме при ошибках
     */
    @PostMapping
    public String addOrder(@Valid @ModelAttribute Order order,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Customer> customers = customerService.getAllCustomers();
            model.addAttribute("customers", customers);
            return "orders/form";
        }

        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    /**
     * Отображает форму для редактирования существующего заказа
     *
     * @param id ID заказа для редактирования
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона формы редактирования заказа
     * @throws RuntimeException если заказ не найден
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("order", order);
        model.addAttribute("customers", customers);
        return "orders/form";
    }

    /**
     * Обрабатывает обновление данных заказа
     *
     * @param id ID заказа для обновления
     * @param order Обновленные данные заказа
     * @param result Результат валидации
     * @param model Модель для передачи данных в представление
     * @return Перенаправление на список заказов или возврат к форме при ошибках
     */
    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id,
                              @Valid @ModelAttribute Order order,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Customer> customers = customerService.getAllCustomers();
            order.setId(id);
            model.addAttribute("customers", customers);
            return "orders/form";
        }

        order.setId(id);
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    /**
     * Удаляет заказ по ID
     *
     * @param id ID заказа для удаления
     * @return Перенаправление на список заказов
     * @throws RuntimeException если заказ не найден
     */
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    /**
     * Отображает детальную информацию о заказе
     *
     * @param id ID заказа для просмотра
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона для отображения деталей заказа
     * @throws RuntimeException если заказ не найден
     */
    @GetMapping("/details/{id}")
    public String orderDetails(@PathVariable Long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "orders/details";
    }
}