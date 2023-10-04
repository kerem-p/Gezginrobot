/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author User
 */
public class enKısaYol {

    int matris[][];
    int basX, basY, bitisX, bitisY;
    int visitMatris[][];
    ArrayList<Hücre> tumHucreler = new ArrayList<Hücre>();
    ArrayList<Hücre> dogruYol = new ArrayList<Hücre>();

    public enKısaYol(int baslangicX, int baslangicY, int bitisX, int bitisY,int robotunGezdigiMatris[][],int labMatris[][]) {
//        int matris[][] = {
//            {0, 0, 0, 0, 0},
//            {0, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0},
//            {0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 0}
//        };
//        int visit[][] = {
//            {0, 0, 0, 0, 0},
//            {0, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0},
//            {0, 1, 1, 0, 0},
//            {0, 0, 0, 0, 0}
//        };
//        this.matris = matris;
//        this.visitMatris = visit;
        enKisaHesaplanacakMatris(robotunGezdigiMatris, labMatris);
        this.basX = baslangicX;
        this.basY = baslangicY;
        this.bitisX = bitisX;
        this.bitisY = bitisY;

        yolBul();
//        for (int i = 0; i < tumHucreler.size(); i++) {
//            System.out.println(i + ".ci Hucre X= " + tumHucreler.get(i).x + "  Y=" + tumHucreler.get(i).y + " Uzaklik =" + tumHucreler.get(i).Uzaklık);
//
//        }
        Hücre sonYer = new Hücre();
        int sonUzaklik;;
        dogruYol.add(tumHucreler.get(0));
        for (int i = 0; i < tumHucreler.size(); i++) {
            if (bitisX == tumHucreler.get(i).x && bitisY == tumHucreler.get(i).y) {
                sonYer.x = tumHucreler.get(i).x;
                sonYer.y = tumHucreler.get(i).y;
                sonYer.Uzaklık = tumHucreler.get(i).Uzaklık;
                dogruYol.add(sonYer);
            }

        }
        // System.out.println("--"+dogruYol.get(0).x+"---"+dogruYol.get(0).y+"---"+dogruYol.get(0).Uzaklık);
        // önceki yolları ekliyicez komşusuysa ekle eklemeleri 1. indexe yap
        //kopya son üret
        Hücre hucreIter = new Hücre();
        hucreIter.x=sonYer.x;
        hucreIter.y=sonYer.y;
        hucreIter.Uzaklık=sonYer.Uzaklık;
        
        while (hucreIter.Uzaklık != 0) {
            // son adımın komşusu mu
            for (int i = 0; i < tumHucreler.size(); i++) {
                if(tumHucreler.get(i).Uzaklık+1==hucreIter.Uzaklık){
                    if(tumHucreler.get(i).x+1==hucreIter.x && tumHucreler.get(i).y==hucreIter.y){
                        dogruYol.add(0,tumHucreler.get(i));
                        hucreIter=tumHucreler.get(i);
                        break;
                    }
                    else if(tumHucreler.get(i).x-1==hucreIter.x && tumHucreler.get(i).y==hucreIter.y){
                        dogruYol.add(0,tumHucreler.get(i));
                        hucreIter=tumHucreler.get(i);
                        break;
                    }
                    else if(tumHucreler.get(i).x==hucreIter.x && tumHucreler.get(i).y+1==hucreIter.y){
                        dogruYol.add(0,tumHucreler.get(i));
                        hucreIter=tumHucreler.get(i);
                        break;
                    }
                    else if(tumHucreler.get(i).x==hucreIter.x && tumHucreler.get(i).y-1==hucreIter.y){
                        dogruYol.add(0,tumHucreler.get(i));
                        hucreIter=tumHucreler.get(i);
                        break;
                    }
                }
                
            }
        }
        
        dogruYol.remove(dogruYol.size()-2);
//        for (int i = 0; i < dogruYol.size(); i++) {
//            System.out.println("X="+dogruYol.get(i).x+" Y="+dogruYol.get(i).y+" Uzaklık="+dogruYol.get(i).Uzaklık);
//            
//        }

    }

