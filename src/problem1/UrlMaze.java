/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author User
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class UrlMaze {

    int MazeOkunan[][];
    int mazeOynanacak[][];
    int baslangicX;
    int baslangicY;
    int bitisX;
    int bitisY;

    UrlMaze(URL url) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
        String satir;
        ArrayList<String> SatirlarString = new ArrayList<String>();
        while ((satir = read.readLine()) != null) {
            SatirlarString.add(satir);
        }
//        for (int i = 0; i < SatirlarString.size(); i++) {
//            System.out.println(SatirlarString.get(i));
//            
//        }
        read.close();
        int maze[][] = new int[SatirlarString.size()][SatirlarString.get(0).length()];
        // System.out.println("Maze boy =" +SatirlarString.size()+"---"+SatirlarString.get(0).length() );
        for (int i = 0; i < SatirlarString.size(); i++) {
            for (int j = 0; j < SatirlarString.get(i).length(); j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(SatirlarString.get(i).charAt(j)));

            }

        }
        this.MazeOkunan = maze;
//        System.out.println("--------------------");
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[i].length; j++) {
//                System.out.print(this.MazeOkunan[i][j]);
//
//            }
//            System.out.println("");
//        }
//        System.out.println("--------------------");
        int mazeOyun[][] = new int[MazeOkunan.length][MazeOkunan[0].length];
        for (int i = 0; i < mazeOyun.length; i++) {
            for (int j = 0; j < mazeOyun.length; j++) {
                mazeOyun[i][j] = maze[i][j];

            }

        }
        for (int i = 0; i < mazeOyun.length; i++) {
            for (int j = 0; j < mazeOyun.length; j++) {
                if (mazeOyun[i][j] == 2) {
                    if (i == 0 && j == 0) {
                        mazeOyun = Engeller.ikiEngeli(mazeOyun, i, j);
                    } else if (i != 0 && j != 0) {
                        if (mazeOyun[i - 1][j - 1] != 2) {
                            mazeOyun = Engeller.ikiEngeli(mazeOyun, i, j);
                        }
                    } else if (i == 0) {
                        if (mazeOyun[i][j - 1] != 2) {
                            mazeOyun = Engeller.ikiEngeli(mazeOyun, i, j);
                        }
                    } else if (j == 0) {
                        if (mazeOyun[i - 1][j] != 2) {
                            mazeOyun = Engeller.ikiEngeli(mazeOyun, i, j);
                        }
                    }

                }
                if (mazeOyun[i][j] == 3) {
                    if (i == 0 && j == 0) {
                        mazeOyun = Engeller.ucEngeli(mazeOyun, i, j);
                    } else if (i != 0 && j != 0) {
                        if (mazeOyun[i - 1][j - 1] != 3) {
                            mazeOyun = Engeller.ucEngeli(mazeOyun, i, j);
                        }
                    } else if (i == 0) {
                        if (mazeOyun[i][j - 1] != 3) {
                            mazeOyun = Engeller.ucEngeli(mazeOyun, i, j);
                        }
                    } else if (j == 0) {
                        if (mazeOyun[i - 1][j] != 3) {
                            mazeOyun = Engeller.ucEngeli(mazeOyun, i, j);
                        }
                    }

                }
            }

        }
        this.mazeOynanacak = mazeOyun;
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0; j < maze[i].length; j++) {
//                System.out.print(mazeOyun[i][j]);
//
//            }
//            System.out.println("");
//        }
        int basX, basY, bitX, bitY;
        Random r = new Random();
        basX = r.nextInt(mazeOynanacak.length);
        basY = r.nextInt(mazeOynanacak[0].length);
        bitX = r.nextInt(mazeOynanacak.length);
        bitY = r.nextInt(mazeOynanacak[0].length);
        while (mazeOynanacak[basX][basY] == 1) {
            basX = r.nextInt(mazeOynanacak.length-1);
            basY = r.nextInt(mazeOynanacak[0].length-1);
        }
        while (mazeOynanacak[bitX][bitY] == 1) {
            bitX = r.nextInt(mazeOynanacak.length-1);
            bitY = r.nextInt(mazeOynanacak[0].length-1);
        }
        this.baslangicX=basX;
        this.baslangicY=basY;
        this.bitisX=bitX;
        this.bitisY=bitY;
    }

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL x = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
        UrlMaze a = new UrlMaze(x);

        for (int i = 0; i < a.MazeOkunan.length; i++) {
            for (int j = 0; j < a.MazeOkunan[0].length; j++) {
                System.out.print(a.MazeOkunan[i][j]);

            }
            System.out.println("");
        }
        System.out.println("-------------------------");
        for (int i = 0; i < a.MazeOkunan.length; i++) {
            for (int j = 0; j < a.MazeOkunan[0].length; j++) {
                System.out.print(a.mazeOynanacak[i][j]);

            }
            System.out.println("");
        }
        System.out.println("----------------------");
        System.out.println("Baslangic  X="+a.baslangicX+" Y="+a.baslangicY+" Bitis X="+a.bitisX+" Bitis Y="+a.bitisY);

    }
}
