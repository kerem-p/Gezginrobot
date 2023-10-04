/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prolab_2_p1;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kerem
 */
public class mazedeneme {

    public static void main(String[] args) {
        Labirent x = new Labirent(11,11);

        JFrame ekran = new JFrame("Problem-2");
        ekran.setVisible(true);
        ekran.setSize(1920, 1080);


        Panel_problem2 a = new Panel_problem2(x);
        a.setVisible(true);
        ekran.add(a);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
