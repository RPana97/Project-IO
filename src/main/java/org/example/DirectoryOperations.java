package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.logging.Level;

public class DirectoryOperations {

    /**
     * Displays the contents of a specified directory.
     *
     * @param path The directory path to display contents for.
     */
    public static void displayContents(String path) {
        File directory = new File(path);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    System.out.printf("%-20s %-10s %s\n", file.getName(), file.length(), sdf.format(file.lastModified()));
                }
                Logger.log(Level.INFO, "Displayed contents of directory: " + path);
            } else {
                Logger.log(Level.WARNING, "Could not list contents of directory: " + path);
            }
        } else {
            Logger.log(Level.WARNING, "Not a directory: " + path);
        }
    }

    /**
     * Creates a directory at the specified path.
     *
     * @param path The directory path to create.
     */
    public static void createDirectory(String path) {
        try {
            Files.createDirectories(Paths.get(path));
            Logger.log(Level.INFO, "Created directory: " + path);
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "Error creating directory: " + e.getMessage());
        }
    }

    /**
     * Deletes a directory at the specified path.
     *
     * @param path The directory path to delete.
     */
    public static void deleteDirectory(String path) {
        try {
            Files.deleteIfExists(Paths.get(path));
            Logger.log(Level.INFO, "Deleted directory: " + path);
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "Error deleting directory: " + e.getMessage());
        }
    }
}
