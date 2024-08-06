package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;

public class FileOperations {

    /**
     * Copies a file from the source path to the destination path.
     *
     * @param source The source file path.
     * @param destination The destination file path.
     */
    public static void copyFile(String source, String destination) {
        try {
            Files.copy(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            Logger.log(Level.INFO, "Copied file from " + source + " to " + destination);
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "Error copying file: " + e.getMessage());
        }
    }

    /**
     * Moves a file from the source path to the destination path.
     *
     * @param source The source file path.
     * @param destination The destination file path.
     */
    public static void moveFile(String source, String destination) {
        try {
            Files.move(Paths.get(source), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            Logger.log(Level.INFO, "Moved file from " + source + " to " + destination);
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "Error moving file: " + e.getMessage());
        }
    }

    /**
     * Deletes a file at the specified path.
     *
     * @param path The file path to delete.
     */
    public static void deleteFile(String path) {
        try {
            Logger.log(Level.INFO, "Attempting to delete file: " + path);
            boolean deleted = Files.deleteIfExists(Paths.get(path));
            if (deleted) {
                Logger.log(Level.INFO, "Deleted file: " + path);
            } else {
                Logger.log(Level.WARNING, "File not found or could not be deleted: " + path);
            }
        } catch (IOException e) {
            Logger.log(Level.SEVERE, "Error deleting file: " + e.getMessage());
        }
    }
}
