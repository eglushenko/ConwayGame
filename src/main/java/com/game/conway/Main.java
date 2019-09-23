package com.game.conway;

import com.game.conway.fileOperations.FileReaderConfigGame;
import com.game.conway.fileOperations.OutphutFileWriter;

import java.io.IOException;

public class Main {
    //Using English letters

    public static void main(String[] args) {
        FileReaderConfigGame fl = new FileReaderConfigGame();
        fl.readConfig();
        int generations = fl.getGenerations();
        String[][] field = fl.getArr();
        field = ConwayGameLogic.run(field,generations);
        OutphutFileWriter outphutFileWriter = new OutphutFileWriter();
        try {
            outphutFileWriter.write(field);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End "+ generations + " generation's");
    }

}
