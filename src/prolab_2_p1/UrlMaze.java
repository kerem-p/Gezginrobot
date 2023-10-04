/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab_2_p1;

/**
 *
 * @author User
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class UrlMaze {

    int MazeOkunan[][];

    UrlMaze(URL url) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
        String satir;       
        ArrayList <String>SatirlarString = new ArrayList<String>();
        while ((satir = read.readLine()) != null) {
            SatirlarString.add(satir);
        }
        for (int i = 0; i < SatirlarString.size(); i++) {
            System.out.println(SatirlarString.get(i));
            
        }
        int maze[][] = new int [SatirlarString.size()][SatirlarString.get(0).length()];
       // System.out.println("Maze boy =" +SatirlarString.size()+"---"+SatirlarString.get(0).length() );
        for (int i = 0; i < SatirlarString.size(); i++) {
            for (int j = 0; j < SatirlarString.get(i).length(); j++) {
                 maze[i][j]=Integer.parseInt(String.valueOf(SatirlarString.get(i).charAt(j)));
                
            }
            
        }
        System.out.println("-------------");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print( maze[i][j]);
                
            }
            System.out.println("");
        }
        read.close();
    }

    public static void main(String[] args) {
        try {
            URL x = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
            UrlMaze a = new UrlMaze(x);
        } catch (Exception e) {
            
        }
    }
}
