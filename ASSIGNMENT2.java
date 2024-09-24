package Day_2;
import java.util.*;

public class ASSIGNMENT2{
    public static int sumArray(int[] array, int n) {
        if (n <= 0) {
            return 0;
        }
        return array[n - 1] + sumArray(array, n - 1);
    }

    public static int findMaxRec(int[] array, int n) {
        if (n == 1) {
            return array[0];
        }
        return Math.max(array[n - 1], findMaxRec(array, n - 1));
    }

    public static int findMinRec(int[] array, int n) {
        if (n == 1) {
            return array[0];
        }
        return Math.min(array[n - 1], findMinRec(array, n - 1));
    }

    public static int powerNum(int num, int power) {
        if (power == 0) {
            return 1;
        }
        return num * powerNum(num, power - 1);
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    public static String decimalToHexadecimal(int num) {
        if (num == 0) {
            return "0";
        }
        return decimalToHexadecimal(num / 16) + Integer.toHexString(num % 16);
    }
    public static int findMissingNumber(int[] arr, int n) {
        if (n == 0) {
            return 1;
        } else if (arr[n-1] != n) {
            return n; 
        } else {
            return findMissingNumber(arr, n-2); 
        }
    }
    

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your choice:");
    System.out.println("1. Sum of n numbers");
    System.out.println("2. Max and min of array");
    System.out.println("3. Nth power of a number");
    System.out.println("4. Factorial of a number");
    System.out.println("5. Generate the nth Fibonacci number");
    System.out.println("6. GCD of two numbers");
    System.out.println("7. Convert a decimal number to hexadecimal");
    System.out.println("8. Smaller positive missing number of 1 to n");
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            System.out.println("Enter the size of the array:");
            int n = scanner.nextInt();
            int[] array = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("Sum of the array: " + sumArray(array, n));
            break;
        case 2:
            System.out.println("Enter the size of the array:");
            n = scanner.nextInt();
            array = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int max = findMaxRec(array, n);
            int min = findMinRec(array, n);
            System.out.println("Max of the array: " + max);
            System.out.println("Min of the array: " + min);
            break;
        case 3:
            System.out.println("Enter a number:");
            int num = scanner.nextInt();
            System.out.println("Enter the power:");
            int power = scanner.nextInt();
            System.out.println("Nth power of the number: " + powerNum(num, power));
            break;
        case 4:
            System.out.println("Enter a number:");
            num = scanner.nextInt();
            System.out.println("Factorial of the number: " + factorial(num));
            break;
        case 5:
            System.out.println("Enter a number:");
            num = scanner.nextInt();
            System.out.println("Nth Fibonacci number: " + fibonacci(num));
            break;
        case 6:
            System.out.println("Enter two numbers:");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            System.out.println("GCD of the two numbers: " + gcd(num1, num2));
            break;
        case 7:
            System.out.println("Enter a decimal number:");
            num = scanner.nextInt();
            System.out.println("Hexadecimal representation: " + decimalToHexadecimal(num));
            break;
        case 8:
        System.out.print("Enter the size of the array (n): ");
        int number = scanner.nextInt();
        int[] arr = new int[ number-1]; // create an array of size n-1
        System.out.print("Enter the numbers (separated by spaces): ");
        for (int i = 0; i <  number-1; i++) {
            arr[i] = scanner.nextInt();
        }
        int missingNumber = findMissingNumber(arr,  number);
        System.out.println("The missing number is: " + missingNumber);
            break;
        default:
            System.out.println("Invalid choice");
    }
}
}


