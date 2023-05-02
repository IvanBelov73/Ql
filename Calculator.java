
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Calculator {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = sc.nextLine();
        String result = calc(input);
        System.out.println("Результат операции: " + result);
    }

    static String calc(String input) throws Exception {
        String[] array = input.split(" ");
        if (array.length != 3) {
            throw new Exception(" т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int a = parseInt(array[0]);// преобарзуем строки в число
        int b = parseInt(array[2]);
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10");
        }
        int result;
        switch (array[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception(" Ошибка операции ");
        }
        return Integer.toString(result);//преобразуем число в строку
    }
}
