/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab_2_p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author kerem
 */
public class Labirent {

    int Boyut;
    int genislik;
    int anlikX;
    int anlikY;

    int maze[][];
//    int baslangicX;
//    int baslangicY;

    ArrayList<Konum> konumlar = new ArrayList<Konum>();
    ArrayList<String> yonler = new ArrayList<String>();

    public Labirent(int boyut,int genislik) {
        this.genislik=genislik;
        maze = new int[boyut][genislik];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = 1;

            }

        }
//        maze[6][8]=0;
//        maze[6][4]=0;
//        maze[4][6]=0;
//        maze[8][6]=0;
//        baslangicX = 0;
//        baslangicY = 0;
        anlikX = 0;
        anlikY = 0;
        Konum baslangic = new Konum();
        baslangic.x = 0;
        baslangic.y = 0;
//        baslangic.x = 14;
//        baslangic.y = 14;
//        maze[0][1]=0;
        konumlar.add(baslangic);
        maze[0][0] = 0;
        Boyut = boyut;

        yolOlusturucu(maze);
 
    }

    public void yolOlusturucu(int maze[][]) {
        Random m = new Random();
        int k = 1;
        while (konumlar.size() != 0) {
            int index = konumlar.size()-1;
            if (konumlar.size() != 1 && k%20==0) {
                Random r = new Random();
                index = r.nextInt(konumlar.size());
            }
            anlikX=konumlar.get(index).x;
            anlikY=konumlar.get(index).y;
  //          System.out.println("Konum x = "+konumlar.get(index).x+" Konum y = "+konumlar.get(index).y);
            //Sağ için
            if (anlikY != genislik - 2 && anlikY != genislik - 1) {
                if (maze[anlikX][anlikY+2] != 0) {
                    String yon = "Sag";
                    yonler.add(yon);
                }
            }
            //Aşağı için
            if (anlikX != Boyut - 2 && anlikX != Boyut - 1) {
                if (maze[anlikX + 2][anlikY] != 0) {
                    String yon = "Asagi";
                    yonler.add(yon);
                }

            }
            //Sol için
            if (anlikY != 0) {
                if (maze[anlikX][anlikY - 2] != 0) {
                    String yon = "Sol";
                    yonler.add(yon);
                }

            }
            //Yukarı için
            if (anlikX != 0) {
                if (maze[anlikX - 2][anlikY] != 0) {
                    String yon = "Yukari";
                    yonler.add(yon);
                }

            }
            if(yonler.size()==0){
                konumlar.remove(index);
                continue;
            }
            if(yonler.size() > 1){
                Collections.shuffle(yonler);
            }
            
      //      System.out.println("Yönler : "+yonler.toString());
            
            if(yonler.get(0).equalsIgnoreCase("Sag")){
            maze[anlikX][anlikY+1]=0; 
            maze[anlikX][anlikY+2]=0;
            Konum yeni = new Konum();
            yeni.x=anlikX;
            yeni.y=anlikY+2;
            konumlar.add(yeni);
            }
            else if(yonler.get(0).equalsIgnoreCase("Sol")){               
            maze[anlikX][anlikY-1]=0; 
            maze[anlikX][anlikY-2]=0;
            Konum yeni = new Konum();
            yeni.x=anlikX;
            yeni.y=anlikY-2;
            konumlar.add(yeni);
            }
            else if(yonler.get(0).equalsIgnoreCase("Asagi")){               
            maze[anlikX+1][anlikY]=0; 
            maze[anlikX+2][anlikY]=0;
            Konum yeni = new Konum();
            yeni.x=anlikX+2;
            yeni.y=anlikY;
            konumlar.add(yeni);
            }
            else if(yonler.get(0).equalsIgnoreCase("Yukari")){               
            maze[anlikX-1][anlikY]=0; 
            maze[anlikX-2][anlikY]=0;
            Konum yeni = new Konum();
            yeni.x=anlikX-2;
            yeni.y=anlikY;
            konumlar.add(yeni);
            }
//            System.out.println("-----------------------");
//            for (int i = 0; i < maze.length; i++) {
//                for (int j = 0; j < maze.length; j++) {
//                    System.out.print(maze[i][j]);
//                    
//                }
//                System.out.println("");
//            }
//            System.out.println("-----------------------");            
            
            
            yonler.clear();
            k++;
            
            // while sonu
        }

    }

}



/*
//Sağ için
        if ( anlikY != Boyut - 2 && anlikY != Boyut-1) {
            if (maze[anlikX][anlikY + 2] != 0) {
                String yon = "Sag";
                yonler.add(yon);
            }
        }
        //Aşağı için
        if ( anlikX != Boyut - 2 && anlikX != Boyut - 1) {
            if (maze[anlikX + 2][anlikY] != 0) {
                String yon = "Asagi";
                yonler.add(yon);
            }

        }
        //Sol için
        if (anlikY != 0) {
            if (maze[anlikX][anlikY - 2] != 0) {
                String yon = "Sol";
                yonler.add(yon);
            }

        }
        //Yukarı için
        if (anlikX != 0) {
            if (maze[anlikX - 2][anlikY] != 0) {
                String yon = "Yukari";
                yonler.add(yon);
            }

        }
        for (int i = 0; i < yonler.size(); i++) {
            System.out.println(yonler.get(i));

        }
 */
