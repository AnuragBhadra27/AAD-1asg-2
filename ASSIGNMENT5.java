package day5;
import java.util.Scanner;
public class ASSIGNMENT5 {

	    // Iterative Linear Search
	   public static int linearSearchIterative(int[] arr, int target) {
                int comparisons = 0; // Initialize comparison counter
                for (int i = 0; i < arr.length; i++) {
                    comparisons++; // Increment counter for each comparison
                    if (arr[i] == target) {
                        System.out.println("Comparisons: " + comparisons);
                        return i; // Return the index
                    }
                }
                System.out.println("Comparisons: " + comparisons);
                return -1; // Element not found
            }
    
	    public static int linearSearchRecursive(int[] arr, int target, int index, int comparisons) {
                if (index >= arr.length) {
                    System.out.println("Comparisons: " + comparisons);
                    return -1; // Element not found
                }
                comparisons++; // Increment counter for each comparison
                if (arr[index] == target) {
                    System.out.println("Comparisons: " + comparisons);
                    return index; // Return the index
                }
                return linearSearchRecursive(arr, target, index + 1, comparisons); // Recur for next index
            }

	    // Iterative Binary Search
	    public static int binarySearchIterative(int[] arr, int target) {
                int left = 0;
                int right = arr.length - 1;
                int comparisons = 0; // Initialize comparison counter
                
                while (left <= right) {
                    comparisons++; // Increment counter for each comparison
                    int mid = left + (right - left) / 2;
                    
                    if (arr[mid] == target) {
                        System.out.println("Comparisons: " + comparisons);
                        return mid; // Return the index
                    }
                    if (arr[mid] < target) {
                        left = mid + 1; // Search in the right half
                    } else {
                        right = mid - 1; // Search in the left half
                    }
                }
                System.out.println("Comparisons: " + comparisons);
                return -1; // Element not found
            }

	    // Recursive Binary Search
	   public static int binarySearchRecursive(int[] arr, int target, int left, int right, int comparisons) {
                if (left > right) {
                    System.out.println("Comparisons: " + comparisons);
                    return -1; // Element not found
                }
                
                comparisons++; // Increment counter for each comparison
                int mid = left + (right - left) / 2;
                
                if (arr[mid] == target) {
                    System.out.println("Comparisons: " + comparisons);
                    return mid; // Return the index
                }
                if (arr[mid] < target) {
                    return binarySearchRecursive(arr, target, mid + 1, right, comparisons); // Search in the right half
                } else {
                    return binarySearchRecursive(arr, target, left, mid - 1, comparisons); // Search in the left half
                }
            }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        // Sample array (must be sorted for binary search)
	        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
	        
	        System.out.println("Choose search method:");
	        System.out.println("1. Linear Search (Iterative)");
	        System.out.println("2. Linear Search (Recursive)");
	        System.out.println("3. Binary Search (Iterative)");
	        System.out.println("4. Binary Search (Recursive)");
	        
	        int choice = scanner.nextInt();
	        System.out.print("Enter the element to search: ");
	        int target = scanner.nextInt();
	        
	        int result = -1;
	        switch (choice) {
	            case 1:
	                result = linearSearchIterative(arr, target);
	                break;
	            case 2:
	                result = linearSearchRecursive(arr, target, 0 , result);
	                break;
	            case 3:
	                result = binarySearchIterative(arr, target);
	                break;
	            case 4:
	                result = binarySearchRecursive(arr, target, 0, arr.length - 1, result);
	                break;
	            default:
	                System.out.println("Invalid choice");
	                break;
	        }
	        
	        if (result != -1) {
	            System.out.println("Element found at index: " + result);
	        } else {
	            System.out.println("Element not found in the array.");
	        }

	        scanner.close();
	    }
	}

