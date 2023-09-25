
import java.util.Scanner;

public class ScientificCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Square Root (√)");
            System.out.println("6. Sine (sin)");
            System.out.println("7. Cosine (cos)");
            System.out.println("8. Tangent (tan)");
            System.out.println("9. Exit");

            System.out.print("Select an option (1-9): ");
            int choice = scanner.nextInt();

            if (choice == 9) {
                System.out.println("Exiting the calculator.");
                break;
            }

            double result = 0.0;

            switch (choice) {
                case 1:
                    result = performAddition(scanner);
                    break;
                case 2:
                    result = performSubtraction(scanner);
                    break;
                case 3:
                    result = performMultiplication(scanner);
                    break;
                case 4:
                    result = performDivision(scanner);
                    break;
                case 5:
                    result = performSquareRoot(scanner);
                    break;
                case 6:
                    result = performSine(scanner);
                    break;
                case 7:
                    result = performCosine(scanner);
                    break;
                case 8:
                    result = performTangent(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    private static double performAddition(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 + num2;
    }

    private static double performSubtraction(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 - num2;
    }

    private static double performMultiplication(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        return num1 * num2;
    }

    private static double performDivision(Scanner scanner) {
        System.out.print("Enter the numerator: ");
        double numerator = scanner.nextDouble();
        System.out.print("Enter the denominator: ");
        double denominator = scanner.nextDouble();

        if (denominator == 0) {
            System.out.println("Division by zero is not allowed.");
            return Double.NaN; // Not-a-Number
        }

        return numerator / denominator;
    }

    private static double performSquareRoot(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        if (num < 0) {
            System.out.println("Square root of a negative number is not real.");
            return Double.NaN;
        }
        return Math.sqrt(num);
    }

    private static double performSine(Scanner scanner) {
        System.out.print("Enter an angle in degrees: ");
        double angle = scanner.nextDouble();
        return Math.sin(Math.toRadians(angle));
    }

    private static double performCosine(Scanner scanner) {
        System.out.print("Enter an angle in degrees: ");
        double angle = scanner.nextDouble();
        return Math.cos(Math.toRadians(angle));
    }

    private static double performTangent(Scanner scanner) {
        System.out.print("Enter an angle in degrees: ");
        double angle = scanner.nextDouble();
        return Math.tan(Math.toRadians(angle));
    }
}