    public void yolBul() {
        Hücre baslangicHücre = new Hücre();
        baslangicHücre.x = basX;
        baslangicHücre.y = basY;
        baslangicHücre.Uzaklık = 0;
        this.visitMatris[baslangicHücre.x][baslangicHücre.y] = 1;
        tumHucreler.add(baslangicHücre);
        Queue<Hücre> kuyruktakiHücreler = new LinkedList<>();
        kuyruktakiHücreler.add(baslangicHücre);

        while (kuyruktakiHücreler.size() != 0) {

            Hücre kuyrukBasHucre = kuyruktakiHücreler.peek();
            if (kuyrukBasHucre.x == bitisX && kuyrukBasHucre.y == bitisY) {
                break;
            }
            //yukarı için
            if (kuyrukBasHucre.x != 0) {
                if (visitMatris[kuyrukBasHucre.x - 1][kuyrukBasHucre.y] != 1) {
                    Hücre yeni = new Hücre();
                    yeni.x = kuyrukBasHucre.x - 1;
                    yeni.y = kuyrukBasHucre.y;
                    yeni.Uzaklık = kuyrukBasHucre.Uzaklık + 1;
                    kuyruktakiHücreler.add(yeni);
                    tumHucreler.add(yeni);
                    visitMatris[yeni.x][yeni.y] = 1;
                }
            }
            //Aşağı
            if (kuyrukBasHucre.x != matris.length - 1) {
                if (visitMatris[kuyrukBasHucre.x + 1][kuyrukBasHucre.y] != 1) {
                    Hücre yeni = new Hücre();
                    yeni.x = kuyrukBasHucre.x + 1;
                    yeni.y = kuyrukBasHucre.y;
                    yeni.Uzaklık = kuyrukBasHucre.Uzaklık + 1;
                    kuyruktakiHücreler.add(yeni);
                    tumHucreler.add(yeni);
                    visitMatris[yeni.x][yeni.y] = 1;
                }
            }
            //Sağ
            if (kuyrukBasHucre.y != matris[0].length - 1) {
                if (visitMatris[kuyrukBasHucre.x][kuyrukBasHucre.y + 1] != 1) {
                    Hücre yeni = new Hücre();
                    yeni.x = kuyrukBasHucre.x;
                    yeni.y = kuyrukBasHucre.y + 1;
                    yeni.Uzaklık = kuyrukBasHucre.Uzaklık + 1;
                    kuyruktakiHücreler.add(yeni);
                    tumHucreler.add(yeni);
                    visitMatris[yeni.x][yeni.y] = 1;
                }
            }
            //sol
            if (kuyrukBasHucre.y != 0) {
                if (visitMatris[kuyrukBasHucre.x][kuyrukBasHucre.y - 1] != 1) {
                    Hücre yeni = new Hücre();
                    yeni.x = kuyrukBasHucre.x;
                    yeni.y = kuyrukBasHucre.y - 1;
                    yeni.Uzaklık = kuyrukBasHucre.Uzaklık + 1;
                    kuyruktakiHücreler.add(yeni);
                    tumHucreler.add(yeni);
                    visitMatris[yeni.x][yeni.y] = 1;
                }
            }

            kuyruktakiHücreler.remove();
        }

    }
    public void enKisaHesaplanacakMatris(int robotunGezdigiMatris[][],int labMatris[][]){
        int Matris [][] = new int[robotunGezdigiMatris.length][robotunGezdigiMatris[0].length];
        for (int i = 0; i < Matris.length; i++) {
            for (int j = 0; j < Matris[0].length; j++) {
                Matris[i][j]=1;
                
            }
            
        }
        
        for (int i = 0; i < Matris.length; i++) {
            for (int j = 0; j < Matris[0].length; j++) {
                if(robotunGezdigiMatris[i][j]==4){
                    Matris[i][j]=0;
                }
                
            }
            
        }
        
        for (int i = 0; i < Matris.length; i++) {
            for (int j = 0; j < Matris[0].length; j++) {
                if(robotunGezdigiMatris[i][j]==4){
                    if(i!=0){
                        if(labMatris[i-1][j]==0){
                            Matris[i-1][j]=0;
                        }
                    }
                    if(i!=Matris.length-1){
                        if(labMatris[i+1][j]==0){
                            Matris[i+1][j]=0;
                        }
                    }
                    if(j!=Matris[0].length-1){
                        if(labMatris[i][j+1]==0){
                            Matris[i][j+1]=0;
                        }
                    }
                    if(j!=0){
                        if(labMatris[i][j-1]==0){
                            Matris[i][j-1]=0;
                        }
                    }
                }
                
            }
            
        }
        int visitMatrisi[][] = new int[Matris.length][Matris[0].length];
        for (int i = 0; i < visitMatrisi.length; i++) {
            for (int j = 0; j < visitMatrisi[0].length; j++) {
                visitMatrisi[i][j]=Matris[i][j];
                
            }
            
        }
//        for (int i = 0; i < Matris.length; i++) {
//            for (int j = 0; j < Matris[0].length; j++) {
//                System.out.print(Matris[i][j]);
//                
//            }
//            System.out.println("");
//        }
        this.matris=Matris;
        this.visitMatris=visitMatrisi;
        
    }
    
    
    
    

}
