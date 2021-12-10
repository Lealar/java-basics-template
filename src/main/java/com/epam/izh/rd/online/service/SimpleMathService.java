package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        return Integer.compare(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return Integer.max(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Переданный аргумент в функцию равен null");
        }
        int maxElement = values[0];
        for (int element : values) {
            if (element > maxElement) {
                maxElement = element;
            }
        }
        return maxElement;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int element : values) {
            sum += element;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        if (values == null) {
            throw new NullPointerException("Empty list");
        }
        List<Integer> evenDigitsList = new ArrayList<>();
        for (int number : values) {
            if (number % 2 == 0) {
                evenDigitsList.add(number);
            }
        }
        int[] evenDigitsArray = new int[evenDigitsList.size()];
        for (int i = 0; i < evenDigitsList.size(); i++) {
            evenDigitsArray[i] = evenDigitsList.get(i);
        }
        return evenDigitsArray;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        if (initialVal < 0 || initialVal > 20) {
            throw new IllegalArgumentException("Некорректно передан аргумент функции, " +
                    "аргумент должен быть больше 0 и меньше 93" + initialVal);
        } else if (initialVal == 0) {
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= initialVal; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number < 0 || number >= 93) {
            throw new IllegalArgumentException("Некорректно передан аргумент функции, " +
                    "аргумент должен быть больше 0 и меньше 93" + number);
        } else if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        long[] fibonacciSequence = new long[number + 1];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        for (int i = 2; i <= number; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        return fibonacciSequence[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int[] sortedArray = values.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Аргумент функции должен быть больше 0, прееданный аргумент = " + number);
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] reverseSequence = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            reverseSequence[i] = values[values.length - 1 - i];
        }

        return reverseSequence;
    }
}
