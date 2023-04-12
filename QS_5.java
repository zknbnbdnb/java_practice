package code;

public class QS_5 {
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

    public int[] quickSort() {
        int low = 0;
        int high = mylist.length - 1;
        mylist = qs(mylist, low, high);
        return mylist;
    }

    public int[] shellSort() {
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
