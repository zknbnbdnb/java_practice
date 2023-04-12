package code;

import java.util.Random;
import java.util.Scanner;

interface Sortt {
    public int[] aSort();
    public void aShow();
}

class data {
    public int arr[];
    private int n;

    public void setN(int n) {
        this.n = n;
    }

    public int[] data() {
        if (n <= 0) {
            System.out.println("数据异常");
            return arr;
        }
        arr = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }

    public int[] data(int size){
        if (size % 1 == 0) {
            System.out.println("数据异常");
            return arr;
        }
        arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }
}

public class lianxi5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        data ca = new data();
        ca.setN(n);

        int arr1[] = ca.data();
        int arr2[] = ca.data();
        int arr3[] = ca.data();
        int arr4[] = ca.data();
        int arr5[] = ca.data();
        int arr6[] = ca.data();
        int arr7[] = ca.data();
        int arr8[] = ca.data();
        int arr9[] = ca.data();
        int arr0[] = ca.data();

        BS_5 bs = new BS_5();
        BI_5 bi = new BI_5();
        CR_5 cr = new CR_5();
        HM_5 hm = new HM_5();
        QS_5 qs = new QS_5();

        bs.setMylist(arr1);
        bs.bubbleSort();
        bs.aShow();

        bs.setMylist(arr2);
        bs.selectSort();
        bs.aShow();

        bi.setMylist(arr3);
        bi.binInsertSort();
        bi.aShow();

        bi.setMylist(arr4);
        bi.insertSort();
        bi.aShow();

        cr.setMylist(arr5);
        cr.countSort();
        cr.aShow();

        cr.setMylist(arr6);
        cr.radixSort();
        cr.aShow();

        hm.setMylist(arr7);
        hm.heapSort();
        hm.aShow();

        hm.setMylist(arr8);
        hm.margeSort_g();
        hm.aShow();

        qs.setMylist(arr9);
        qs.quickSort();
        qs.aShow();

        qs.setMylist(arr0);
        qs.shellSort();
        qs.aShow();

    }
}
