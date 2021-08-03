package testapplication.testTask.task3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TestApp3 {

    public static void main(String[] args) {
        Iterator numberIterator = process(Arrays.asList(22, 22, 24, 25, 25, 66, 67, 123, 124, 125, 8000, 8000, 80000, 90000).iterator(), 125);
        numberIterator.forEachRemaining(System.out::println);

    }

    /**
     * Возвращает итератор, который позволяет обойти только часть source,
     * ограниченную number, оставляя только элементы, значение которых меньше number
     *
     * @param source неубывающая бесконечная последовательность чисел.
     *               бесконечная - значит нельзя пытаться обработать source,
     *               например, использовать копирование итератора, удаление элементов и т.д.
     * @param number значение для отделения хвоста итератора
     *               <p>
     *               Пример:
     *               на вход подаётся бесконечная последовательность типа
     *               [22,22,24,25,25,66,67 ... 8000, 8000, 80000, 90000 ...]
     *               доступная для обхода часть source
     *               при number = 90000:
     *               [22,22,24,25,25,66,67 ... 8000, 8000, 80000]
     *               при number = 23:
     *               [22,22]
     * @return
     */
    // (Дмитрий) немного исправил сигнатуру метода, чтобы можно было принимать и обрабатывать любые(Comparable) Collection
    public static <T extends Comparable<? super T>> Iterator<T> process(Iterator<? extends T> source, T number) {
        Iterator processIterator = new Iterator() {
            T numNext = source.next();
            boolean has = true;

            @Override
            public boolean hasNext() {
                if (numNext.compareTo(number) > 0) {
                    has = false;
                }
                return has;
            }

            @Override
            public Object next() {
                T num = numNext;
                if (has == false) {
                    throw new NoSuchElementException();
                }
                if (source.hasNext()) {
                    numNext = source.next();
                } else {
                    has = false;
                }
                if (numNext.compareTo(number) > 0) {
                    has = false;
                }
                return num;
            }
        };
        return processIterator;
    }
}
