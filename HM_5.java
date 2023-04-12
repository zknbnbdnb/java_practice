package code;

import java.util.ArrayList;
import java.util.Arrays;

public class HM_5 {
    private int[] mylist;
    private int[] marge_res;
    public void setMylist(int[] mylist) {
        this.mylist = mylist;
    }

    public void aShow() {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }

    public void adjustHeap(int[] mylist, int i, int leng) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (i < leng / 2) {
            if ((leftChild < leng) && (mylist[leftChild] > mylist[max])) {
                max = leftChild;
            }if ((rightChild < leng) && (mylist[rightChild] > mylist[max])) {
                max = rightChild;
            }if (max != i) {
                int temp = mylist[max];
                mylist[max] = mylist[i];
                mylist[i] = temp;
                adjustHeap(mylist, max, leng);
            }
        }
    }

    public void buildHeap(int[] mylist, int le) {
        int len = mylist.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(mylist, i, len);
        }
    }

    public int[] heapSort() {
        int len = mylist.length;
        buildHeap(mylist, len);
        for (int i = len - 1; i >= 0; i--) {
            int temp = mylist[0];
            mylist[0] = mylist[i];
            mylist[i] = temp;
            adjustHeap(mylist, 0 ,i);
        }
        return mylist;
    }

    public int[] marge(int[] left, int[] right) {
        ArrayList res = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                res.add(left[i]);
                i += 1;
            }else {
                res.add(right[j]);
                j += 1;
            }
        }
        for (int temp1 = i; temp1 < left.length; temp1++) {
            res.add(left[temp1]);
        }
        for (int temp2 = j; temp2 < right.length; temp2++) {
            res.add(right[temp2]);
        }
        int ress[] = new int[res.size()];
        for (int k = 0; k < ress.length; k++) {
            ress[k] = (int) res.get(k);
        }
        return ress;
    }
    public int[] margeSort(int[] mylist) {
        if (mylist.length <= 1) {
            return mylist;
        }
        int mid = mylist.length / 2;
        int[] left = margeSort(Arrays.copyOfRange(mylist, 0, mid));
        int[] right = margeSort(Arrays.copyOfRange(mylist, mid, mylist.length));
        this.mylist = marge(left, right);
        return this.mylist;
    }

    public int[] margeSort_g(){
        margeSort(mylist);
        return mylist;
    }
}
