package code;


import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

class windows extends JFrame implements Runnable, ActionListener {
    selltick tick;
    Thread zhang, li, zhao;
    static JTextArea txt;
    JButton buy = new JButton("buy");
    windows() {
        tick = new selltick();
        zhang = new Thread(this);
        zhang.setName("张平");
        li = new Thread(this);
        li.setName("李明");
        zhao = new Thread(this);
        zhao.setName("赵志蛋");
        txt = new JTextArea(10 ,30);
        buy.addActionListener(this);
        add(txt, BorderLayout.CENTER);
        add(buy, BorderLayout.NORTH);
        setVisible(true);
        setSize(360, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            zhang.start();
            li.start();
            zhao.start();
        }catch (Exception ex) {}
    }
    public void run() {
        if (Thread.currentThread() == zhang) {
            tick.rule(20);
        }else if(Thread.currentThread() == li) {
            tick.rule(10);
        }else if(Thread.currentThread() == zhao) {
            tick.rule(5);
        }
    }
}

class selltick {
    int count_5 = 3;
    int count_10 = 0;
    int count_20 = 0;
    String s = null;
    public synchronized void rule(int money) {
        String name = Thread.currentThread().getName();
        if (money == 5) {
            count_5++;
            s = "给" + name + "入场费," + name + "的钱正好";
            windows.txt.append("\n" + s);
        }else if (money == 10) {
            while (count_5 < 1) {
                try {
                    windows.txt.append("\n" + name + "靠边等o_o ....");
                    wait();
                }catch (InterruptedException e){

                }
            }
            count_5 --;
            count_10 ++;
            s = "给" + name + "入场费," + name + "给10，赎5元";
            windows.txt.append("\n" + s);
        }else if (money == 20) {
            while (((count_10 < 1) && (count_5 < 1)) || (count_5 < 3)) {
                try {
                    windows.txt.append("\n" + name + "靠边等o_o ....");
                    wait();
                }catch (InterruptedException e){

                }
            }
            if ((count_10 >= 1) && (count_5 >= 1)){
                count_10--;
                count_5--;
                count_20++;
                s = "给" + name + "入场费," + name + "给20，赎15元";
            }else if (count_5 >= 3) {
                count_5 -= 3;
                count_20++;
                s = "给" + name + "入场费," + name + "给20，赎15元";
            }
            windows.txt.append("\n" + s);
        }
        notifyAll();
    }
}


public class xiancheng {
    public static void main(String[] args){
        windows win = new windows();
        win.setTitle("买票");
    }
}
