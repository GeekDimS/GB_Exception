package HW1;

/**
 * @author DimS on 13.11.2022
 */

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class Task1 {
    public static void main(String[] args) {
        Methods methods = new Methods();
        System.out.println(methods.method1(1));
        System.out.println(methods.method2(4));
        System.out.println(methods.method3("3"));
    }

}

class Methods {
    public int method1(int num){
        return 10/num;

    }
    public int method2(int ind) {
        int[] arr = {1, 2, 3, 4, 5};
        return arr[ind];
    }

    public int method3(String str){
        return Integer.parseInt(str);
    }
}
