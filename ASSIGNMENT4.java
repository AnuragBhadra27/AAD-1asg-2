package Day_4;

import java.util.*;

public class ASSIGNMENT4 {

    // 1. Reduction Operation
    public static void reductionOperation(int[] arr) {
        while (arr.length > 1) {
            int min = Arrays.stream(arr).min().getAsInt();
            arr = Arrays.stream(arr).map(x -> x - min).filter(x -> x > 0).toArray();
        }
        System.out.println("Final element after reduction: " + (arr.length == 1 ? arr[0] : "No elements left"));
    }

    // 2. Union and Intersection of two arrays
    public static void unionAndIntersection(int[] arr1, int[] arr2) {
        Set<Integer> unionSet = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        for (int num : arr1) {
            unionSet.add(num);
        }
        for (int num : arr2) {
            unionSet.add(num);
            if (Arrays.stream(arr1).anyMatch(x -> x == num)) {
                intersectionSet.add(num);
            }
        }

        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
    }

    // 3. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sorted Array: " + Arrays.toString(arr));
    }

    // 4. Insertion Sort
    public static void insertionSort(int[] arr) {
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
        System.out.println("Insertion Sorted Array: " + Arrays.toString(arr));
    }

    // 5. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Selection Sorted Array: " + Arrays.toString(arr));
    }

    // 6. Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        System.out.println("Heap Sorted Array: " + Arrays.toString(arr));
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // 7. Check if reversing a sub-array can sort the array
    public static void checkReversal(int[] arr) {
        int n = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                reverseSubArray(arr, i, j);
                if (Arrays.equals(arr, sortedArr)) {
                    System.out.println("Yes, reversing a sub-array can sort the array.");
                    return;
                }
                reverseSubArray(arr, i, j); // Restore original array
            }
        }
        System.out.println("No, reversing a sub-array cannot sort the array.");
    }

    private static void reverseSubArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an operation:");
        System.out.println("1. Reduction Operation");
        System.out.println("2. Union and Intersection of two arrays");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Insertion Sort");
        System.out.println("5. Selection Sort");
        System.out.println("6. Heap Sort");
        System.out.println("7. Check if reversing a sub-array can sort the array");
        int choice = scanner.nextInt();

        int[] arr1 = {5, 2, 8, 1, 3};
        int[] arr2 = {7, 2, 9, 1, 4};

        switch (choice) {
            case 1:
                reductionOperation(arr1);
                break;
            case 2:
                unionAndIntersection(arr1, arr2);
                break;
            case 3:
                int[] bubbleArr = {64, 34, 25, 12, 22, 11, 90};
                bubbleSort(bubbleArr);
                break;
            case 4:
                int[] insertionArr = {64, 34, 25, 12, 22, 11, 90};
                insertionSort(insertionArr);
                break;
            case 5:
                int[] selectionArr = {64, 34, 25, 12, 22, 11, 90};
                selectionSort(selectionArr);
                break;
            case 6:
                int[] heapArr = {64, 34, 25, 12, 22, 11, 90};
                heapSort(heapArr);
                break;
            case 7:
                int[] reversalArr = {1, 2, 3, 4, 5};
                checkReversal(reversalArr);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}