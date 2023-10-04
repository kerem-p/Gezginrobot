/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab_2_p1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kerem
 */
public class Robot {

    int x, y;
    int bitis_x, bitis_y;
    int adimSayisi;

    int gezdigiYerler[][];
    int gidilmeyecekYerler[][];
    ArrayList<String> yonler = new ArrayList<String>();
    ArrayList<Konum> adimlar = new ArrayList<Konum>();

    Robot(int boyut,int genislik) {
        this.gezdigiYerler = new int[boyut][genislik];
        this.gidilmeyecekYerler = new int[boyut][genislik];
        x = 0;
        y = 0;
        bitis_x = boyut - 1;
        bitis_y = genislik - 1;
        gezdigiYerler[0][0] = 4;
        Konum baslangic = new Konum();
        baslangic.x = 0;
        baslangic.y = 0;
        adimlar.add(baslangic);
//        Konum baslangic2 = new Konum();
//        baslangic2.x = 0;
//        baslangic2.y = 0;
//        adimlar.add(baslangic2);
//        
    }

    public void hareketEt(int maze[][]) {

        if (x == bitis_x && bitis_y == y) {
            System.out.println("bitiş");
        } else {
            if (x != 0) {
                if (maze[x - 1][y] != 1 && gidilmeyecekYerler[x - 1][y] != 1 && gezdigiYerler[x - 1][y] != 4) {
                    String yon = "Yukari";
                    yonler.add(yon);
                }
            }
            if (x != maze.length - 1) {
                if (maze[x + 1][y] != 1 && gidilmeyecekYerler[x + 1][y] != 1 && gezdigiYerler[x + 1][y] != 4) {
                    String yon = "Asagi";
                    yonler.add(yon);
                }
            }
            if (y != 0) {
                if (maze[x][y - 1] != 1 && gidilmeyecekYerler[x][y - 1] != 1 && gezdigiYerler[x][y - 1] != 4) {
                    String yon = "Sol";
                    yonler.add(yon);
                }
            }
            if (y != maze[0].length - 1) {
                if (maze[x][y + 1] != 1 && gidilmeyecekYerler[x][y + 1] != 1 && gezdigiYerler[x][y + 1] != 4) {
                    String yon = "Sag";
                    yonler.add(yon);
                }
            }
            if (yonler.size() == 0) {
                this.x = adimlar.get(adimlar.size() - 2).x;
                this.y = adimlar.get(adimlar.size() - 2).y;
                adimlar.remove(adimlar.size()-1);
                adimSayisi++;
          //      System.out.println("Geri döndü");
            } else {
                if (yonler.size() != 1) {
                    Collections.shuffle(yonler);
                    Collections.shuffle(yonler);
                }
               // System.out.println(yonler.get(0));
                if (yonler.get(0).equals("Asagi")) {
                    x += 1;
                    gezdigiYerler[x][y] = 4;
                    Konum yeniAdim = new Konum();
                    yeniAdim.x=x;
                    yeniAdim.y=y;
                    adimlar.add(yeniAdim);
                    adimSayisi++;
                }
                else if (yonler.get(0).equals("Yukari")) {
                    x -= 1;
                    gezdigiYerler[x][y] = 4;
                    Konum yeniAdim = new Konum();
                    yeniAdim.x=x;
                    yeniAdim.y=y;
                    adimlar.add(yeniAdim);
                    adimSayisi++;
                }
                else if (yonler.get(0).equals("Sag")) {
                    y += 1;
                    gezdigiYerler[x][y] = 4;
                    Konum yeniAdim = new Konum();
                    yeniAdim.x=x;
                    yeniAdim.y=y;
                    adimlar.add(yeniAdim);
                    adimSayisi++;
                }
                else if (yonler.get(0).equals("Sol")) {
                    y -= 1;
                    gezdigiYerler[x][y] = 4;
                    Konum yeniAdim = new Konum();
                    yeniAdim.x=x;
                    yeniAdim.y=y;
                    adimlar.add(yeniAdim);
                    adimSayisi++;
                }
            }

            yonler.clear();
        }
    }
}
