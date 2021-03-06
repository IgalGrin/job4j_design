package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(target)) {
            boolean on = true;
            for (String line = ""; line != null; line = read.readLine()) {
                if (line.contains("200") || line.contains("300")) {
                    if (!on) {
                        String[] s = line.split(" ");
                        out.println(s[1]);
                        on = true;
                    }
                } else if (line.contains("400") || line.contains("500")) {
                    if (on) {
                        String[] s = line.split(" ");
                        out.print(s[1] + ";");
                        on = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/unavailable.csv", "./data/target.txt");
    }
}

