/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class panel_p1 extends JPanel {

    public UrlMaze urlmaze;
    public int cizimBaslangicX;
    public int cizimBaslangicY;
    public int kutuBoyutu;
    public int cizimMaze[][];
    public int oyunMaze[][];
    public Robotv2 robot;

    enKısaYol kısayol1;
    
    int saniyeSayim;
    int mapGosterS;
    int urlMapSayac;
    
    JLabel zamanVeAdim;
    
    Timer hareketTimer;
    Timer kronometreTimer;
    
    JButton bitirme;
    JButton hareketBaslat;
    JButton mapAcKapa;
    JButton urlDegis;
    public JButton problemDegis1;

    public panel_p1() throws IOException {
        super();
        setLayout(null);
        setVisible(true);
        setSize(1920, 1080);
        mapGosterS = 0;
        this.urlMapSayac = 0;
        URL x = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
        UrlMaze a = new UrlMaze(x);
        if (a.mazeOynanacak.length > a.mazeOynanacak[0].length) {
            kutuBoyutu = 640 / a.mazeOynanacak.length;
        } else {
            kutuBoyutu = 640 / a.mazeOynanacak[0].length;
        }
        this.urlmaze = a;
        this.cizimBaslangicX = 600;
        this.cizimBaslangicY = 100;
        this.cizimMaze = a.MazeOkunan;
        this.oyunMaze = a.mazeOynanacak;
        Robotv2 robot1 = new Robotv2(oyunMaze.length, oyunMaze[0].length, a.baslangicX, a.baslangicY, a.bitisX, a.bitisY);
        this.robot = robot1;
        this.hareketTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!((robot.x == robot.bitis_x && robot.bitis_y == robot.y) || (robot.x-1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x+1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x==robot.bitis_x && robot.y+1==robot.bitis_y)|| (robot.x==robot.bitis_x && robot.y-1==robot.bitis_y))) {
                    robot.hareketEt(oyunMaze);
                    repaint();
                }
                if (((robot.x == robot.bitis_x && robot.bitis_y == robot.y) || (robot.x-1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x+1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x==robot.bitis_x && robot.y+1==robot.bitis_y)|| (robot.x==robot.bitis_x && robot.y-1==robot.bitis_y))) {
                    hareketTimer.stop();
                    hareketBaslat.setEnabled(false);
                    urlDegis.setEnabled(true);
                    bitirme.setEnabled(false);
                    repaint();
                   
                    
                }
                zamanVeAdim.setText("Adım Sayısı = "+Integer.toString(robot.adimSayisi)+" Geçen zaman = "+Integer.toString(saniyeSayim)+" sn");
            }
        });

        JButton hareket = new JButton("Çalıştır");
        hareket.setBounds(100, 100, 150, 50);
        hareket.setVisible(true);
        add(hareket);
        this.hareketBaslat = hareket;
        hareket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kronometreTimer.start();
                hareketTimer.start();
                urlDegis.setEnabled(false);
                hareketBaslat.setEnabled(false);
            }
        });
        JButton bitir = new JButton("Bitir");
        bitir.setBounds(100, 200, 150, 50);
        bitir.setVisible(true);
        add(bitir);
        this.bitirme = bitir;
        bitir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hareketTimer.stop();
                while (!((robot.x == robot.bitis_x && robot.bitis_y == robot.y) || (robot.x-1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x+1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x==robot.bitis_x && robot.y+1==robot.bitis_y)|| (robot.x==robot.bitis_x && robot.y-1==robot.bitis_y))) {
                    robot.hareketEt(oyunMaze);
                }
                repaint();
                
                
                hareketBaslat.setEnabled(false);
                bitirme.setEnabled(false);
                urlDegis.setEnabled(true);
                
                kronometreTimer.stop();
                zamanVeAdim.setText("Adım Sayısı = "+Integer.toString(robot.adimSayisi)+" Geçen zaman = "+Integer.toString(robot.adimSayisi/10)+" sn");
            }
        });
        JButton mapGoster = new JButton("Haritayı Göster");
        mapGoster.setBounds(100, 300, 150, 50);
        mapGoster.setVisible(true);
        add(mapGoster);
        this.mapAcKapa = mapGoster;
        mapGoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mapGosterS == 0) {
                    mapGosterS = 1;
                } else {
                    mapGosterS = 0;
                }
                repaint();
            }
        });
        JButton urlDegistirme = new JButton("URL Değiş");
        urlDegistirme.setVisible(true);
        urlDegistirme.setBounds(100, 400, 150, 50);
        add(urlDegistirme);
        this.urlDegis = urlDegistirme;
        urlDegistirme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (urlMapSayac % 2 == 0) {
                        URL yeniUrl = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt");
                        UrlMaze yeniMaze = new UrlMaze(yeniUrl);
                        if (yeniMaze.mazeOynanacak.length > yeniMaze.mazeOynanacak[0].length) {
                            kutuBoyutu = 640 / yeniMaze.mazeOynanacak.length;
                        } else {
                            kutuBoyutu = 640 / yeniMaze.mazeOynanacak[0].length;
                        }
                        urlmaze = yeniMaze;
                        cizimMaze = urlmaze.MazeOkunan;
                        oyunMaze = urlmaze.mazeOynanacak;
                        Robotv2 robotyeni = new Robotv2(oyunMaze.length, oyunMaze[0].length, urlmaze.baslangicX, urlmaze.baslangicY, urlmaze.bitisX, urlmaze.bitisY);
                        robot = robotyeni;
                        urlMapSayac++;
                        repaint();
                    } else {
                        URL yeniUrl = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
                        UrlMaze yeniMaze = new UrlMaze(yeniUrl);
                        if (yeniMaze.mazeOynanacak.length > yeniMaze.mazeOynanacak[0].length) {
                            kutuBoyutu = 640 / yeniMaze.mazeOynanacak.length;
                        } else {
                            kutuBoyutu = 640 / yeniMaze.mazeOynanacak[0].length;
                        }
                        urlmaze = yeniMaze;
                        cizimMaze = urlmaze.MazeOkunan;
                        oyunMaze = urlmaze.mazeOynanacak;
                        Robotv2 robotyeni = new Robotv2(oyunMaze.length, oyunMaze[0].length, urlmaze.baslangicX, urlmaze.baslangicY, urlmaze.bitisX, urlmaze.bitisY);
                        robot = robotyeni;
                        urlMapSayac++;
                        repaint();
                    }
                    hareketBaslat.setEnabled(true);
                    bitirme.setEnabled(true);
                } catch (Exception ea) {
                }
                zamanVeAdim.setText("Adım Sayısı = 0 Geçen zaman = 0 sn");
                saniyeSayim=0;
            }
        });
        kronometreTimer = new Timer(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saniyeSayim++;
            }
        });
       zamanVeAdim = new JLabel("Adım Sayısı = Geçen süre =");
       zamanVeAdim.setBounds(100,500,250,50);
       zamanVeAdim.setVisible(true);
       
       add(zamanVeAdim);
        
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.orange);
        //kapanacak hepsini çiziyo
