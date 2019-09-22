package com.game.conway;

import com.game.conway.fileOperations.FileReaderConfigGame;
import com.game.conway.fileOperations.OutphutFileWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    //Using English letters
    private static final String LIVE = "O";
    private static final String DEATH = "X";

    public static void main(String[] args) {
        FileReaderConfigGame fl = new FileReaderConfigGame();
        fl.readConfig();
        int generations = fl.getGenerations();
        String[][] field = fl.getArr();                                //Get read array
        for (int gen = 1; gen <= generations; gen++) {
            String[][] fieldCopy = copyArray(field);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int liveCells = 0;
                    ArrayList<String> cellArray;
                        cellArray = stringArrayListCellAround(i,j,field);
                        //Rules
                    for (String s : cellArray) {    //calc all live cells around the cell
                        if (s.equals(LIVE)) {
                            liveCells++;
                        }
                    }
                        if(field[i][j].equals(DEATH)){                  //gelneral logic to set cell
                            if (liveCells == 3) {
                                fieldCopy[i][j] = LIVE;
                            }
                        }else{
                            if (liveCells <= 1 || liveCells > 3) {
                                fieldCopy[i][j] = DEATH;
                            }
                        }
                    }
                }field = copyArray(fieldCopy);                                  // copy new field
            }
        OutphutFileWriter outphutFileWriter = new OutphutFileWriter();
        try {
            outphutFileWriter.write(field);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End "+ generations + " generation's");
    }
    static private String[][] copyArray(String[][] arr) {
        String[][] tempArray = new String[arr.length][arr[0].length];
        for (int i = 0;i < arr.length;i++){
            System.arraycopy(arr[i], 0, tempArray[i], 0, arr[i].length);
        }
        return tempArray;
    }
    static private ArrayList<String> stringArrayListCellAround(int i,int j,String[][] field){
        ArrayList<String> cellArray = new ArrayList<>();
        try {
            for (int ii = -1;ii<=1;ii++){
                for (int jj= -1;jj<=1;jj++){
                    int x = i+ii;
                    int y = j + jj;
                    if(jj == 0 && ii == 0){
                        continue;
                    }if(ii == -1 && x <0){
                        x=8;
                    }if(jj == -1&& y < 0){
                        y=8;
                    }if(ii == 1&& x >8){
                        x=0;
                    }if(jj == 1&& y>8){
                        y=0;
                    }
                    cellArray.add(field[x][y]);

                }
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return cellArray;
    }

}
