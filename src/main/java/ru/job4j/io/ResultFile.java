package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(Arrays.deepToString(Matrix.multiple(2)).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(Arrays.deepToString(Matrix.multiple(3)).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(Arrays.deepToString(Matrix.multiple(5)).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
