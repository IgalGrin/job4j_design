package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    HashSet<Path> duplicates = new HashSet<Path>();
    HashMap<FileProperty, Path> collect = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty value = new FileProperty(Files.size(file), file.getFileName().toString());
        if (!collect.containsKey(value)) {
            collect.put(value, file);
        } else {
            duplicates.add(file);
            System.out.println(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

}
