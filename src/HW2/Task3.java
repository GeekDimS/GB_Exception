package HW2;

//Задание 3
//        Дан следующий код, исправьте его там, где требуется
//
//public static void main(String[] args) throws Exception {
//        try {
//        int a = 90;
//        int b = 3;
//        System.out.println(a / b);
//        printSum(23, 234);
//        int[] abc = { 1, 2 };
//        abc[3] = 9;
//        } catch (Throwable ex) {
//        System.out.println("Что-то пошло не так...");
//        } catch (NullPointerException ex) {
//        System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//        System.out.println("Массив выходит за пределы своего размера!");
//        }
//        }
//public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//        System.out.println(a + b);
//        }


/**
 * @author DimS on 16.11.2022
 */
public class Task3 {
    public static void main(String[] args) /*throws */ {    // Вроде не имеет смысла куда-либо выше передавать
        // исключения
        // try {        // Более принято для Unchecked исключений проверять в коде возможные ошибки
        int a = 90;
        int b = 3;
        if (b == 0) {
            System.out.println("Операция деления на ноль");
        } else {
            System.out.println(a / b);
        }
        printSum(23, 234);  //
        int[] array = {1, 2};
        int index = 3; // Избавляемся от "магических" чисел
        if (index >= array.length || index < 0) {
            System.out.println("Массив выходит за пределы своего размера!");
        } else {
            array[index] = 9;
        }
        /*} catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");    //Не может быть в этом коде такого
            //исключения
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");    //Более принято для Unchecked исключений проверять в коде возможные ошибки
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");   // Малоинформативно и перепутан порядок исключений
        }*/
    }

    public static void printSum(Integer a, Integer b) /*throws FileNotFoundException*/ {    // Здесь в принципе не
        // может быть такого исключения
        System.out.println(a + b);
    }


}
