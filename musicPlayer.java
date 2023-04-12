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
        // ��ť
        bPlay = new JButton("����");
        bExit = new JButton("�˳�");

        // �ı���
        textArea = new JTextArea("���ڵ������");
        textArea.setEditable(false);

        // ��ѡ��
        meanBar = new JMenuBar();
        menu = new JMenu("�ļ���");
        menu.setMnemonic('F');

        menuItem1 = new JMenuItem("��");
        menuItem2 = new JMenuItem("�ر�");

        menuItem1.setMnemonic('O');
        menuItem2.setMnemonic('E');

        // ������
        panel = new JPanel();
        panel.add(bPlay);
        panel.add(bExit);

        meanBar.add(menu);
        menu.add(menuItem1);
        menu.add(menuItem2);

        // ��ť�¼�����
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

        // ͼ��
        this.setIconImage(new ImageIcon("C:\\Users\\zk1307403902\\Music\\SongImages\\���� - �ܽ���.jpg").getImage());
        // Ӧ������
        setTitle("���ֲ�����");
        // ��С
        this.setSize(1000, 700);
        // ���ֵ�λ��
        this.setLocation(500, 500);
        // �Ƿ���Ե��ڴ�С
        this.setResizable(true);
        // �������
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    // �ļ�����
    public void actionPerformed(ActionEvent event) {
        String text = "";
        wav player = new wav();
        player.setPath(filePath);
        // �����ж�
        if (event.getActionCommand().equals("open")) {
            // ѡ������
            FileDialog fD = new FileDialog(this, "ѡ������", FileDialog.LOAD);
            fD.setVisible(true);
            filePath = fD.getDirectory() + fD.getFile();

            if (filePath != null) {
                System.out.println(text = "�ļ�·��Ϊ" + filePath);
            }else {
                System.out.println("�޷����ļ�");
            }
        }else if (event.getActionCommand().equals("exit")) {
            player.interrupt();
            System.out.println(text = "�˳�����");
            System.exit(0);
        }else if (event.getActionCommand().equals("play")) {
            if (filePath != null) {
                player.start();
                System.out.println(text = "��������" + filePath);
            }else {
                System.out.println(text = "û������ļ�");
            }
        }
        this.textArea.setText(text);
    }
}

//wavʵ������������
//�߳����к�����д

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




