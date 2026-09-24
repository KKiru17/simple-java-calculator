import java.util.Scanner;

public class Calculator {

    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public static double divide(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }

    // Format result without unnecessary .0
    public static String formatResult(double result) {

        if (result == (long) result) {
            return String.format("%d", (long) result);
        }

        return String.valueOf(result);
    }

    // Check whether menu choice is valid
    public static boolean isValidChoice(String input) {

        // Only one digit from 1 to 5 is allowed
        return input.matches("[1-5]");
    }

    // Check whether number is valid
    public static boolean isValidNumber(String input) {

        /*
         * Accepted:
         * 10
         * -10
         * 10.5
         * -10.5
         *
         * Rejected:
         * 10 5
         * 10@
         * abc
         * 10+5
         * 5/2
         */
        return input.matches("-?(\\d+(\\.\\d+)?)");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("        SIMPLE JAVA CALCULATOR");
        System.out.println("                 v1.1");
        System.out.println("======================================");

        while (true) {

            System.out.println();
            System.out.println("Select an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine();

            // Reject spaces, letters, symbols, -1, 0, 6, etc.
            if (!isValidChoice(choice)) {

                System.out.println(
                        "Invalid choice. Please enter only 1, 2, 3, 4 or 5."
                );

                continue;
            }

            // Exit
            if (choice.equals("5")) {

                System.out.println();
                System.out.println("Calculator closed.");
                break;
            }

            // First number
            System.out.print("Enter first number: ");

            String firstInput = scanner.nextLine();

            if (!isValidNumber(firstInput)) {

                System.out.println(
                        "Invalid number. Please enter numbers only."
                );

                continue;
            }

            // Second number
            System.out.print("Enter second number: ");

            String secondInput = scanner.nextLine();

            if (!isValidNumber(secondInput)) {

                System.out.println(
                        "Invalid number. Please enter numbers only."
                );

                continue;
            }

            double num1 = Double.parseDouble(firstInput);
            double num2 = Double.parseDouble(secondInput);

            try {

                double result;

                switch (choice) {

                    case "1":
                        result = add(num1, num2);
                        break;

                    case "2":
                        result = subtract(num1, num2);
                        break;

                    case "3":
                        result = multiply(num1, num2);
                        break;

                    case "4":
                        result = divide(num1, num2);
                        break;

                    default:
                        continue;
                }

                System.out.println(
                        "Result: " + formatResult(result)
                );

            } catch (ArithmeticException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}