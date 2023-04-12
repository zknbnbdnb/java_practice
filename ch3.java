package code;

import java.util.Scanner;
import java.util.Random;

public class ch3 {
    public static void main(String[] args) {

//        Scanner reader = new Scanner(System.in);
//        int x = 0;
//        while (reader.hasNextInt()){
//            x = reader.nextInt();
//        }
//        switch (x){
//            case 0:
//                System.out.println("A");
//                break;
//            case 1:
//                System.out.println("B");
//            case 2:
//                System.out.println("C");
//                break;
//        }


//        char a = '中';
//        char b = '!';
//        System.out.println("密文：" + (char)(a ^ b));
//        System.out.println("正文：" + (char)(a ^ b ^ b));

        int math = 88;
        if (math >= 90){
            System.out.println("数学成绩优异");
        }
        else if (math >= 80 && math < 90){
            System.out.println("数学成绩优秀");
        }
        else {
            System.out.println("数学成绩一般");
        }

        int sum = 0, i, j;
        int az[] = new int [100];
        for (i = 0; i < 100; i++){
            int randomNumber = (int) Math.round(Math.random()*100);
            az[i] = randomNumber;
        }
        for (int l:az){
            System.out.print(l + " ");
        }
        System.out.println("\n");
        int len = 100;
        while (len > 0) {
            len -= 1;
            int cur = 0;
            while (cur < len) {
                if (az[cur] > az[cur + 1]) {
                    int temp;
                    temp = az[cur];
                    az[cur] = az[cur + 1];
                    az[cur + 1] = temp;
                }
                cur += 1;
            }
        }
        for (int l:az){
            System.out.print(l  + " ");
        }
    }
}
