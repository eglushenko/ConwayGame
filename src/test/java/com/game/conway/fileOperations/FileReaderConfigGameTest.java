package com.game.conway.fileOperations;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileReaderConfigGameTest {

    @Test(expected = FileNotFoundException.class)
    public void readConfigFileNotFound() throws FileNotFoundException {
        Scanner scanner = null;
        scanner = new Scanner(new File("none.txt"));
    }
    @Test
    public void readConfigFirstSecondThirdParam() throws FileNotFoundException {
        int a,b,c;
        boolean result = false;
        Scanner scanner = null;
        scanner = new Scanner(new File("src/test/resources/readconfigtest1.txt"));
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        if(a == 9&&b==9&&c==3){
            result = true;
        }
        assertTrue(result);
    }
}