/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author kerem
 */
public class mainPanel extends JPanel {

    JLabel resim;
    JButton problem1Gecis;
    JButton problem2Gecis;
    JLabel hosGeldiniz;

    public mainPanel() {
        super();
        setLayout(null);

        setBackground(Color.darkGray);
        this.setOpaque(true);
        this.hosGeldiniz = new JLabel("<html>GEZGİN ROBOTA <br/> HOŞGELDİNİZ</html>",SwingConstants.CENTER);
        
        this.hosGeldiniz.setBounds(790,100,500,250);
        this.hosGeldiniz.setVisible(true);
        this.hosGeldiniz.setFont(new Font("",Font.BOLD,45));
        this.hosGeldiniz.setForeground(Color.decode("#D4AF37"));
        add(this.hosGeldiniz);
        JButton problem1 = new JButton("Problem-1");
        problem1.setBackground(Color.DARK_GRAY);
        problem1.setFont(new Font("",Font.BOLD,20));
        problem1.setForeground(Color.decode("#D4AF37"));
        problem1.setBounds(850, 550, 200, 75);
        problem1.setVisible(true);
        add(problem1);
        this.problem1Gecis = problem1;

        // problem1.setBackground(Color.gray);
        //  problem1Gecis.setBackground(Color.orange);
        JButton problem2 = new JButton("Problem-2");
        problem2.setBackground(Color.DARK_GRAY);
        problem2.setFont(new Font("",Font.BOLD,20));
        problem2.setForeground(Color.decode("#D4AF37"));
        problem2.setBounds(1200, 550, 200, 75);
        problem2.setVisible(true);
        add(problem2);
        this.problem2Gecis = problem2;
        //problem2.setBackground(Color.gray);

//        Icon resim = new ImageIcon(this.getClass().getResource("/res/giphy.gif"));
//        this.resim = new JLabel(resim);
        this.resim = new JLabel(new ImageIcon(this.getClass().getResource("/res/robotresim.png")));

        add(this.resim);
        this.resim.setBounds(100, 20, 610, 720);
        this.resim.setVisible(true);
    }

}
