package com.game.conway;

import com.game.conway.fileOperations.FileReaderConfigGame;
import com.game.conway.fileOperations.OutphutFileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String LIVE = "O";
    private static final String DEATH = "X";

    public static void main(String[] args) {
        FileReaderConfigGame fl = new FileReaderConfigGame();
        fl.readConfig();
        int rows = fl.getA();
        int collums = fl.getB();
        int generations = fl.getC();
        String[][] feild = fl.getArr();
        String[][] fieldCopy = feild;
        for (int gen = 1; gen <= generations; gen++) {
            for (int i = 0; i < feild.length; i++) {
                for (int j = 0; j < feild[i].length; j++) {
                    int liveCells = 0;
                    ArrayList<String> cellArray = null;
                    try {
                        //add to cellArray all cells around our cell
                        cellArray.add(feild[i - 1][j-1]);
                        cellArray.add(feild[i - 1][j+1]);
                        cellArray.add(feild[i - 1][j]);
                        cellArray.add(feild[i][j - 1]);
                        //cellArray.add(feild[i][j]);
                        cellArray.add(feild[i][j + 1]);
                        cellArray.add(feild[i + 1][j]);
                        cellArray.add(feild[i + 1][j + 1]);
                        cellArray.add(feild[i + 1][j - 1]);
                        //Rules
                        for (int k = 0; k < cellArray.size(); k++) {
                            if (cellArray.get(k).equals(LIVE)) {
                                liveCells++;
                            }

                        }if(feild[i][j].equals(DEATH)){
                            if (liveCells == 3) {
                                fieldCopy[i][j] = LIVE;
                        }
                        }else {
                            if (liveCells < 2 || liveCells > 3) {
                                fieldCopy[i][j] = DEATH;
                            }
                        }

                    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {

                    }
                }
            }
        }feild = copyArrey(fieldCopy);
        OutphutFileWriter outphutFileWriter =new OutphutFileWriter();
        try {
            outphutFileWriter.write(feild);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End "+ generations + "generation's");
    }
    static private String[][] copyArrey(String[][] arr) {
        String[][] tempArray = new String[arr.length][arr[0].length];
        for (int i = 0;i < arr.length;i++){
            for (int j = 0;j < arr[i].length;j++){

                    tempArray[i][j] = arr[i][j];
            }
        }
        return tempArray;
    }

}
