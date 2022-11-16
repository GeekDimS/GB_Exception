package HW2;

import java.util.Scanner;

/**
 * @author DimS on 16.11.2022
 */

// Разработайте программу, которая выбросит Exception,
// когда пользователь вводит пустую строку. Пользователю должно показаться сообщение,
// что пустые строки вводить нельзя.

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        Processing processing = new Processing();
        try {
            System.out.println("Вы ввели строку " + processing.procInString());
        } catch (EmptyStringException e) {
            System.out.println(e);
        }

        System.out.println("Программа завершена");
    }
}

class Processing {
    String procInString() throws EmptyStringException {
        Scanner scanner = new Scanner(System.in);
        String inpStr = scanner.nextLine();
        if (inpStr == "") {
            throw new EmptyStringException("Пустые строки вводить нельзя");
        }
        return inpStr;
    }
}

class EmptyStringException extends Exception {

    public EmptyStringException(String message) {
        super(message);
    }
}