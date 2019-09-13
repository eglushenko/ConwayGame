package com.game.conway.fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReaderConfigGame {
    private int width;
    private int height;
    private int generations;
    private String[][] arr;
    public void readConfig(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("input.txt"));
            setWidth(scanner.nextInt());
            setHeight(scanner.nextInt());
            setGenerations(scanner.nextInt());
            String [][] tempArray = new String[width][height];
            int count = 0;

            for (int i = 0;i < tempArray.length ;i++){
                for (int j = 0;j < tempArray.length ; j++){
                    tempArray[i][j] = scanner.next();
                }
            }setArr(tempArray);
        }catch(InputMismatchException | FileNotFoundException e){
            System.out.println("Oops something went wrong -- File not found!");
            e.printStackTrace();
            System.exit(1);
        }catch (NoSuchElementException e){
            System.out.println("Error read file, no such element");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }
}