//        for (int i = 0; i < cizimMaze.length; i++) {
//            for (int j = 0; j < cizimMaze[0].length; j++) {
//                if (cizimMaze[i][j] == 1) {
//                    g.setColor(Color.BLACK);
//                    g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
//                }
//                if (cizimMaze[i][j] == 2 || cizimMaze[i][j] == 3) {
//                    g.setColor(Color.green);
//                    g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
//                }
//                if (cizimMaze[i][j] == 0) {
//                    g.setColor(Color.WHITE);
//                    g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);
//                }
//
//            }
//
//        }

        g.setColor(Color.gray);
        g.fillRect(cizimBaslangicX - kutuBoyutu, cizimBaslangicY - kutuBoyutu, kutuBoyutu * oyunMaze[0].length, kutuBoyutu * oyunMaze.length);
        for (int i = 0; i < cizimMaze.length; i++) {
            for (int j = 0; j < cizimMaze[0].length; j++) {
                if (robot.gezdigiYerler[i][j] == 4) {
                    if (i != 0) {
                        if (oyunMaze[i - 1][j] == 1) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i - 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            if (cizimMaze[i - 1][j] == 2 || cizimMaze[i - 1][j] == 3) {
                                g.setColor(Color.green);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i - 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            } else {
                                g.setColor(Color.white);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i - 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            }
                        }
                    }
                    if (i != oyunMaze.length - 1) {
                        if (oyunMaze[i + 1][j] == 1) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i + 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            if (cizimMaze[i + 1][j] == 2 || cizimMaze[i + 1][j] == 3) {
                                g.setColor(Color.green);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i + 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            } else {
                                g.setColor(Color.white);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i + 1) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            }
                        }
                    }
                    if (j != 0) {
                        if (oyunMaze[i][j - 1] == 1) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(cizimBaslangicX - kutuBoyutu + ((j - 1) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            if (cizimMaze[i][j - 1] == 2 || cizimMaze[i][j - 1] == 3) {
                                g.setColor(Color.green);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + ((j - 1) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            } else {
                                g.setColor(Color.white);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + ((j - 1) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            }
                        }
                    }
                    if (j != oyunMaze[0].length - 1) {
                        if (oyunMaze[i][j + 1] == 1) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(cizimBaslangicX - kutuBoyutu + ((j + 1) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                        } else {
                            if (cizimMaze[i][j + 1] == 2 || cizimMaze[i][j + 1] == 3) {
                                g.setColor(Color.green);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + ((j + 1) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            } else {
                                g.setColor(Color.white);
                                g.fillRect(cizimBaslangicX - kutuBoyutu + ((j + 1) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                            }
                        }
                    }
                }

            }

        }
        if (((robot.x == robot.bitis_x && robot.bitis_y == robot.y) || (robot.x-1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x+1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x==robot.bitis_x && robot.y+1==robot.bitis_y)|| (robot.x==robot.bitis_x && robot.y-1==robot.bitis_y)) || mapGosterS == 1) {
            for (int i = 0; i < cizimMaze.length; i++) {
                for (int j = 0; j < cizimMaze[0].length; j++) {
                    if (oyunMaze[i][j] == 1) {
                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(cizimBaslangicX - kutuBoyutu + ((j) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                    } else {
                        if (cizimMaze[i][j] == 2 || cizimMaze[i][j] == 3) {
                            g.setColor(Color.GREEN);
                            g.fillRect(cizimBaslangicX - kutuBoyutu + ((j) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                        } else {
                            g.setColor(Color.white);
                            g.fillRect(cizimBaslangicX - kutuBoyutu + ((j) * kutuBoyutu), cizimBaslangicY - kutuBoyutu + ((i) * kutuBoyutu), kutuBoyutu, kutuBoyutu);
                        }
                    }

                }

            }
        }

//        robotun gezdiği yerleri çiziyo
        g.setColor(Color.pink);
        for (int i = 0; i < cizimMaze.length; i++) {
            for (int j = 0; j < cizimMaze[0].length; j++) {
                if (robot.gezdigiYerler[i][j] == 4) {
                    g.fillRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);

                }
            }

        }

        g.setColor(Color.cyan);
        g.fillRect(cizimBaslangicX - kutuBoyutu + (urlmaze.baslangicY * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (urlmaze.baslangicX * kutuBoyutu), kutuBoyutu, kutuBoyutu);
        // bitişi çiziyo
        g.setColor(Color.red);
        g.fillRect(cizimBaslangicX - kutuBoyutu + (urlmaze.bitisY * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (urlmaze.bitisX * kutuBoyutu), kutuBoyutu, kutuBoyutu);

        if (robot.adimlar.size() != 1) {
            for (int i = 0; i < robot.adimlar.size() - 1; i++) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLUE);
                g2.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{8}, 0));
                g2.draw(new Line2D.Float(cizimBaslangicX - (kutuBoyutu / 2) + (robot.adimlar.get(i).y * kutuBoyutu), cizimBaslangicY - (kutuBoyutu / 2) + (robot.adimlar.get(i).x * kutuBoyutu), cizimBaslangicX - (kutuBoyutu / 2) + (robot.adimlar.get(i + 1).y * kutuBoyutu), cizimBaslangicY - (kutuBoyutu / 2) + (robot.adimlar.get(i + 1).x * kutuBoyutu)));

            }
        }

        if (((robot.x == robot.bitis_x && robot.bitis_y == robot.y) || (robot.x-1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x+1==robot.bitis_x && robot.y==robot.bitis_y) || (robot.x==robot.bitis_x && robot.y+1==robot.bitis_y)|| (robot.x==robot.bitis_x && robot.y-1==robot.bitis_y))) {
            enKısaYol kısayol = new enKısaYol(urlmaze.baslangicX, urlmaze.baslangicY, urlmaze.bitisX, urlmaze.bitisY, robot.gezdigiYerler, oyunMaze);
            this.kısayol1=kısayol;
            txtYazdir("x");
            for (int i = 0; i < kısayol.dogruYol.size() - 1; i++) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.red);
                g2.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{8}, 0));
                g2.draw(new Line2D.Float(cizimBaslangicX - (kutuBoyutu / 2) + (kısayol.dogruYol.get(i).y * kutuBoyutu), cizimBaslangicY - (kutuBoyutu / 2) + (kısayol.dogruYol.get(i).x * kutuBoyutu), cizimBaslangicX - (kutuBoyutu / 2) + (kısayol.dogruYol.get(i + 1).y * kutuBoyutu), cizimBaslangicY - (kutuBoyutu / 2) + (kısayol.dogruYol.get(i + 1).x * kutuBoyutu)));

            }

        }

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));

        // grid çiziyo düz siyah kareler
        g.setColor(Color.BLACK);
        for (int i = 0; i < cizimMaze.length; i++) {
            for (int j = 0; j < cizimMaze[0].length; j++) {
                g.drawRect(cizimBaslangicX - kutuBoyutu + (j * kutuBoyutu), cizimBaslangicY - kutuBoyutu + (i * kutuBoyutu), kutuBoyutu, kutuBoyutu);

            }

        }

    }
    
    private  void txtYazdir(String data) {
        File file = new File("log.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,true);
            data = "Robotun gezdiği yerler\n";
            fr.write(data);
            data = "X\t-\tY\n";
            fr.write(data);
            for (int i = 0; i < robot.adimlar.size(); i++) {
                int x=robot.adimlar.get(i).x;
                int y=robot.adimlar.get(i).y;
                String yazilacak=x+"\t-\t"+y+"\n";
                fr.write(yazilacak);
                
            }
            data="------------------\n";
            fr.write(data);
            data="En Kısa Yol\n"+"X\t-\tY\n";
            fr.write(data);
            for (int i = 0; i < kısayol1.dogruYol.size(); i++) {
                int x=kısayol1.dogruYol.get(i).x;
                int y=kısayol1.dogruYol.get(i).y;
                String yazilacak=x+"\t-\t"+y+"\n";
                fr.write(yazilacak);
                
            }
            data="------------------\n";
            fr.write(data);
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
