package com.game.conway.fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReaderConfigGame {
    private int a;
    private int b;
    private int c;
    private String[][] arr;
    public void readConfig(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
            setA(scanner.nextInt());
            setB(scanner.nextInt());
            setC(scanner.nextInt());

                String [][] tempArray = new String[a][b];
                int count = 0;

                for (int i = 0;i < tempArray.length ;++i){
                    for (int j = 0;j < tempArray.length ; ++j){
                        tempArray[i][j] = scanner.next();
                        scanner.hasNext();
                        System.out.print(tempArray[i][j]);
                    }
                }

                setArr(tempArray);
            }catch(InputMismatchException | FileNotFoundException e){
                System.out.println("Ops somtings go wrong -- File not found!");
                System.out.println(e.getStackTrace());
                System.exit(1);
            }finally {

        }

    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }
}
