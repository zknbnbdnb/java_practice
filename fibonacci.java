package code;

import java.util.Scanner;

class fibo {
    public int[] fiboArray(int[] array) {
        int len = array.length;
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < len; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }
}
public class fibonacci {
    public static void main(String[] args) {
        fibo Fi = new fibo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int len = scanner.nextInt();
        int array[] = new int [len];
        array = Fi.fiboArray(array);
        System.out.println("斐波那契数组的为：");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%10d", array[i]);
            if (((i + 1) % 10) == 0) {
                System.out.println();
            }
        }
    }
}
