package code;

import java.util.Scanner;

public class ch2 {
    public static void main(String[] args) {
        System.out.println("用回车做分割， 输入若干结果，最后@结束，\n然后回车结束");
        Scanner reader = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        while (reader.hasNextDouble()){
            double x = reader.nextDouble();
            m += 1;
            sum += x;
        }
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均数为" + sum / m);
    }
}
