/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.Random;

/**
 *
 * @author User
 */
public class Engeller {

    public static int[][] ikiEngeli(int matris[][], int x, int y) {
        Random r = new Random();
        int randomSayi = r.nextInt(5);
        if (randomSayi == 0) {
            matris[x][y] = 1;
            matris[x + 1][y] = 1;
            matris[x][y + 1] = 0;
            matris[x + 1][y + 1] = 0;
        }
        if (randomSayi == 1) {
            matris[x][y + 1] = 1;
            matris[x + 1][y + 1] = 1;
            matris[x][y] = 0;
            matris[x + 1][y] = 0;

        }
        if (randomSayi == 2) {
            matris[x][y + 1] = 1;
            matris[x + 1][y + 1] = 1;
            matris[x][y] = 0;
            matris[x + 1][y] = 1;

        }
        if (randomSayi == 3) {
            matris[x][y + 1] = 0;
            matris[x + 1][y + 1] = 1;
            matris[x][y] = 1;
            matris[x + 1][y] = 1;

        }
        if (randomSayi == 4) {
            matris[x][y + 1] = 0;
            matris[x + 1][y + 1] = 1;
            matris[x][y] = 0;
            matris[x + 1][y] = 1;

        }
        return matris;
    }

    public static int[][] ucEngeli(int matris[][], int x, int y) {
        Random r = new Random();
        int randomSayi = r.nextInt(5);
        if (randomSayi == 0) {
            matris[x][y] = 1;
            matris[x + 1][y] = 1;
            matris[x + 2][y] = 1;
            matris[x + 1][y + 1] = 1;
            matris[x][y + 1] = 0;
            matris[x][y + 2] = 0;
            matris[x + 1][y + 2] = 0;
            matris[x + 2][y + 1] = 0;
            matris[x + 2][y + 2] = 0;
        }
        if (randomSayi == 1) {
            matris[x][y] = 0;
            matris[x + 1][y] = 0;
            matris[x + 2][y] = 0;
            matris[x + 1][y + 1] = 1;
            matris[x][y + 1] = 0;
            matris[x][y + 2] = 1;
            matris[x + 1][y + 2] = 1;
            matris[x + 2][y + 1] = 0;
            matris[x + 2][y + 2] = 1;
        }
        if (randomSayi == 2) {
            matris[x][y] = 0;
            matris[x][y+1] = 0;
            matris[x][y+2] = 0;
            matris[x+1][y] = 1;
            matris[x+1][y+1] = 0;
            matris[x+1][y+2] = 1;
            matris[x+2][y] = 1;
            matris[x+2][y+1] = 1;
            matris[x+2][y+2] = 1;
        }
        if (randomSayi == 3) {
            matris[x][y] = 1;
            matris[x][y+1] = 1;
            matris[x][y+2] = 1;
            matris[x+1][y] = 1;
            matris[x+1][y+1] = 1;
            matris[x+1][y+2] = 1;
            matris[x+2][y] = 0;
            matris[x+2][y+1] = 0;
            matris[x+2][y+2] = 0;
        }
        if (randomSayi == 4) {
            matris[x][y] = 0;
            matris[x][y+1] = 0;
            matris[x][y+2] = 0;
            matris[x+1][y] = 1;
            matris[x+1][y+1] = 1;
            matris[x+1][y+2] = 1;
            matris[x+2][y] = 0;
            matris[x+2][y+1] = 0;
            matris[x+2][y+2] = 0;
        }
        

        return matris;
    }
}
