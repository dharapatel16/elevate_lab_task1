package elevate_lab_internship;

import java.util.Scanner;

public class calculator {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by zero");
            return Double.NaN;
        }
        return num1 / num2;
    }

    public static void displayMenu() {
        System.out.println("\n------ CALCULATOR MENU ------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
        System.out.print("Choose an operation: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Welcome to Java Console Calculator!");

        while (continueCalculating) {
            displayMenu();

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number from 1 to 5: ");
                scanner.next();
            }
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for using the calculator.");
                break;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please select 1-5.");
                continue;
            }

            System.out.print("Enter first number: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            double num2 = scanner.nextDouble();

            double result = 0;
            String operation = "";

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    operation = "+";
                    break;
                case 2:
                    result = subtract(num1, num2);
                    operation = "-";
                    break;
                case 3:
                    result = multiply(num1, num2);
                    operation = "*";
                    break;
                case 4:
                    result = divide(num1, num2);
                    operation = "/";
                    if (Double.isNaN(result)) {
                        continue;  
                    }
                    break;
            }

            System.out.printf("Result: %.2f %s %.2f = %.2f\n", num1, operation, num2, result);

            System.out.print("Do you want to perform another calculation? (y/n): ");
            String continueChoice = scanner.next();

            if (continueChoice.toLowerCase().charAt(0) != 'y') {
                System.out.println("Thank you for using the calculator..");
                continueCalculating = false;
            }
        }

        scanner.close();
    }
}
