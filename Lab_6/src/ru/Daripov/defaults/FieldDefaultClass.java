package ru.Daripov.defaults;

/**
 * Класс с аннотацией {@link Default} на уровне поля.
 * 
 * <p>Демонстрирует использование аннотации @Default для указания
 * типа по умолчанию для отдельных полей класса.
 * 
 * @author Дарипов Александр
 * @see Default
 */
public class FieldDefaultClass {
    /**
     * Поле с типом по умолчанию Integer.
     */
    @Default(Integer.class)
    private Object numericValue;
    
    /**
     * Поле с типом по умолчанию String.
     */
    @Default(String.class)
    private Object textValue;
    
    /**
     * Поле без аннотации @Default.
     */
    private Object unannotatedValue;
    
    /**
     * Конструктор по умолчанию.
     */
    public FieldDefaultClass() {
        this.numericValue = 0;
        this.textValue = "default";
        this.unannotatedValue = null;
    }
    
    /**
     * Конструктор с параметрами.
     * 
     * @param numericValue числовое значение
     * @param textValue текстовое значение
     * @param unannotatedValue значение без аннотации
     */
    public FieldDefaultClass(Object numericValue, Object textValue, Object unannotatedValue) {
        this.numericValue = numericValue;
        this.textValue = textValue;
        this.unannotatedValue = unannotatedValue;
    }
    
    /**
     * Возвращает строковое представление объекта.
     * 
     * @return строковое представление
     */
    @Override
    public String toString() {
        return String.format(
            "FieldDefaultClass{numericValue=%s (%s), textValue=%s (%s), unannotatedValue=%s}",
            numericValue, numericValue != null ? numericValue.getClass().getSimpleName() : "null",
            textValue, textValue != null ? textValue.getClass().getSimpleName() : "null",
            unannotatedValue
        );
    }
}