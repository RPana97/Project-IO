package org.example;

import java.io.File;
import java.util.logging.Level;

public class SearchOperations {

    /**
     * Searches for files within the specified directory based on the search query.
     * Logs the search operation.
     *
     * @param directory The directory to search in.
     * @param searchQuery The search query (file name or extension).
     */
    public static void searchFiles(String directory, String searchQuery) {
        File dir = new File(directory);
        if (dir.isDirectory()) {
            searchRecursive(dir, searchQuery);
            Logger.log(Level.INFO, "Searched for files in directory: " + directory + " with query: " + searchQuery);
        } else {
            Logger.log(Level.WARNING, "Not a directory: " + directory);
        }
    }

    /**
     * Recursively searches for files within the directory that match the search query.
     *
     * @param dir The directory to search in.
     * @param searchQuery The search query (file name or extension).
     */
    public static void searchRecursive(File dir, String searchQuery) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                // If the file is a directory, recursively search within it
                if (file.isDirectory()) {
                    searchRecursive(file, searchQuery);
                } else if (file.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                    // If the file name contains the search query, print its absolute path
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
