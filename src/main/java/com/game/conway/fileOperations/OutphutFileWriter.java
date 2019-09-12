package com.game.conway.fileOperations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutphutFileWriter {
    public void write(String[][] array) throws IOException {
        BufferedWriter output = null;
        output = new BufferedWriter(new FileWriter("output.txt"));
        for (int i = 0; i <array.length;i++){
            output.write("\n");
            for (int j = 0; j < array[i].length;j++){
                output.write(array[i][j] + " ");
            }
        }
        output.flush();
        output.close();
    }

}
