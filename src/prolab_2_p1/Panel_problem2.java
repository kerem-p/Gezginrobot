/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab_2_p1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author kerem
 */
public class Panel_problem2 extends JPanel implements ActionListener {

    int kutuBoyutu;
    int mazeBaslangicX;
    int mazeBaslangicY;
    int maze[][];
    Robot gezginRobot;

    JButton hareket;
    JButton otoHareket;
    JButton mapDegis;
    JButton bitir;
    JButton popButon;
    public JButton problemDegis2;
    
    JPopupMenu pop;
    
    
    JLabel zamanLabel;
    JLabel adimLabel;

    int saniye;
    int adimEkranaYazSayim;
    Timer süre;
    Timer zamanlayici;
    int Boyut;

    private Image background;

    public Panel_problem2(Labirent x) {
        super();

//        try {
//            background = ImageIO.read(new File("C:\\Users\\kerem\\Documents\\NetBeansProjects\\Prolab_2_p1\\src\\res\\lab2.jpg"));
//
//        } catch (Exception e) {
//        }
        setSize(1920, 1080);
        setVisible(true);
        saniye = 0;
        Boyut = x.maze.length;
        kutuBoyutu = 640 / x.maze.length;
        if (x.maze.length < x.maze[0].length) {
            kutuBoyutu = 640 / x.maze[0].length;
        }
        mazeBaslangicX = 450;
        mazeBaslangicY = 50;
        adimEkranaYazSayim = 0;
        this.maze = x.maze;
        gezginRobot = new Robot(x.maze.length, x.maze[0].length);
        JLabel zamanGosterge = new JLabel();
        this.zamanLabel = zamanGosterge;
        zamanGosterge.setBounds(800, 700, 200, 100);
        zamanGosterge.setVisible(true);
        add(zamanLabel);
        zamanGosterge.setText("Geçen Süre = 0 sn");

        JLabel adimSayar = new JLabel();
        this.adimLabel = adimSayar;
        adimSayar.setBounds(500, 700, 200, 100);
        adimSayar.setVisible(true);
        add(adimSayar);

        adimSayar.setText("Adım Sayısı = " + Integer.toString(adimEkranaYazSayim));
        süre = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saniye++;
                String a = Integer.toString(saniye);
                zamanLabel.setText("Geçen Süre " + a + " sn");

            }
        });
        JButton hareketButonu = new JButton("Hareket");
        hareket = hareketButonu;
        this.setLayout(null);
        hareketButonu.setBounds(200, 50, 100, 50);
        hareketButonu.setVisible(true);
        add(hareketButonu);
        hareketButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gezginRobot.hareketEt(maze);
                if (gezginRobot.x == gezginRobot.bitis_x && gezginRobot.y == gezginRobot.bitis_y) {
                    hareket.setEnabled(false);
                }
                adimEkranaYazSayim++;
                adimLabel.setText("Adım Sayısı = " + Integer.toString(adimEkranaYazSayim));
                repaint();
            }
        });

        Timer zaman = new Timer(80, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gezginRobot.hareketEt(maze);
                repaint();
                // System.out.println("--" + gezginRobot.adimSayisi);
                if (gezginRobot.x == gezginRobot.bitis_x && gezginRobot.y == gezginRobot.bitis_y) {
                    zamanlayici.stop();
                    süre.stop();
                    mapDegis.setEnabled(true);
                    bitir.setEnabled(false);
                    popButon.setEnabled(true);
                    repaint();

                }
                adimEkranaYazSayim++;
                adimLabel.setText("Adım Sayısı = " + Integer.toString(adimEkranaYazSayim));

            }
        });
        zamanlayici = zaman;

        JButton otoHareketButonu = new JButton("OtoHareket");
        otoHareket = otoHareketButonu;
        otoHareketButonu.setBounds(200, 150, 100, 50);
        otoHareketButonu.setVisible(true);
        add(otoHareketButonu);
        otoHareketButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hareket.setEnabled(false);
                otoHareketButonu.setEnabled(false);
                mapDegis.setEnabled(false);
                popButon.setEnabled(false);
                zamanlayici.start();
                repaint();
                süre.start();
            }
        });

        JButton mapDegis = new JButton("MapDegis");
        this.mapDegis = mapDegis;
        mapDegis.setBounds(1200, 250, 150, 50);
        mapDegis.setVisible(true);
        add(mapDegis);
        mapDegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zamanlayici.stop();
                
                Labirent yeni = new Labirent(maze.length, maze[0].length);
                maze = yeni.maze;
                Robot yenirobot = new Robot(maze.length, maze[0].length);
                if(maze.length>maze[0].length){
                    kutuBoyutu = 640/maze.length;
                }
                else{
                    kutuBoyutu = 640/maze[0].length;
                }
                gezginRobot = yenirobot;
                repaint();
                otoHareketButonu.setEnabled(true);
                hareketButonu.setEnabled(true);
                bitir.setEnabled(true);
                saniye = 0;
                String a = Integer.toString(saniye);
                zamanLabel.setText("Geçen süre = " + a + " sn");
                adimEkranaYazSayim = 0;
                String b = Integer.toString(adimEkranaYazSayim);
                adimLabel.setText("Adım Sayısı = " + b);
            }
        });

        JButton bitirme = new JButton("Bitir");
        bitir = bitirme;
        bitir.setBounds(200, 250, 100, 50);
        bitir.setVisible(true);
        add(bitir);
        bitirme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zamanlayici.stop();
                while (!(gezginRobot.x == gezginRobot.bitis_x && gezginRobot.y == gezginRobot.bitis_y)) {
                    gezginRobot.hareketEt(maze);
                }
                otoHareket.setEnabled(false);
                hareket.setEnabled(false);
                mapDegis.setEnabled(true);
                popButon.setEnabled(true);
                bitir.setEnabled(false);
                repaint();
                //  System.out.println("Adim = " + gezginRobot.adimSayisi);
                süre.stop();
                saniye = 0;
                adimLabel.setText("Adım sayısı = " + Integer.toString(gezginRobot.adimSayisi));
                zamanGosterge.setText("Geçen süre = " + Integer.toString(gezginRobot.adimSayisi * 80 / 1000) + "sn");
            }
        });

        JButton ok = new JButton("->");
        ok.setBounds(1300, 100, 50, 40);
        ok.setVisible(false);
        add(ok);
               JTextField text = new JTextField("X");
        text.setBounds(1200, 100, 40, 40);
        text.setVisible(false);
        JTextField text2 = new JTextField("Y");
        text2.setBounds(1250, 100, 40, 40);
        text2.setVisible(false);
        add(text);
        add(text2);
        JPopupMenu popUp = new JPopupMenu();
        pop = popUp;
        add(pop);
        JMenuItem p1 = new JMenuItem("100x100");
        JMenuItem p2 = new JMenuItem("80x80");
        JMenuItem p3 = new JMenuItem("50x75");
        JMenuItem p4 = new JMenuItem("Değer gir");
        pop.add(p1);
        pop.add(p2);
        pop.add(p3);
        pop.add(p4);
        JButton popButon = new JButton("Boyut Değiştir");
        this.popButon = popButon;
        popButon.setBounds(1200, 50, 150, 50);
        popButon.setVisible(true);
        add(popButon);
        popButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop.show(popButon, 20, 20);
            p1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zamanlayici.stop();
                    kutuBoyutu = 640/101;
                    Labirent yeni = new Labirent(101, 101);
                    maze = yeni.maze;
                    Robot yenirobot = new Robot(101, 101);
                    gezginRobot = yenirobot;
                    repaint();
                    otoHareketButonu.setEnabled(true);
                    hareketButonu.setEnabled(true);
                    bitir.setEnabled(true);
                    saniye = 0;
                    String a = Integer.toString(saniye);
                    zamanLabel.setText("Geçen süre = " + a + " sn");
                    adimEkranaYazSayim = 0;
                    String b = Integer.toString(adimEkranaYazSayim);
                    adimLabel.setText("Adım Sayısı = " + b);
                    kutuBoyutu = 640 / 101;
                }
            });
            p2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zamanlayici.stop();
                    Labirent yeni = new Labirent(81, 81);
                    maze = yeni.maze;
                    kutuBoyutu = 640/81;
                    Robot yenirobot = new Robot(81, 81);
                    gezginRobot = yenirobot;
                    repaint();
                    otoHareketButonu.setEnabled(true);
                    hareketButonu.setEnabled(true);
                    bitir.setEnabled(true);
                    saniye = 0;
                    String a = Integer.toString(saniye);
                    zamanLabel.setText("Geçen süre = " + a + " sn");
                    adimEkranaYazSayim = 0;
                    String b = Integer.toString(adimEkranaYazSayim);
                    adimLabel.setText("Adım Sayısı = " + b);
                    kutuBoyutu = 640 / 81;
                }
            }
            );
            p3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zamanlayici.stop();
                    Labirent yeni = new Labirent(51, 75);
                    maze = yeni.maze;
                    kutuBoyutu = 640/75;
                    Robot yenirobot = new Robot(51, 75);
                    gezginRobot = yenirobot;
                    repaint();
                    otoHareketButonu.setEnabled(true);
                    hareketButonu.setEnabled(true);
                    bitir.setEnabled(true);
                    saniye = 0;
                    String a = Integer.toString(saniye);
                    zamanLabel.setText("Geçen süre = " + a + " sn");
                    adimEkranaYazSayim = 0;
                    String b = Integer.toString(adimEkranaYazSayim);
                    adimLabel.setText("Adım Sayısı = " + b);
                    kutuBoyutu = 640 / 75;
                }
            }
            );
            p4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setVisible(true);
                    text2.setVisible(true);
                    ok.setVisible(true);
                }
            });
            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int satir = Integer.parseInt(text.getText());
                    if (satir % 2 == 0) {
                        satir++;
                    }
                    int sütun = Integer.parseInt(text2.getText());
                    if (sütun % 2 == 0) {
                        sütun++;
                    }
                    if(satir>sütun){
                    kutuBoyutu = 640 / satir;
                    }
                    else{kutuBoyutu = 640 / sütun;}
                    zamanlayici.stop();
                    Labirent yeni = new Labirent(satir, sütun);
                    maze = yeni.maze;
                    Robot yenirobot = new Robot(satir, sütun);
                    gezginRobot = yenirobot;
                    repaint();
                    otoHareketButonu.setEnabled(true);
                    hareketButonu.setEnabled(true);
                    bitir.setEnabled(true);
                    saniye = 0;
                    String a = Integer.toString(saniye);
                    zamanLabel.setText("Geçen süre = " + a + " sn");
                    adimEkranaYazSayim = 0;
                    String b = Integer.toString(adimEkranaYazSayim);
                    adimLabel.setText("Adım Sayısı = " + b);
                }
            });
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//               g.drawImage(background, 0, 0, null);
        g.setColor(Color.ORANGE);
        g.fillRect(mazeBaslangicX, mazeBaslangicY, kutuBoyutu * maze[0].length, kutuBoyutu * maze.length);
        g.setColor(Color.gray);
        g.fillRect(mazeBaslangicX - kutuBoyutu, mazeBaslangicY - kutuBoyutu, kutuBoyutu * (maze[0].length + 1), kutuBoyutu * (maze.length + 1));
        setBackground(Color.ORANGE);
        g.setColor(Color.BLACK);
        g.fillRect(mazeBaslangicX - kutuBoyutu, mazeBaslangicY - kutuBoyutu, kutuBoyutu * (maze[0].length + 2), kutuBoyutu);
        g.fillRect(mazeBaslangicX - kutuBoyutu, mazeBaslangicY + kutuBoyutu, kutuBoyutu, kutuBoyutu * (maze.length));
        g.fillRect(mazeBaslangicX - kutuBoyutu, mazeBaslangicY + (kutuBoyutu * (maze.length)), kutuBoyutu * (maze[0].length + 2), kutuBoyutu);
        g.fillRect(mazeBaslangicX - kutuBoyutu + kutuBoyutu * (maze[0].length + 1), mazeBaslangicY - kutuBoyutu, kutuBoyutu, kutuBoyutu * maze.length);
        g.setColor(Color.GREEN);
        g.fillRect(mazeBaslangicX - kutuBoyutu, mazeBaslangicY, kutuBoyutu, kutuBoyutu);
        g.setColor(Color.red);
        g.fillRect(mazeBaslangicX + (kutuBoyutu * maze[0].length), mazeBaslangicY - kutuBoyutu + (kutuBoyutu * maze.length), kutuBoyutu, kutuBoyutu);
        g.setColor(Color.BLACK);
        for (int i = 0; i < gezginRobot.gezdigiYerler.length; i++) {
            for (int j = 0; j < gezginRobot.gezdigiYerler[0].length; j++) {
                if (gezginRobot.gezdigiYerler[i][j] == 4) {
                    if (i != 0) {
                        if (maze[i - 1][j] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + ((i - 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            g.setColor(Color.WHITE);
                            g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + ((i - 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                        }
                    }
                    if (i != maze.length - 1) {
                        if (maze[i + 1][j] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + ((i + 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            g.setColor(Color.WHITE);
                            g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + ((i + 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        }
                    }
                    if (j != maze[0].length - 1) {
                        if (maze[i][j + 1] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(mazeBaslangicX + ((j + 1) * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            g.setColor(Color.WHITE);
                            g.fillRect(mazeBaslangicX + ((j + 1) * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                        }
                    }
                    if (j != 0) {
                        if (maze[i][j - 1] == 1) {
                            g.setColor(Color.BLACK);
                            g.fillRect(mazeBaslangicX + ((j - 1) * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            g.setColor(Color.white);
                            g.fillRect(mazeBaslangicX + ((j - 1) * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                        }
                    }

                }

            }

        }

        if (gezginRobot.bitis_x == gezginRobot.x && gezginRobot.bitis_y == gezginRobot.y) {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if (maze[i][j] == 0) {
                        g.setColor(Color.WHITE);
                        g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);

//                 Graphics2D g2d = (Graphics2D)g;
//                 Stroke dashed = new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0);
//                 g2d.setStroke(dashed);
                        //               g.drawRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                    } else {
                        g.setColor(Color.BLACK);
                        g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                    }

                }

            }
        }
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[0].length; j++) {
//                if (i == 0 || i == maze.length - 1 || j==0 || j==maze[0].length) {
//                    g.setColor(Color.BLACK);
//                    g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
//
//                }
//
//            }
//
//        }

        g.setColor(Color.BLACK);
        if (true) {
            g.setColor(Color.cyan);
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if (gezginRobot.gezdigiYerler[i][j] == 4) {
                        g.fillRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                    }

                }

            }
        }
        g.setColor(Color.BLUE);
        g.fillRect(mazeBaslangicX + (gezginRobot.y * kutuBoyutu), mazeBaslangicY + (gezginRobot.x * kutuBoyutu), kutuBoyutu, kutuBoyutu);
        if (gezginRobot.x == gezginRobot.bitis_x && gezginRobot.y == gezginRobot.bitis_y) {
            g.setColor(Color.RED);
            for (int i = 0; i < gezginRobot.adimlar.size(); i++) {
                g.fillRect(mazeBaslangicX + (gezginRobot.adimlar.get(i).y * kutuBoyutu), mazeBaslangicY + (gezginRobot.adimlar.get(i).x * kutuBoyutu), kutuBoyutu, kutuBoyutu);

            }
        }
        g.setColor(Color.BLACK);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                g.drawRect(mazeBaslangicX + (j * kutuBoyutu), mazeBaslangicY + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);

            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
