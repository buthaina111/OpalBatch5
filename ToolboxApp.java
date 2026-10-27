
import java.util.Scanner;

public class ToolboxApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            choice = readInt("Please enter a number between 0 and 9: ");

            switch (choice) {
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    evenOrOdd();
                    break;
                case 3:
                    maxOfThree();
                    break;
                case 4:
                    factorial();
                    break;
                case 5:
                    multiplicationTable();
                    break;
                case 6:
                    starTriangle();
                    break;
                case 7:
                    isPrime();
                    break;
                case 8:
                    reverseNumber();
                    break;
                case 9:
                    numberPyramid();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
            }

        } while (choice != 0);

        input.close();
    }

    // Display menu
    public static void menu() {
        System.out.println("\n===== Toolbox Menu =====");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or Odd");
        System.out.println("3. Maximum of Three Numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication Table");
        System.out.println("6. Star Triangle");
        System.out.println("7. Prime Number");
        System.out.println("8. Reverse Number");
        System.out.println("9. Number Pyramid");
        System.out.println("0. Exit");
    }

    // Read an integer
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                input.next();
            }
        }
    }

    // Read a decimal number
    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextDouble()) {
                return input.nextDouble();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }
    }

    // 1. Celsius to Fahrenheit
    public static void celsiusToFahrenheit() {
        double celsius = readDouble("Enter temperature in Celsius: ");
        double fahrenheit = celsius * 9 / 5 + 32;

        System.out.println("Fahrenheit = " + fahrenheit);
    }

    // 2. Even or Odd
    public static void evenOrOdd() {
        int number = readInt("Enter an integer: ");

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    // 3. Maximum of Three Numbers
    public static void maxOfThree() {
        int a = readInt("Enter the first number: ");
        int b = readInt("Enter the second number: ");
        int c = readInt("Enter the third number: ");

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("Maximum = " + max);
    }

    // 4. Factorial
    public static void factorial() {
        int number = readInt("Enter a non-negative number (0 to 15): ");

        if (number < 0 || number > 15) {
            System.out.println("Invalid number. Enter a number from 0 to 15.");
            return;
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        System.out.println(number + "! = " + result);
    }

    // 5. Multiplication Table
    public static void multiplicationTable() {
        int number = readInt("Enter a number: ");

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    // 6. Star Triangle
    public static void starTriangle() {
        int rows = readInt("Enter number of rows: ");

        if (rows < 1) {
            System.out.println("Please enter a positive number of rows.");
            return;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 7. Prime Number
    public static void isPrime() {
        int number = readInt("Enter an integer greater than 1: ");

        if (number <= 1) {
            System.out.println("Please enter a number greater than 1.");
            return;
        }

        boolean prime = true;

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }

    // 8. Reverse a Number
    public static void reverseNumber() {
        int number = readInt("Enter a positive integer: ");

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Reversed number = " + reversed);
    }

    // 9. Number Pyramid
    public static void numberPyramid() {
        int rows = readInt("Enter number of rows: ");

        if (rows < 1) {
            System.out.println("Please enter a positive number of rows.");
            return;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
