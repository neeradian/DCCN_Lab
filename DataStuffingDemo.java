// Experiment No. 3
// Data Stuffing - Bit Stuffing and Character Stuffing

import java.util.Scanner;

public class DataStuffingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("\n=== Data Stuffing Techniques ===");
            System.out.println("1. Bit Stuffing");
            System.out.println("2. Character Stuffing");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bitStuffingDemo(scanner);
                    break;
                case 2:
                    characterStuffingDemo(scanner);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void bitStuffingDemo(Scanner scanner) {
        System.out.println("\n=== Bit Stuffing ===");
        System.out.print("Enter a bit stream (e.g., 1110011111010): ");
        String data = scanner.nextLine();

        // Validate input contains only 0s and 1s
        if (!data.matches("[01]+")) {
            System.out.println("Error: Input must contain only 0s and 1s.");
            return;
        }

        String stuffedData = bitStuffing(data);
        String unstuffedData = bitUnstuffing(stuffedData);

        System.out.println("Original data: " + data);
        System.out.println("After bit stuffing: " + stuffedData);
        System.out.println("After bit unstuffing: " + unstuffedData);
        System.out.println("Data integrity check: " + (data.equals(unstuffedData) ? "Passed" : "Failed"));
    }

    private static String bitStuffing(String data) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            result.append(bit);

            if (bit == '1') {
                count++;
                if (count == 5) {
                    result.append('0'); // Insert a 0 after five consecutive 1s
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return result.toString();
    }

    private static String bitUnstuffing(String stuffedData) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < stuffedData.length(); i++) {
            char bit = stuffedData.charAt(i);

            if (bit == '1') {
                result.append(bit);
                count++;
            } else {
                if (count == 5 && i < stuffedData.length() - 1) {
                    // Skip this 0 as it was added during stuffing
                    count = 0;
                } else {
                    result.append(bit);
                    count = 0;
                }
            }
        }
        return result.toString();
    }

    private static void characterStuffingDemo(Scanner scanner) {
        System.out.println("\n=== Character Stuffing ===");
        System.out.print("Enter a text message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the flag character (e.g., ~): ");
        char flag = scanner.nextLine().charAt(0);

        System.out.print("Enter the escape character (e.g., \\'): ");
        char escape = scanner.nextLine().charAt(0);

        String stuffedMessage = characterStuffing(message, flag, escape);
        String unstuffedMessage = characterUnstuffing(stuffedMessage, flag, escape);

        System.out.println("Original message: " + message);
        System.out.println("After character stuffing: " + stuffedMessage);
        System.out.println("After character unstuffing: " + unstuffedMessage);
        System.out.println("Data integrity check: " + (message.equals(unstuffedMessage) ? "Passed" : "Failed"));
    }

    private static String characterStuffing(String message, char flag, char escape) {
        StringBuilder result = new StringBuilder();
        result.append(flag); // Start flag

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (ch == flag || ch == escape) {
                result.append(escape); // Escape character before special character
            }
            result.append(ch);
        }
        result.append(flag); // End flag
        return result.toString();
    }

    private static String characterUnstuffing(String stuffedMessage, char flag, char escape) {
        if (stuffedMessage.length() < 2) {
            return "";
        }

        // Remove the flags at the beginning and end
        String content = stuffedMessage.substring(1, stuffedMessage.length() - 1);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < content.length(); i++) {
            char ch = content.charAt(i);

            if (ch == escape && i < content.length() - 1) {
                // Skip the escape character and add the next character directly
                result.append(content.charAt(++i));
            } else if (ch != flag) {
                result.append(ch);
            }
        }
        return result.toString();
    }

}
