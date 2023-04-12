package code;

import java.util.Arrays;

public class CR_5 {
    private int[] mylist;

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

    public int[] countSort() {
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

    public int[] radixSort() {
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
