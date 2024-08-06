package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;

public class Logger {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    static {
        try {
            // Define the path for the log directory and file
            Path logDir = Paths.get("src", "main", "resources", "log");
            Path logFile = logDir.resolve("file-manager.log");

            // Ensure the log directory exists
            if (!Files.exists(logDir)) {
                Files.createDirectories(logDir);
            }

            // Create a FileHandler to log messages to a .log file
            FileHandler fileHandler = new FileHandler(logFile.toString(), true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);

            // Remove the default console handler
            java.util.logging.Logger rootLogger = java.util.logging.Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers.length > 0 && handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }

            // Add the file handler to the logger
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            // Log initialization success
            logger.info("Logger initialized successfully.");

        } catch (IOException e) {
            System.err.println("Error initializing logger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void log(Level level, String message) {
        logger.log(level, message);
    }
}
