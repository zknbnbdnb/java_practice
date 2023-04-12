package code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;

public class musicPlayer extends JFrame implements ActionListener {
    static String filePath = null;
    JButton bPause, bExit, bStop, bPlay, bLoop;
    JPanel panel;
    JTextArea textArea;
    JMenuBar meanBar;
    JMenu menu;
    JMenuItem menuItem1, menuItem2;
    public static void main(String[] args) {
        musicPlayer mP  = new musicPlayer();
    }

    public musicPlayer() {
        // 按钮
        bPlay = new JButton("播放");
        bExit = new JButton("退出");

        // 文本域
        textArea = new JTextArea("正在导入歌曲");
        textArea.setEditable(false);

        // 多选栏
        meanBar = new JMenuBar();
        menu = new JMenu("文件夹");
        menu.setMnemonic('F');

        menuItem1 = new JMenuItem("打开");
        menuItem2 = new JMenuItem("关闭");

        menuItem1.setMnemonic('O');
        menuItem2.setMnemonic('E');

        // 添加组件
        panel = new JPanel();
        panel.add(bPlay);
        panel.add(bExit);

        meanBar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);

        // 按钮事件监听
        bPlay.addActionListener(this);
        bPlay.setActionCommand("play");
        bExit.addActionListener(this);
        bExit.setActionCommand("exit");
        menuItem1.addActionListener(this);
        menuItem1.setActionCommand("open");
        menuItem2.addActionListener(this);
        menuItem2.setActionCommand("exit");

        this.setJMenuBar(meanBar);
        this.add(textArea);
        this.add(panel, BorderLayout.SOUTH);

        // 图标
        this.setIconImage(new ImageIcon("C:\\Users\\zk1307403902\\Music\\SongImages\\晴天 - 周杰伦.jpg").getImage());
        // 应用名称
        setTitle("音乐播放器");
        // 大小
        this.setSize(1000, 700);
        // 出现的位置
        this.setLocation(500, 500);
        // 是否可以调节大小
        this.setResizable(true);
        // 经典操作
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    // 文件载体
    public void actionPerformed(ActionEvent event) {
        String text = "";
        wav player = new wav();
        player.setPath(filePath);
        // 监听行动
        if (event.getActionCommand().equals("open")) {
            // 选择音乐
            FileDialog fD = new FileDialog(this, "选择音乐", FileDialog.LOAD);
            fD.setVisible(true);
            filePath = fD.getDirectory() + fD.getFile();

            if (filePath != null) {
                System.out.println(text = "文件路径为" + filePath);
            }else {
                System.out.println("无法打开文件");
            }
        }else if (event.getActionCommand().equals("exit")) {
            player.interrupt();
            System.out.println(text = "退出程序");
            System.exit(0);
        }else if (event.getActionCommand().equals("play")) {
            if (filePath != null) {
                player.start();
                System.out.println(text = "播放音乐" + filePath);
            }else {
                System.out.println(text = "没有这个文件");
            }
        }
        this.textArea.setText(text);
    }
}

//wav实现声音流播放
//线程运行函数重写

class wav extends Thread
{
    AudioFormat format = null;
    AudioInputStream aistream = null;
    DataLine.Info datalineinfo = null;
    SourceDataLine dataline = null;
    boolean pause;
    boolean stop;
    int played = 0;
    int play_from = 0;
    boolean pass = false;
    boolean playing;
    String path = new String();
    public wav() {
    }
    public void setPath(String p) {
        path = p;
    }
    public void run()
    {
        try {
            aistream = AudioSystem.getAudioInputStream(new File(path));
            format = aistream.getFormat();
            datalineinfo = new DataLine.Info(SourceDataLine.class, format);
            dataline = (SourceDataLine)AudioSystem.getLine(datalineinfo);
        } catch(LineUnavailableException e) {
            System.out.println("LineUnavailableException");
        } catch(UnsupportedAudioFileException e) {
            System.out.println("UnsupportedAudioFileException");
        } catch(IOException e) {
            System.out.println("IOException");
        }
        try {
            byte[] bytes = new byte[512];
            int length = 0;
            dataline.open(format);
            dataline.start();
            while(stop == false) {
                if(pause == true) {
                    Thread.sleep(1500);
                    continue;
                }
                if(pass == true) {
                    if((length = aistream.read(bytes))<=0) {
                        break;
                    }
                    played+=1;
                    continue;
                }
                if(played<play_from) {
                    if((length=aistream.read(bytes))>0) {
                        played+=1;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                if((length=aistream.read(bytes))>0) {
                    dataline.write(bytes, 0, length);
                    played+=1;
                }
                else {
                    break;
                }
            }
            stop = true;
            aistream.close();
            dataline.drain();
            dataline.close();

            aistream = null;
            format = null;
            datalineinfo = null;
            dataline = null;
        }
        catch(Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        } catch(Error e) {
            System.out.println("Error: can not play the audio");
            e.printStackTrace();
        }
    }
}




