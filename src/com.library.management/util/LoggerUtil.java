package com.library.management.util;

import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    // Info log
    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    // Warning log
    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    // Error log
    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }
}