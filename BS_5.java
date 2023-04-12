package code;

public class BS_5 {
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
    public int[] bubbleSort() {
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

    public int [] selectSort() {
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
