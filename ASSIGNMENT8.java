package Day_8;
import java.util.*;
public class ASSIGNMENT8 {
    
        // Q1: Stack implementation using Java Collections
        static class CustomStack {
            private Stack<Integer> stack;
    
            public CustomStack() {
                stack = new Stack<>();
            }
    
            public void push(int value) {
                stack.push(value);
            }
    
            public int pop() {
                return stack.pop();
            }
    
            public boolean isEmpty() {
                return stack.isEmpty();
            }
    
            public void printStack() {
                System.out.println("Stack: " + stack);
            }
        }
    
        // Q2: Stack implementation using push, pop, isEmpty
        public static void stackOperations() {
            CustomStack customStack = new CustomStack();
            customStack.push(10);
            customStack.push(20);
            customStack.push(30);
            customStack.printStack();
    
            System.out.println("Popped: " + customStack.pop());
            customStack.printStack();
            System.out.println("Is stack empty? " + customStack.isEmpty());
        }
    
        // Q3: Insert an element into a sorted stack
        public static void insertSorted(Stack<Integer> stack, int value) {
            if (stack.isEmpty() || value > stack.peek()) {
                stack.push(value);
                return;
            }
            int temp = stack.pop();
            insertSorted(stack, value);
            stack.push(temp);
        }
    
        public static void sortedStackInsertion() {
            Stack<Integer> sortedStack = new Stack<>();
            sortedStack.push(30);
            sortedStack.push(20);
            sortedStack.push(10); // Stack is now sorted: 10 at the top
    
            System.out.println("Original sorted stack: " + sortedStack);
            int newValue = 25;
            insertSorted(sortedStack, newValue);
            System.out.println("Stack after inserting " + newValue + ": " + sortedStack);
        }
    
        // Q4: Insert an element at the bottom of the stack
        public static void insertAtBottom(Stack<Integer> stack, int value) {
            if (stack.isEmpty()) {
                stack.push(value);
                return;
            }
            int temp = stack.pop();
            insertAtBottom(stack, value);
            stack.push(temp);
        }
    
        public static void insertBottomStack() {
            Stack<Integer> stack = new Stack<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            System.out.println("Original stack: " + stack);
            int valueToInsert = 5;
            insertAtBottom(stack, valueToInsert);
            System.out.println("Stack after inserting " + valueToInsert + " at the bottom: " + stack);
        }
    
        // Q5: Reverse stack elements
        public static void reverseStack(Stack<Integer> stack) {
            if (stack.isEmpty()) {
                return;
            }
            int temp = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, temp);
        }
    
        public static void reverseStackElements() {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println("Original stack: " + stack);
            reverseStack(stack);
            System.out.println("Reversed stack: " + stack);
        }
    
        // Q6: Celebrity problem
        public static int findCelebrity(int[][] matrix) {
            Stack<Integer> stack = new Stack<>();
            int n = matrix.length;
    
            // Step 1: Push all people onto the stack
            for (int i = 0; i < n; i++) {
                stack.push(i);
            }
    
            // Step 2: Find the potential celebrity
            while (stack.size() > 1) {
                int a = stack.pop();
                int b = stack.pop();
                if (matrix[a][b] == 1) {
                    // a knows b, so a cannot be a celebrity
                    stack.push(b);
                } else {
                    // a does not know b, so b cannot be a celebrity
                    stack.push(a);
                }
            }
    
            // Step 3: Verify the potential celebrity
            int candidate = stack.pop();
            for (int i = 0; i < n; i++) {
                if (i != candidate && (matrix[candidate][i] == 1 || matrix[i][candidate] == 0)) {
                    return -1; // No celebrity found
                }
            }
            return candidate; // Celebrity found
        }
    
        public static void celebrityProblem() {
            int[][] partyMatrix = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 0}
     };
            int celebrity = findCelebrity(partyMatrix);
            if (celebrity != -1) {
                System.out.println("Celebrity found at index: " + celebrity);
            } else {
                System.out.println("No celebrity found.");
            }
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;
    
            do {
                System.out.println("Select an option:");
                System.out.println("1. Stack Operations");
                System.out.println("2. Sorted Stack Insertion");
                System.out.println("3. Insert at Bottom of Stack");
                System.out.println("4. Reverse Stack Elements");
                System.out.println("5. Celebrity Problem");
                System.out.println("0. Exit");
                choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        stackOperations();
                        break;
                    case 2:
                        sortedStackInsertion();
                        break;
                    case 3:
                        insertBottomStack();
                        break;
                    case 4:
                        reverseStackElements();
                        break;
                    case 5:
                        celebrityProblem();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
    
            scanner.close();
        }
    }

