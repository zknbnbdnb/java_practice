package code;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class daoxie {
    public static void main(String[] args) {
        try {
            File f = new File("D:\sada.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            String str = new String();
            str = new Scanner(System.in).next();
            for(int i = 0; i < str.length(); i++) {
                raf.write(str.charAt(i));
            }
            raf.writeUTF(str);
            int len = str.length();
            while (0 != len--) {
                raf.seek(len);
                char ch = (char) raf.read();
                System.out.print(ch);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
