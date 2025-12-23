package ru.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для главной страницы приложения.
 *
 * @author Дарипов Александр
 */
@Controller
public class HomeController {

    /**
     * Отображает главную страницу приложения
     *
     * @return Имя шаблона главной страницы
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }
}