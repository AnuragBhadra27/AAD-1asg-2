package Day_3;
import java.util.*;
public class ASSIGNMENT3 {
    public static void bubbleSortIterative(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort (Recursive)
    public static void bubbleSortRecursive(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Swap arr[i] and arr[i + 1]
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSortRecursive(arr, n - 1);
    }

    // Insertion Sort (Iterative)
    public static void insertionSortIterative(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Insertion Sort (Recursive)
    public static void insertionSortRecursive(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        insertionSortRecursive(arr, n - 1);
        int key = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }

    // Selection Sort (Iterative)
    public static void selectionSortIterative(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // Selection Sort (Recursive)
    public static void selectionSortRecursive(int[] arr, int n) {
        if (n == 1) {
            return;
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        // Swap arr[0] and arr[minIndex]
        int temp = arr[0];
        arr[0] = arr[minIndex];
        arr[minIndex] = temp;
        selectionSortRecursive(arr, n - 1);
    }

    // Custom Sort for the new array
    public static void customSort(int[] arr) {
        int[] count = new int[5];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int index = 0;
        for (int i = 2; i <= 4; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 5, 3};
        int[] newArr = {2, 4, 3, 3, 3, 4, 2, 4, 4};

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("New Array: " + Arrays.toString(newArr));

        System.out.println("Choose a sorting method:");
        System.out.println ("1. Bubble Sort (Iterative)");
        System.out.println("2. Bubble Sort (Recursive)");
        System.out.println("3. Insertion Sort (Iterative)");
        System.out.println("4. Insertion Sort (Recursive)");
        System.out.println("5. Selection Sort (Iterative)");
        System.out.println("6. Selection Sort (Recursive)");
        System.out.println("7. Custom Sort");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bubbleSortIterative(arr);
                System.out.println("Sorted Array: " + Arrays.toString(arr));
                break;
            case 2:
                bubbleSortRecursive(arr, arr.length);
                System.out.println("Sorted Array: " + Arrays.toString(arr));
                break;
            case 3:
                insertionSortIterative(arr);
                System.out.println("Sorted Array: " + Arrays.toString(arr));
                break;
            case 4:
                insertionSortRecursive(arr, arr.length);
                System.out.println("Sorted Array: " + Arrays.toString(arr));
                break;
            case 5:
                selectionSortIterative(arr);
                System.out.println("Sorted Array: " + Arrays.toString(arr));
                break;
            case 6:
                selectionSortRecursive(arr, arr.length);
                System.out.println("Sorted Array: " + Arrays.toString(arr));
                break;
            case 7:
                customSort(newArr);
                System.out.println("Sorted New Array: " + Arrays.toString(newArr));
                break;
            default:
                System.out.println("Invalid choice");
        }

        
        
    }
}