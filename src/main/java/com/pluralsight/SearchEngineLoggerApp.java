package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLoggerApp { public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // Log when the application launches
    loggingAction("launch");

    while (true) {

        System.out.print("Enter a search term (X or x to exit): ");
        String search = scanner.nextLine();

        if (search.equalsIgnoreCase("x")) {

            // Log when the application exits
            loggingAction("exit");
            break;

        } else {

            // Log the search term
            loggingAction("search : " + search);
        }
    }

    scanner.close();
}

    // Method to log user actions
    public static void loggingAction(String action) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String time = LocalDateTime.now().format(formatter);

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter("logs.txt", true))) {

            writer.write(time + " " + action);
            writer.newLine();

        } catch (IOException e) {
            System.out.println(
                    "Error writing to log file: " + e.getMessage());
        }
    }
}

