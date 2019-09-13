package com.game.conway;

import com.game.conway.fileOperations.OutphutFileWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    private static final String LIVE = "O";
    private static final String DEATH = "X";

    @Test
    public void main() {
        int generations = 3;
        String[][] field = {{"X","X","X","X","X","X","X","X","X"},
                            {"X","X","X","X","X","X","X","X","X"},
                            {"X","X","X","X","X","X","X","X","X"},
                            {"X","X","X","X","O","X","X","X","X"},
                            {"X","X","X","O","O","X","X","X","X"},
                            {"X","X","X","X","X","X","X","X","X"},
                            {"X","X","X","X","X","X","X","X","X"},
                            {"X","X","X","X","X","X","X","X","X"},
                            {"X","X","X","X","X","X","X","X","X"}};
        for (int gen = 1; gen <= generations; gen++) {
            String[][] fieldCopy = copyArray(field);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int liveCells = 0;
                    ArrayList<String> cellArray = new ArrayList<String>();
                    try {
                        cellArray.add(field[i - 1][j-1]);
                        cellArray.add(field[i - 1][j+1]);
                        cellArray.add(field[i - 1][j]);
                        cellArray.add(field[i][j - 1]);
                        cellArray.add(field[i][j + 1]);
                        cellArray.add(field[i + 1][j]);
                        cellArray.add(field[i + 1][j + 1]);
                        cellArray.add(field[i + 1][j - 1]);
                        for (int k = 0; k < cellArray.size(); k++) {
                            if (cellArray.get(k).equals(LIVE)) {
                                liveCells++;
                            }
                        }
                        if(field[i][j].equals(DEATH)){
                            if (liveCells == 3) {
                                fieldCopy[i][j] = LIVE;
                            }
                        }else{
                            if (liveCells <= 1 || liveCells > 3) {
                                fieldCopy[i][j] = DEATH;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                    }
                }
            }field = copyArray(fieldCopy);
        }assertTrue(field[3][3].equals(LIVE));

    }
        static private String[][] copyArray(String[][] arr) {
        String[][] tempArray = new String[arr.length][arr[0].length];
        for (int i = 0;i < arr.length;i++){
            for (int j = 0;j < arr[i].length;j++){
                tempArray[i][j] = arr[i][j];
            }
        }
        return tempArray;
    }
}