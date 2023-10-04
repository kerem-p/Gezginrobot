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
public class maindeneme {
    public static void main(String[] args) {
        int matris[][] = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0}
        };
        int matris2[][] = {
            {4, 4, 4, 4, 4},
            {0, 0, 0, 0, 4},
            {0, 0, 4, 4, 4},
            {0, 0, 0, 4, 4},
            {0, 0, 0, 4, 4},
            {0, 0, 0, 0, 0}
        };
        
        
        enKısaYol x = new enKısaYol(0,0,2,2,matris2,matris);
        for (int i = 0; i < x.dogruYol.size(); i++) {
            System.out.println("X="+x.dogruYol.get(i).x+" Y="+x.dogruYol.get(i).y+" Uzaklık="+x.dogruYol.get(i).Uzaklık);
            
        }
        
    }
}
