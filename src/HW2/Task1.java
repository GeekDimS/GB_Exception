package HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author DimS on 13.11.2022
 */

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у
// пользователя ввод данных.

public class Task1 {
    public static void main(String[] args) {
        InputFloat inputFloat = new InputFloat();
        System.out.println(inputFloat.getFloat());
    }
}

class InputFloat {
    private float num;

    InputFloat() {
        this.num = 0;
    }

    public float getFloat() {
        do {
            System.out.println("Введите число c плавающей запятой ");
        } while (!getFloatValue());

        return num;
    }

    public boolean getFloatValue() {
        Scanner scanner = new Scanner(System.in);
        try {
            this.num = scanner.nextFloat();
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Введённая строка не является числом с плавающей запятой. ");
            return false;
        }
        return true;
    }

}