/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainFrame;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import problem1.panel_p1;
import prolab_2_p1.Panel_problem2;
import prolab_2_p1.Labirent;

/**
 *
 * @author kerem
 */
public class mainFrame extends JFrame {

    Panel_problem2 panel2;
    panel_p1 panel1;
    mainPanel panelMain;

    public mainFrame() throws HeadlessException, IOException {
        super();
        setTitle("Gezgin Robot");

        setLayout(null);
        setSize(1920, 1080);
        setVisible(true);
        panelMain = new mainPanel();
        panel1 = new panel_p1();
        panel2 = new Panel_problem2(new Labirent(21, 21));
        panel2.setVisible(false);
        panel1.setVisible(false);
        panelMain.setVisible(true);
        add(panelMain);
        add(panel1);
        add(panel2);
        setContentPane(panelMain);
        panelMain.problem1Gecis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                setContentPane(panel1);
            }
        });
        panelMain.problem2Gecis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(true);
                setContentPane(panel2);
            }
        });

        panel1.problemDegis1 = new JButton("Problem Değiştir");
        panel1.problemDegis1.setBounds(1300, 600, 150, 50);
        panel1.problemDegis1.setVisible(true);
        panel1.add(panel1.problemDegis1);
        panel1.problemDegis1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(true);
                setContentPane(panel2);
            }
        });

        panel2.problemDegis2 = new JButton("Problem Değiştir");
        panel2.problemDegis2.setBounds(1200, 600, 150, 50);
        panel2.problemDegis2.setVisible(true);
        panel2.add(panel2.problemDegis2);
        panel2.problemDegis2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(true);
                setContentPane(panel1);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    }

    

    public static void main(String[] args) throws HeadlessException, IOException {
        mainFrame x = new mainFrame();
    }
}
