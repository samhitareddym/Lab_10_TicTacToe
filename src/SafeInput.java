import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                pipe.nextLine();  // clear the input buffer
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.nextLine();  // clear the input buffer
            }
        } while (!valid);

        return retValue;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retValue = 0.0;
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine();  // clear the input buffer
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.nextLine();  // clear the input buffer
            }
        } while (!valid);

        return retValue;
    }

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int retValue = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (console.hasNextInt()) {
                retValue = console.nextInt();
                console.nextLine();  // clear the input buffer
                if (retValue >= low && retValue <= high) {
                    valid = true;
                } else {
                    System.out.println("Input is out of range. Please enter an integer between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                console.nextLine();  // clear the input buffer
            }
        } while (!valid);

        return retValue;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0.0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                pipe.nextLine();  // clear the input buffer
                if (retValue >= low && retValue <= high) {
                    valid = true;
                } else {
                    System.out.println("Input is out of range. Please enter a decimal no. between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.nextLine();  // clear the input buffer
            }
        } while (!valid);

        return retValue;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String response;
        boolean valid = false;
        boolean result = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = console.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                valid = true;
                result = true;
            } else if (response.equalsIgnoreCase("N")) {
                valid = true;
                result = false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);

        return result;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please match the pattern: " + regEx);
            }
        } while (!valid);

        return response;
    }

    public static void prettyHeader(String msg) {
        final int totalWidth = 60; // Total width of the header
        final int starsPadding = 3; // Number of stars on either side of the message

        // Calculate the total width of the message with stars included
        int msgWidth = msg.length() + starsPadding * 2 + 3; // 3 stars at the end

        // Calculate the number of spaces needed to center the message
        int leftPadding = (totalWidth - msgWidth) / 2;

        // Print the top border
        System.out.println("*".repeat(totalWidth));

        // Print the centered message with stars
        System.out.print("*** " + msg + " ***"); // Print the message with stars
        System.out.println();

        // Print the bottom border
        System.out.println("*".repeat(totalWidth));

    }

        // Method to convert Celsius to Fahrenheit
        public static double CtoF(double Celsius) {
            return (Celsius * 9 / 5) + 32; // Conversion formula
        }
    }









