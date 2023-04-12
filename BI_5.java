package code;

public class BI_5 {
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

    public int[] binInsertSort() {
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

    public int[] insertSort() {
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
