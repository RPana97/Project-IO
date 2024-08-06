package org.example;

import java.util.Scanner;

public class FileManagerApp {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Runs the file manager application, displaying the menu and handling user input.
     */
    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayDirectoryContents();
                    break;
                case 2:
                    copyFile();
                    break;
                case 3:
                    moveFile();
                    break;
                case 4:
                    deleteFile();
                    break;
                case 5:
                    createDirectory();
                    break;
                case 6:
                    deleteDirectory();
                    break;
                case 7:
                    searchFiles();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nFile Manager");
        System.out.println("1. Display directory contents");
        System.out.println("2. Copy file");
        System.out.println("3. Move file");
        System.out.println("4. Delete file");
        System.out.println("5. Create directory");
        System.out.println("6. Delete directory");
        System.out.println("7. Search files");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Gets the user's choice, ensuring it is a valid integer.
     *
     * @return The user's choice as an integer.
     */
    private int getUserChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return choice;
    }

    /**
     * Prompts the user to enter a directory path and displays its contents.
     */
    private void displayDirectoryContents() {
        System.out.println("Example directory path: C:\\Users\\YourName\\Documents");
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        DirectoryOperations.displayContents(path);
        System.out.println("Displayed contents of directory: " + path);
    }

    /**
     * Prompts the user to enter source and destination paths and copies a file.
     */
    private void copyFile() {
        System.out.println("Example file path: C:\\Users\\YourName\\Documents\\file.txt");
        System.out.print("Enter source file path: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destination = scanner.nextLine();
        FileOperations.copyFile(source, destination);
        System.out.println("Copied file from " + source + " to " + destination);
    }

    /**
     * Prompts the user to enter source and destination paths and moves a file.
     */
    private void moveFile() {
        System.out.println("Example file path: C:\\Users\\YourName\\Documents\\file.txt");
        System.out.print("Enter source file path: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destination = scanner.nextLine();
        FileOperations.moveFile(source, destination);
        System.out.println("Moved file from " + source + " to " + destination);
    }

    /**
     * Prompts the user to enter a file path and deletes the specified file.
     */
    private void deleteFile() {
        System.out.println("Example file path: C:\\Users\\YourName\\Documents\\file.txt");
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();
        FileOperations.deleteFile(path);
        System.out.println("Deleted file: " + path);
    }

    /**
     * Prompts the user to enter a directory path and creates the specified directory.
     */
    private void createDirectory() {
        System.out.println("Example directory path: C:\\Users\\YourName\\Documents\\NewFolder");
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        DirectoryOperations.createDirectory(path);
        System.out.println("Created directory: " + path);
    }

    /**
     * Prompts the user to enter a directory path and deletes the specified directory.
     */
    private void deleteDirectory() {
        System.out.println("Example directory path: C:\\Users\\YourName\\Documents\\OldFolder");
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        DirectoryOperations.deleteDirectory(path);
        System.out.println("Deleted directory: " + path);
    }

    /**
     * Prompts the user to enter a directory path and a search query, then searches for matching files.
     */
    private void searchFiles() {
        System.out.println("Example directory path: C:\\Users\\YourName\\Documents");
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        SearchOperations.searchFiles(path, query);
        System.out.println("Searched for files in directory: " + path + " with query: " + query);
    }
}
