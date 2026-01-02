/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package BufferReader.Chapter1_Challenge_1_4;

/**
 *
 * @author du
 */
//public class Chapter1_Challenge_1_4 {
import java.io.*;

public class Chapter1_Challenge_1_4{

    // Custom Exception Class
    static class InvalidConfigVersionException extends Exception {
        public InvalidConfigVersionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        String configFilePath = "config.txt"; // Default config file path

        // Allow optional command-line argument for config file path
        if (args.length > 0) {
            configFilePath = args[0];
        }

        // Use try-with-resources to automatically close the reader
       try (BufferedReader reader = new BufferedReader(new FileReader(configFilePath))) {

            // Read and parse config version
            String versionLine = reader.readLine();
            if (versionLine == null || versionLine.isEmpty()) {
                throw new IOException("Config version line is missing or empty.");
            }
            int configVersion = Integer.parseInt(versionLine.trim());

            // Validate config version
            if (configVersion < 2) {
                throw new InvalidConfigVersionException("Config version too old!");
            }

            // Read and validate file path
            String filePath = reader.readLine();
            if (filePath == null || filePath.trim().isEmpty()) {
                throw new IOException("File path line is missing or empty.");
            }

            File file = new File(filePath.trim());
            if (!file.exists()) {
                throw new FileNotFoundException("File at config path does not exist: " + filePath);
            }

            System.out.println("Config file read successfully.");
            System.out.println("Version: " + configVersion);
            System.out.println("File path: " + file.getAbsolutePath());

        } catch (FileNotFoundException e) {
            System.out.println("Error: Config file not found or file at path does not exist.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Config version is not a valid number.");
        } catch (InvalidConfigVersionException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: I/O issue occurred - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
        }
    }
}