package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

abstract class sortAbstract {
    public abstract int[] sort(int[] mylist);
}

class inS extends sortAbstract {
    public int[] sort(int[] mylist) {
        int len = mylist.length;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            if (mylist[i] < mylist[j]) {
                int temp = mylist[i];
                mylist[i] = mylist[j];
                j -= 1;
                while ((j >= 0) && (temp < mylist[j])) {
                    mylist[j + 1] = mylist[j];
                    j -= 1;
                }
                mylist[j + 1] = temp;
            }
        }
        return mylist;
    }
}

class biS extends sortAbstract {
    public int[] sort(int[] mylist) {
        for (int i = 1; i < mylist.length; i++) {
            int low = 0;
            int high = i - 1;
            int temp = mylist[i];
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mylist[mid] < temp) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            int j = i - 1;
            while (j > high) {
                mylist[j + 1] = mylist[j];
                j -= 1;
            }
            mylist[high + 1] = temp;
        }
        return mylist;
    }
}

class shS extends sortAbstract {
    public int[] sort(int[] mylist) {
        int len = mylist.length;
        int gap = len / 2;
        while (gap >= 1) {
            for (int j = gap; j < len; j++) {
                int i = j;
                while ((i - gap) >= 0) {
                    if (mylist[i] < mylist[i - gap]) {
                        int temp = mylist[i];
                        mylist[i] = mylist[i - gap];
                        mylist[i - gap] = temp;
                        i -= gap;
                    }else {
                        break;
                    }
                }
            }
            gap /= 2;
        }
        return mylist;
    }
}

class bubS extends sortAbstract {
    public int[] sort(int[] mylist) {
        int len = mylist.length;
        while (len > 0) {
            len -= 1;
            int cur = 0;
            while (cur < len) {
                if (mylist[cur] > mylist[cur + 1]) {
                    int temp = mylist[cur];
                    mylist[cur] = mylist[cur + 1];
                    mylist[cur + 1] = temp;
                }
                cur += 1;
            }
        }
        return mylist;
    }
}

class quS extends sortAbstract {
    public int[] sort(int[] mylist) {
        int low = 0;
        int high = mylist.length - 1;
        mylist = qs(mylist, low, high);
        return mylist;
    }

    public int[] qs(int[] mylist, int low, int high) {
        if (low >= high) {
            return mylist;
        }
        int pivot = mylist[low];
        int i = low;
        int j = high;
        while (low < high) {
            while ((low < high) && mylist[high] >= pivot) {
                high -= 1;
            }
            mylist[low] = mylist[high];
            while ((low < high) && mylist[low] <= pivot) {
                low += 1;
            }
            mylist[high] = mylist[low];
        }
        mylist[high] = pivot;
        qs(mylist, i, low - 1);
        qs(mylist, low + 1, j);
        return mylist;
    }
}

class selS extends sortAbstract {
    public int[] sort(int[] mylist) {
        int len = mylist.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (mylist[i] > mylist[j]) {
                    int temp = mylist[i];
                    mylist[i] = mylist[j];
                    mylist[j] = temp;
                }
            }
        }
        return mylist;
    }
}

class maS extends sortAbstract {
    public int[] sort(int[] mylist) {
        if (mylist.length <= 1) {
            return mylist;
        }
        int mid = mylist.length / 2;
        int[] left = sort(Arrays.copyOfRange(mylist, 0, mid));
        int[] right = sort(Arrays.copyOfRange(mylist, mid, mylist.length));
        return marge(left, right);
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
}

class adS extends sortAbstract {
    public int[] sort(int[] mylist){
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
}

class raS extends sortAbstract {
    public int[] sort(int[] mylist){
        int max = Arrays.stream(mylist).max().getAsInt();
        int len = String.valueOf(max).length();
        int radix = 10;
        int tempArray [] = new int[mylist.length];
        int count [] = new int[radix];

        int rate = 1;
        for (int i = 0; i < len; i++) {
            Arrays.fill(count, 0);
            System.arraycopy(mylist, 0, tempArray, 0, mylist.length);

            for (int j = 0; j < mylist.length; j++) {
                int key = (tempArray[j] / rate) % radix;
                count[key]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] += count[j - 1];
            }

            for (int m = mylist.length - 1; m >= 0; m--) {
                int key = (tempArray[m] / rate) % radix;
                mylist[--count[key]] = tempArray[m];
            }
            rate *= radix;
        }
        return mylist;
    }
}

class couS extends sortAbstract {
    public int[] sort(int[] mylist){
        int max = Arrays.stream(mylist).max().getAsInt();
        int min = Arrays.stream(mylist).min().getAsInt();
        int len = mylist.length;
        int temp[] = new int [max - min + 1];
        for (int i = 0; i < len; i++) {
            temp[mylist[i] - min] += 1;
        }
        for (int i = 0, index = 0; i < temp.length; i++) {
            int tem = temp[i];
            while (tem -- != 0) {
                mylist[index++] = i + min;
            }
        }
        return mylist;
    }
}

class sortContext {
    private sortAbstract ssort = null;

