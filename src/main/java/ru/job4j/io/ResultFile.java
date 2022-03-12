package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(Arrays.deepToString(new Matrix().multiple(3)).getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write(Arrays.deepToString(new Matrix().multiple(4)).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
