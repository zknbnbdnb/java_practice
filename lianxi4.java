package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

interface Sort {
    public int[] aSort();
    public void aShow();
}



class iS{
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class bS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class sS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class buS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class qS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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
            while ((low < high) && mylist[high] > pivot) {
                high -= 1;
            }
            mylist[low] = mylist[high];
            while ((low < high) && mylist[low] < pivot) {
                low += 1;
            }
            mylist[high] = mylist[low];
        }
        mylist[high] = pivot;
        qs(mylist, i, low - 1);
        qs(mylist, low + 1, j);
        return mylist;
    }

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class seS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class mS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
        if (mylist.length <= 1) {
            return mylist;
        }
        int mid = mylist.length / 2;
        int[] left = aSort(Arrays.copyOfRange(mylist, 0, mid));
        int[] right = aSort(Arrays.copyOfRange(mylist, mid, mylist.length));
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class aS {
    class data {

        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class rS {
    class data {

        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

class cS {
    class data {
        int arr[];
        public int[] createArray(int size) {
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

    Sort sort;

    public int[] aSort(int[] mylist) {
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

    public void aShow(int[] mylist) {
        int n = mylist.length;
        for(int i = 0; i < n; i++){
            System.out.printf("%5d", mylist[i]);
            if((i + 1) % 20 == 0)
                System.out.println();
        }
    }
}

public class lianxi4 {
    public static void main(String[] args) {
        int n = 1000;

        cS cs = new cS();
        cS.data csd = new cS().new data();
        cs.aShow(csd.createArray(n));
        System.out.println();
        cs.aShow(cs.aSort(csd.createArray(n)));

        iS is = new iS();
        iS.data isd = new iS().new data();
        is.aShow(isd.createArray(n));
        System.out.println();
        is.aShow(is.aSort(isd.createArray(n)));

        bS bs = new bS();
        bS.data bsd = new bS().new data();
        bs.aShow(bsd.createArray(n));
        System.out.println();
        bs.aShow(bs.aSort(bsd.createArray(n)));

        sS ss = new sS();
        sS.data ssd = new sS().new data();
        ss.aShow(ssd.createArray(n));
        System.out.println();
        ss.aShow(ss.aSort(ssd.createArray(n)));

        buS bus = new buS();
        buS.data busd = new buS().new data();
        bus.aShow(busd.createArray(n));
        System.out.println();
        bus.aShow(bus.aSort(busd.createArray(n)));

        qS qs = new qS();
        qS.data qsd = new qS().new data();
        qs.aShow(qsd.createArray(n));
        System.out.println();
        qs.aShow(qs.aSort(qsd.createArray(n)));

        seS ses = new seS();
        seS.data sesd = new seS().new data();
        ses.aShow(sesd.createArray(n));
        System.out.println();
        ses.aShow(ses.aSort(sesd.createArray(n)));

        aS as = new aS();
        aS.data asd = new aS().new data();
        as.aShow(asd.createArray(n));
        System.out.println();
        as.aShow(as.aSort(asd.createArray(n)));

        mS ms = new mS();
        mS.data msd = new mS().new data();
        ms.aShow(msd.createArray(n));
        System.out.println();
        ms.aShow(ms.aSort(msd.createArray(n)));

        rS rs = new rS();
        rS.data rsd = new rS().new data();
        rs.aShow(rsd.createArray(n));
        System.out.println();
        rs.aShow(rs.aSort(rsd.createArray(n)));
    }
}
