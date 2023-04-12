package code;
class creatArr {
    int arr[][];
    public int[][] craArr(int size){
        arr = new int[size][];
        for(int i = 0; i < size; i++){
            arr[i] = new int[i + 1];
            arr[i][0] = 1;
            arr[i][i] = 1;
            for (int j = 1; j < i; j++){
                if (i > 1) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        return arr;
    }

    public void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
public class lianxi6_2 {
    public static void main(String[] args) {
        int size = 10;
        creatArr ca = new creatArr();
        int arr[][];
        arr = ca.craArr(size);
        ca.printArr(arr);
    }

}
