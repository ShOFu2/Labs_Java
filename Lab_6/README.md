# 🎯 Лабораторная работа по Java №6

Проект демонстрирует создание и обработку пользовательских аннотаций в Java с использованием Reflection API.

## 📖 Оглавление
- [✨ Особенности](#-особенности)
- [🏗️ Архитектура проекта](#-архитектура-проекта)
- [📚 Описание аннотаций](#-описание-аннотаций)
  - [🔮 @Invoke](#-invoke)
  - [⚡ @Default](#-default)
  - [📝 @ToString](#-tostring)
  - [✅ @Validate](#-validate)
  - [🎯 @Two](#-two)
  - [💾 @Cache](#-cache)
- [🎯 Функциональность](#-функциональность)
- [👨‍💻 Разработчик](#-разработчик)

## ✨ Особенности
- **🔮 Reflection API:** Динамический анализ и вызов методов
- **🎯 Пользовательские аннотации:** 6 различных типов аннотаций
- **📝 Автогенерация toString():** Настраиваемое строковое представление объектов
- **⚡ Автоматический вызов методов:** Аннотация @Invoke для автоматического выполнения
- **✅ Валидация типов:** Аннотация @Validate для проверки объектов
- **💾 Кэширование:** Указание кэшируемых областей через аннотации
- **🎮 Интерактивное меню:** Консольный интерфейс для тестирования функциональности

## 🏗️ Архитектура проекта
- src/
- └── ru/
- └── Daripov/
- ├── cache/ # 💾 Кэширование
- │ ├── Cache.java # 🏷️ Аннотация @Cache
- │ ├── CacheHandler.java # 🛠️ Обработчик кэша
- │ ├── ProductService.java# 🏷️ Пример сервиса с кэшем
- │ ├── SimpleService.java # 🏷️ Простой сервис
- │ └── UserService.java # 🏷️ Сервис пользователей
- ├── defaults/ # ⚡ Значения по умолчанию
- │ ├── Default.java # 🏷️ Аннотация @Default
- │ ├── DefaultHandler.java# 🛠️ Обработчик значений по умолчанию
- │ ├── FieldDefaultClass.java # 🏷️ Пример класса с полями по умолчанию
- │ └── StringDefaultClass.java# 🏷️ Пример класса со строковым умолчанием
- ├── invoke/ # 🔮 Автовызов методов
- │ ├── Invoke.java # 🏷️ Аннотация @Invoke
- │ ├── InvokeClass.java # 🏷️ Пример класса с вызываемыми методами
- │ └── InvokeHandler.java # 🛠️ Обработчик автовызова
- ├── main/ # 🎮 Главное приложение
- │ └── Main.java # 🎮 Главный класс с меню
- ├── tostring/ # 📝 Строковое представление
- │ ├── Mode.java # 📊 Перечисление режимов
- │ ├── Person.java # 🏷️ Пример класса Person
- │ ├── Product.java # 🏷️ Пример класса Product
- │ ├── ToString.java # 🏷️ Аннотация @ToString
- │ └── ToStringHandler.java # 🛠️ Обработчик toString
- ├── two/ # 🎯 Двойные свойства
- │ ├── ApplicationSettings.java # 🏷️ Настройки приложения
- │ ├── DatabaseConfig.java# 🏷️ Конфигурация БД
- │ ├── Two.java # 🏷️ Аннотация @Two
- │ └── TwoHandler.java # 🛠️ Обработчик двух свойств
- ├── utils/ # 🛠️ Утилиты
- │ └── CheckInput.java # 🛡️ Валидация ввода
- └── validate/ # ✅ Валидация
- │ ├── Validate.java # 🏷️ Аннотация @Validate
- │ └── ValidateProcessor.java # 🛠️ Обработчик валидации

## 📚 Описание аннотаций

### 🔮 @Invoke
**Автоматический вызов методов через Reflection API:**
- Цель: методы
- Доступ: RUNTIME
- Особенности: автоматически вызывает помеченные методы
**Пример использования:**
  ```
  public class InvokeClass {
    @Invoke
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    @Invoke
    private void privateMethod() {
        System.out.println("Private method called");
    }
  }
### ⚡ @Default
**Указание типов по умолчанию для классов и полей:**
- Цель: классы и поля
- Доступ: RUNTIME
- Свойство: Class<?> value()
**Пример использования:**
  ```
  @Default(String.class)
  public class StringDefaultClass { }
  
  public class FieldDefaultClass {
      @Default(Integer.class)
      private Object value;
  }
### 📝 @ToString
**Настройка строкового представления объектов:**
- Цель: классы и поля
- Доступ: RUNTIME
- Свойство: Mode value() (YES/NO)
**Пример использования:**
  ```
  @ToString
  public class Person {
      private String name;
      private int age;
      
      @ToString(Mode.NO)
      private String password; // Исключено из toString()
  }
### ✅ @Validate
**Указание типов для валидации объектов:**
- Цель: классы и аннотации
- Доступ: RUNTIME
- Свойство: Class<?>[] value()
**Пример использования:**
  ```
  @Validate({String.class, Integer.class, Date.class})
  public class User {
      private String name;
      private Integer age;
      private Date birthDate;
  }
### 🎯 @Two
**Работа с двумя обязательными свойствами разных типов:**
- Цель: классы
- Доступ: RUNTIME
- Свойства: String first(), int second()
**Пример использования:**
  ```
  @Two(first = "MySQL Database", second = 3306)
  public class DatabaseConfig { }
### 💾 @Cache
**Указание кэшируемых областей класса:**
- Цель: классы
- Доступ: RUNTIME
- Свойство: String[] value()
**Пример использования:**
  ```
  @Cache({"users", "profiles", "settings"})
  public class DataService { }
## 🎯 Функциональность
### 🔮 Задание 1.1 - @Invoke 
- Автоматический вызов методов
- Результат работы:
<img width="697" height="703" alt="image" src="https://github.com/user-attachments/assets/d3f2d52e-9d19-42bd-b638-ae0603ec57ad" />

### ⚡ Задание 1.2 - @Default 
- Типы по умолчанию
- Результат работы:
<img width="425" height="730" alt="image" src="https://github.com/user-attachments/assets/dd751f00-6e12-42b1-ac9c-b3916988377b" />
<img width="424" height="308" alt="image" src="https://github.com/user-attachments/assets/6d956759-24a9-43b5-8473-b1f1e12239f0" />

### 📝 Задание 1.3 - @ToString 
- Генерация toString()
- Результат работы:
<img width="695" height="714" alt="image" src="https://github.com/user-attachments/assets/de3f9c0f-ab1c-4e3e-9da0-7188568f53e7" />

### ✅ Задание 1.4 - @Validate 
- Валидация объектов
- Результат работы:
<img width="425" height="813" alt="image" src="https://github.com/user-attachments/assets/ddc4222e-5286-4f2c-888c-aa5260bfa6f2" />
<img width="425" height="275" alt="image" src="https://github.com/user-attachments/assets/06c95d26-9455-4fc3-9b59-dc43a8beff40" />

### 🎯 Задание 1.5 - @Two 
- Два свойства разных типов
- Результат работы:
<img width="424" height="526" alt="image" src="https://github.com/user-attachments/assets/e1f0ba7a-6815-4dc1-8d77-b4b906753f84" />

### 💾 Задание 1.6 
- @Cache - Кэшируемые области
- Результат работы:
<img width="425" height="817" alt="image" src="https://github.com/user-attachments/assets/c49b569a-8323-45d5-a3b2-3a86d9a9d851" />

## 👨‍💻 Разработчик
- **Дарипов Александр**
- 📧 alelsandur608@gmail.com

