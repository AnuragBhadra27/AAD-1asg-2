package Day_1;
import java .util.*;
public class ASSIGNMENT1{
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    public static long calculateFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
    public static void findMaxMin(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
    public static void rotateArray(int[] array, int k) {
        k = k % array.length; // handle cases where k is greater than array length
        int[] rotatedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            rotatedArray[(i + k) % array.length] = array[i];
        }
        System.out.print("Rotated array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(rotatedArray[i] + " ");
        }
        System.out.println();
    }
    public static void findMaxContiguousSubarray(int[] array) {
        int maxSoFar = array[0];
        int maxEndingHere = array[0];
        int start = 0;
        int end = 0;
        int s = 0;
    
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxEndingHere + array[i]) {
                maxEndingHere = array[i];
                s = i;
            } else {
                maxEndingHere = maxEndingHere + array[i];
            }
    
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }
    
        System.out.print("Maximum contiguous subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void findSmallestMissingElement(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
    
        int smallestMissingElement = min;
        while (true) {
            boolean found = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == smallestMissingElement) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
            smallestMissingElement++;
        }
    
        System.out.println("Smallest missing element: " + smallestMissingElement);
    }
    public static void rearrangeArray(int[] array) {
        int[] rearrangedArray = new int[array.length];
        int maxIndex = array.length - 1;
        int minIndex = 0;
    
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                rearrangedArray[i] = array[maxIndex--];
            } else {
                rearrangedArray[i] = array[minIndex++];
            }
        }
    
        System.out.print("Rearranged array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(rearrangedArray[i] + " ");
        }
        System.out.println();
    }
    public static void mergeSortedArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
    
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }
    
        while (i < array1.length) {
            mergedArray[k++] = array1[i++];
        }
    
        while (j < array2.length) {
            mergedArray[k++] = array2[j++];
        }
    
        System.out.print("Merged array: ");
        for (int l = 0; l < mergedArray.length; l++) {
            System.out.print(mergedArray[l] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements (n): ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Choose an operation: \n1. Calculate Sum\n 2. Calculate Factorial\n3. Find Max and Min\n4. Rotate Array\n ");
        System.out.println("5.findMaxContiguousSubarray");
        System.out.println("6.findSmallestMissingElement");
        System.out.println("7.rearrangeArray");
        System.out.println("8.mergeSortedArrays");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                int sum = calculateSum(array);
                System.out.println("The sum of the array is: " + sum);
                break;
            case 2:
                System.out.print("Enter a number to calculate its factorial: ");
                int number = scanner.nextInt();
                long factorial = calculateFactorial(number);
                System.out.println("The factorial of " + number + " is: " + factorial);
                break;
            case 3:
                findMaxMin(array);
                break;
            case 4:
                System.out.print("Enter the number of positions to rotate the array: ");
                int k = scanner.nextInt();
                rotateArray(array, k);
                break;
                case 5:
                findMaxContiguousSubarray(array);
                break;
                case 6:
                findSmallestMissingElement(array);
                break;
            case 7:
                rearrangeArray(array);
                break;
            case 8:
                System.out.print("Enter the number of elements in the second array: ");
                int m = scanner.nextInt();
                int[] array2 = new int[m];
                System.out.println("Enter the elements of the second array:");
                for (int i = 0; i < m; i++) {
                    array2[i] = scanner.nextInt();
                }
                mergeSortedArrays(array, array2);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    }

  