package com.game.conway;

import com.game.conway.fileOperations.StatusEnum;

import java.util.ArrayList;

class ConwayGameLogic {

    static String[][] run(String[][] field, int generations) {
        for (int gen = 1; gen <= generations; gen++) {
            String[][] fieldCopy = copyArray(field);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    int liveCells = 0;
                    ArrayList<String> cellArray;
                    cellArray = stringArrayListCellAround(i,j,field);
                    //Rules
                    for (String s : cellArray) {    //calc all live cells around the cell
                        if (s.equals(StatusEnum.LIVE.getTypeOfStatus())) {
                            liveCells++;
                        }
                    }
                    if(field[i][j].equals(StatusEnum.DEATH.getTypeOfStatus())){                  //gelneral logic to set cell
                        if (liveCells == 3) {
                            fieldCopy[i][j] = StatusEnum.LIVE.getTypeOfStatus();
                        }
                    }else{
                        if (liveCells <= 1 || liveCells > 3) {
                            fieldCopy[i][j] = StatusEnum.DEATH.getTypeOfStatus();
                        }
                    }
                }
            }field = copyArray(fieldCopy);
        }
        return field;
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
                        x=field.length-1;
                    }if(jj == -1&& y < 0){
                        y=field[0].length-1;
                    }if(ii == 1&& x >=field.length){
                        x=0;
                    }if(jj == 1&& y>=field[0].length){
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
