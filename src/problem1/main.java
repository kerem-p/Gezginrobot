/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.io.IOException;
import java.net.URL;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class main {

    public static void main(String[] args) throws IOException {
        JFrame ekran = new JFrame("ekran");
        ekran.setVisible(true);
        ekran.setSize(1920,1080);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_p1 x = new panel_p1();
        ekran.add(x);
        
        
        
////        URL x = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
////        UrlMaze a = new UrlMaze(x);
////        Robotv2 robot = new Robotv2(a.MazeOkunan.length,a.MazeOkunan[0].length,a.baslangicX,a.baslangicY,a.bitisX,a.bitisY);
////        
////        for (int i = 0; i < 900; i++) {
////            robot.hareketEt(a.mazeOynanacak);
////            
////        }
////        for (int i = 0; i < robot.gezdigiYerler.length; i++) {
////            for (int j = 0; j < robot.gezdigiYerler[0].length; j++) {
////                System.out.print(robot.gezdigiYerler[i][j]);
////                
////            }
////            System.out.println("");
////        }


    }
}
