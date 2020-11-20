package service;

import java.util.Scanner;

public class Console {
    public String read() {
        System.out.println("Введите математическое выражение для расчета:");
        return new Scanner(System.in).nextLine();
    }

    public void printResult(String result) {
        System.out.println("Результат: " + result);
    }
}
