package HW1;

import java.util.Arrays;

/**
 * @author DimS on 13.11.2022
 */

// 2) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не
// равны, необходимо как-то оповестить пользователя.

public class Task2 {
    public static void main(String[] args) {
        int[] inArr1 = new int[]{9, 8, 7, 6, 5};
        int[] inArr2 = new int[]{4, 3, 2, 1}; // {4, 3, 2, 1, 0}

        Implementation implementation = new Implementation();
        System.out.println(Arrays.toString(implementation.subArray(inArr1, inArr2)));
    }
}

class Implementation {

    int[] subArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Different size of arrays");
        }

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i] - arr2[i];
        }
        return res;
    }
}