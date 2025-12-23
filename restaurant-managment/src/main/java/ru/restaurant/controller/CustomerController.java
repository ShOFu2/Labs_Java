package ru.restaurant.controller;

import ru.restaurant.entity.Customer;
import ru.restaurant.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления клиентами ресторана.
 * Обрабатывает CRUD операции для сущности Customer.
 *
 * @author Дарипов Александр
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Отображает список всех клиентов.
     *
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона для отображения списка клиентов
     */
    @GetMapping
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        return "customers/list";
    }

    /**
     * Отображает форму для добавления нового клиента.
     *
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона формы добавления клиента
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    /**
     * Обрабатывает добавление нового клиента.
     *
     * @param customer Данные клиента из формы
     * @param result Результат валидации
     * @param model Модель для передачи данных в представление
     * @return Перенаправление на список клиентов или возврат к форме при ошибках
     */
    @PostMapping
    public String addCustomer(@Valid @ModelAttribute Customer customer,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customer", customer);
            return "customers/form";
        }

        // Проверка уникальности телефона
        Customer existing = customerService.findByPhoneNumber(customer.getPhoneNumber());
        if (existing != null && !existing.getId().equals(customer.getId())) {
            result.rejectValue("phoneNumber", "error.customer",
                    "Клиент с таким номером телефона уже существует");
            return "customers/form";
        }

        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    /**
     * Отображает форму для редактирования существующего клиента.
     *
     * @param id ID клиента для редактирования
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона формы редактирования клиента
     * @throws RuntimeException если клиент не найден
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customers/form";
    }

    /**
     * Обрабатывает обновление данных клиента.
     *
     * @param id ID клиента для обновления
     * @param customer Обновленные данные клиента
     * @param result Результат валидации
     * @param model Модель для передачи данных в представление
     * @return Перенаправление на список клиентов или возврат к форме при ошибках
     */
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id,
                                 @Valid @ModelAttribute Customer customer,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            model.addAttribute("customer", customer);
            return "customers/form";
        }

        customer.setId(id);
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    /**
     * Удаляет клиента по ID.
     *
     * @param id ID клиента для удаления
     * @return Перенаправление на список клиентов
     * @throws RuntimeException если клиент не найден
     */
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    /**
     * Выполняет поиск клиентов по имени.
     *
     * @param name Имя или часть имени для поиска
     * @param model Модель для передачи данных в представление
     * @return Имя шаблона для отображения результатов поиска
     */
    @GetMapping("/search")
    public String searchCustomers(@RequestParam String name, Model model) {
        List<Customer> customers = customerService.searchCustomersByName(name);
        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());
        model.addAttribute("searchTerm", name);
        return "customers/list";
    }
}