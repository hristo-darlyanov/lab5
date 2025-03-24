/**
 * Generic container that holds a value.
 */
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    
    /** 
     * @return T
     */
    public T getValue() {
        return value;
    }
}

/**
 * A container for numeric values; provides a method to return the square of the number.
 */
class NumericBox<T extends Number> {
    private T num;

    public NumericBox(T num) {
        this.num = num;
    }

    public double square() {
        return num.doubleValue() * num.doubleValue();
    }
}

/**
 * Utility class for demonstrating operations on generic boxes.
 */
class OtherBox<T> {
    static void print(OtherBox<?> box) {
        System.out.println(box);
    }

    static void test() {
        // Пример для недостатки
        Integer a = 1000, b = 1000;
        System.out.println(a == b); // false (разные объекты)

        Integer c = 127, d = 127;
        System.out.println(c == d); // true (кэширование значений -128 до 127)
    }
}
