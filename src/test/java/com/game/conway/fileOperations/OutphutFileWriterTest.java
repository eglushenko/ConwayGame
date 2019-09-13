package com.game.conway.fileOperations;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class OutphutFileWriterTest {

    @Test
    public void write() throws IOException {
        String s = "test";
        BufferedWriter output = null;
        output = new BufferedWriter(new FileWriter("src/test/resources/writetest.txt"));
        output.write(s);
        output.flush();
        output.close();
        Scanner scanner = null;
        scanner = new Scanner(new File("src/test/resources/writetest.txt"));
        String b = scanner.nextLine();
        boolean res = s.equals(b);
        assertTrue(res);
    }
}