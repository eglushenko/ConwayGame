package com.game.conway;

import com.game.conway.fileOperations.FileReaderConfigGame;
import com.game.conway.fileOperations.OutphutFileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String LIVE = "O";//English
    private static final String DEATH = "X";

    public static void main(String[] args) {
        FileReaderConfigGame fl = new FileReaderConfigGame();
        fl.readConfig();
        int generations = fl.getC();
        String[][] field = fl.getArr();                                //Get read array
        for (int gen = 1; gen <= generations; gen++) {
            String[][] fieldCopy = copyArrey(field);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int liveCells = 0;
                    ArrayList<String> cellArray = new ArrayList<String>();
                    try {
                        //add to cellArray all cells around our cell
                        //indexOfBoundException if i = 0 ([i-1] = -1) for example
                        cellArray.add(field[i - 1][j-1]);
                        cellArray.add(field[i - 1][j+1]);
                        cellArray.add(field[i - 1][j]);
                        cellArray.add(field[i][j - 1]);
                        cellArray.add(field[i][j + 1]);
                        cellArray.add(field[i + 1][j]);
                        cellArray.add(field[i + 1][j + 1]);
                        cellArray.add(field[i + 1][j - 1]);
                        //Rules
                        //TODO Not correct works
                        for (int k = 0; k < cellArray.size(); k++) {
                            if (cellArray.get(k).equals(LIVE)) {
                                liveCells++;
                            }
                            if(field[i][j].equals(DEATH)){
                                if (liveCells == 3) {
                                    fieldCopy[i][j] = LIVE;
                                }
                            }else{
                                if (liveCells < 2 || liveCells > 3) {
                                    fieldCopy[i][j] = DEATH;
                                }
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                        //TODO ArrayIndex Exception need read ...
                    }
                }
            }field = copyArrey(fieldCopy);// copy new field
        }
        OutphutFileWriter outphutFileWriter =new OutphutFileWriter();
        try {
            outphutFileWriter.write(field);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End "+ generations + " generation's");
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
