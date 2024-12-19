package Day_6;


import java.util.*;

public class ASSIGNMENT6 {
    
    // Q1: Given an array of n elements such that their sum is equal to some given value
    public static void findPairsWithSum(int[] arr, int targetSum) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
            }
            seen.add(num);
        }
    }

    // Q2: Given two int arrays X and Y, find pairs (Xi, Yi) where Xi belongs to X and Yi belongs to Y such that Xi + Yi = some value
    public static void findPairsFromArrays(int[] X, int[] Y, int targetSum) {
        Set<Integer> seen = new HashSet<>();
        for (int y : Y) {
            seen.add(targetSum - y);
        }
        for (int x : X) {
            if (seen.contains(x)) {
                System.out.println("Pair found: (" + x + ", " + (targetSum - x) + ")");
            }
        }
    }

    // Q3: Given an array of positive integers and a value, find a pair whose sum is closest to the given number
    public static void findClosestPair(int[] arr1, int[] arr2, int target) {
        int closestSum = Integer.MAX_VALUE;
        int closestX = 0, closestY = 0;
        
        for (int x : arr1) {
            for (int y : arr2) {
                int sum = x + y;
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                    closestX = x;
                    closestY = y;
                }
            }
        }
        System.out.println("Closest pair found: (" + closestX + ", " + closestY + ") with sum: " + closestSum);
    }

    // Q4: Given an array of elements, find the majority element which appears more than n/2 times
    public static void findMajorityElement(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = arr.length;
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > n / 2) {
                System.out.println("Majority element found: " + num);
                return;
            }
        }
        System.out.println("No majority element found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Find pairs with a given sum in an array");
            System.out.println("2. Find pairs from two arrays with a given sum");
            System.out.println("3. Find closest pair from two arrays");
            System.out.println("4. Find majority element in an array");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter array size:");
                    int n1 = scanner.nextInt();
                    int[] arr1 = new int[n1];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < n1; i++) {
                        arr1[i] = scanner.nextInt();
                    }
                    System.out.println("Enter target sum:");
                    int targetSum1 = scanner.nextInt();
                    findPairsWithSum(arr1, targetSum1);
                    break;

                case 2:
                    System.out.println("Enter size of array X:");
                    int n2 = scanner.nextInt();
                    int[] X = new int[n2];
                    System.out.println("Enter elements of array X:");
                    for (int i = 0; i < n2; i++) {
                        X[i] = scanner.nextInt();
                    }
                    System.out.println("Enter size of array Y:");
                    int n3 = scanner.nextInt();
                    int[] Y = new int[n3];
                    System.out.println("Enter elements of array Y:");
                    for (int i = 0; i < n3; i++) {
                        Y[i] = scanner.nextInt();
                    }
                    System.out.println("Enter target sum:");
                    int targetSum2 = scanner.nextInt();
                    findPairsFromArrays(X, Y, targetSum2);
                    break;

                case 3:
                    System.out.println("Enter size of first array:");
                    int n4 = scanner .nextInt();
                    int[] arr2 = new int[n4];
                    System.out.println("Enter elements of the first array:");
                    for (int i = 0; i < n4; i++) {
                        arr2[i] = scanner.nextInt();
                    }
                    System.out.println("Enter size of second array:");
                    int n5 = scanner.nextInt();
                    int[] arr3 = new int[n5];
                    System.out.println("Enter elements of the second array:");
                    for (int i = 0; i < n5; i++) {
                        arr3[i] = scanner.nextInt();
                    }
                    System.out.println("Enter target value:");
                    int targetValue = scanner.nextInt();
                    findClosestPair(arr2, arr3, targetValue);
                    break;

                case 4:
                    System.out.println("Enter size of the array:");
                    int n6 = scanner.nextInt();
                    int[] arr4 = new int[n6];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < n6; i++) {
                        arr4[i] = scanner.nextInt();
                    }
                    findMajorityElement(arr4);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