    public sortContext(String type) {
        switch (type) {
            case "ins":
                ssort = new inS();
                break;
            case "bis":
                ssort = new biS();
                break;
            case "shs":
                ssort = new shS();
                break;
            case "bubs":
                ssort = new bubS();
                break;
            case "qus":
                ssort = new quS();
                break;
            case "sels":
                ssort = new selS();
                break;
            case "mas":
                ssort = new maS();
                break;
            case "ads":
                ssort = new adS();
                break;
            case "ras":
                ssort = new raS();
                break;
            case "cous":
                ssort = new couS();
                break;
        }
    }

    int[] getAarry (int size) {
        int arr[];
        arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }

    void showAarry (int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", arr[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }

    int[] getSortArr(int[] arr) {
        return ssort.sort(arr);
    }
}

public class lianxi7 {
    public static void main (String[] args) {
        int size = 100;

        sortContext ins = new sortContext("ins");
        int[] arr1 = ins.getAarry(size);
        ins.showAarry(arr1);
        ins.getSortArr(arr1);
        System.out.println();
        ins.showAarry(arr1);

        sortContext bis = new sortContext("bis");
        int[] arr2 = bis.getAarry(size);
        bis.showAarry(arr2);
        bis.getSortArr(arr2);
        System.out.println();
        bis.showAarry(arr2);

        sortContext shs = new sortContext("shs");
        int[] arr3 = shs.getAarry(size);
        shs.showAarry(arr3);
        shs.getSortArr(arr3);
        System.out.println();
        shs.showAarry(arr3);

        sortContext bubs = new sortContext("bubs");
        int[] arr4 = bubs.getAarry(size);
        bubs.showAarry(arr4);
        bubs.getSortArr(arr4);
        System.out.println();
        bubs.showAarry(arr4);

        sortContext qus = new sortContext("qus");
        int[] arr5 = qus.getAarry(size);
        qus.showAarry(arr5);
        qus.getSortArr(arr5);
        System.out.println();
        qus.showAarry(arr5);

        sortContext sels = new sortContext("sels");
        int[] arr6 = sels.getAarry(size);
        sels.showAarry(arr6);
        sels.getSortArr(arr6);
        System.out.println();
        sels.showAarry(arr6);

        sortContext mas = new sortContext("mas");
        int[] arr7 = ins.getAarry(size);
        mas.showAarry(arr7);
        mas.getSortArr(arr7);
        System.out.println();
        mas.showAarry(arr7);

        sortContext ras = new sortContext("ras");
        int[] arr8 = ras.getAarry(size);
        ras.showAarry(arr8);
        ras.getSortArr(arr8);
        System.out.println();
        ras.showAarry(arr8);

        sortContext ads = new sortContext("ads");
        int[] arr9 = ads.getAarry(size);
        ads.showAarry(arr9);
        ads.getSortArr(arr9);
        System.out.println();
        ads.showAarry(arr9);

        sortContext cous = new sortContext("cous");
        int[] arr10 = cous.getAarry(size);
        cous.showAarry(arr10);
        cous.getSortArr(arr10);
        System.out.println();
        cous.showAarry(arr10);
    }
}
