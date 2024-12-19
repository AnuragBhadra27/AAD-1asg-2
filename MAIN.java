import java.util.Scanner;

public class MAIN {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList {
        Node head;

        // Method to insert a node at the beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        // Method to insert a node at the end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
            }
        }

        // Method to insert a node at a specific position
        public void insertAtPosition(int data, int position) {
            if (position == 0) {
                insertAtBeginning(data);
                return;
            }

            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
        }

        // Method to delete the first node
        public void deleteAtBeginning() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }

        // Method to delete the last node
        public void deleteAtEnd() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
        }

        // Method to delete a node at a specific position
        public void deleteAtPosition(int position) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (position == 0) {
                deleteAtBeginning();
                return;
            }
            Node temp = head;
            for (int i = 0; i < position && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position out of bounds");
                return;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }

        // Method to create a polynomial represented by the linked list
        public static DoublyLinkedList createPolynomial(int[] coefficients) {
            DoublyLinkedList polynomial = new DoublyLinkedList();
            for (int coefficient : coefficients) {
                polynomial.insertAtEnd(coefficient);
            }
            return polynomial;
        }

        // Method to add two polynomials
        public static DoublyLinkedList addPolynomials(DoublyLinkedList poly1, DoublyLinkedList poly2) {
            DoublyLinkedList result = new DoublyLinkedList();
            Node p1 = poly1.head;
            Node p2 = poly2.head;

            while (p1 != null || p2 != null) {
                int sum = 0;
                if (p1 != null) {
                    sum += p1.data; 
                    p1 = p1.next;
                }
                if (p2 != null) {
                    sum += p2.data; 
                    p2 = p2.next;
                }
                result.insertAtEnd(sum);
            }
            return result;
        }

        // Method to display the list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Method to represent the linked list as a graph
        public void graphRepresentation() {
            Node temp = head;
            while (temp != null) {
                System.out.print ("Node: " + temp.data);
                if (temp.prev != null) {
                    System.out.print(", Prev: " + temp.prev.data);
                } else {
                    System.out.print(", Prev: null");
                }
                if (temp.next != null) {
                    System.out.print(", Next: " + temp.next.data);
                } else {
                    System.out.print(", Next: null");
                }
                System.out.println();
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Insert Node");
            System.out.println("2. Delete Node");
            System.out.println("3. Create and Add Polynomials");
            System.out.println("4. Graph Representation of Linked List");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Insert Node:");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At End");
                    System.out.println("3. At Position");
                    int insertChoice = scanner.nextInt();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    if (insertChoice == 1) {
                        list.insertAtBeginning(value);
                    } else if (insertChoice == 2) {
                        list.insertAtEnd(value);
                    } else if (insertChoice == 3) {
                        System.out.print("Enter position: ");
                        int position = scanner.nextInt();
                        list.insertAtPosition(value, position);
                    }
                    break;

                case 2:
                    System.out.println("Delete Node:");
                    System.out.println("1. At Beginning");
                    System.out.println("2. At End");
                    System.out.println("3. At Position");
                    int deleteChoice = scanner.nextInt();
                    if (deleteChoice == 1) {
                        list.deleteAtBeginning();
                    } else if (deleteChoice == 2) {
                        list.deleteAtEnd();
                    } else if (deleteChoice == 3) {
                        System.out.print("Enter position: ");
                        int position = scanner.nextInt();
                        list.deleteAtPosition(position);
                    }
                    break;

                case 3:
                    System.out.print("Enter coefficients for first polynomial (space-separated): ");
                    int[] poly1Coefficients = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
                    DoublyLinkedList poly1 = DoublyLinkedList.createPolynomial(poly1Coefficients);
                    System.out.print("Enter coefficients for second polynomial (space-separated): ");
                    int[] poly2Coefficients = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
                    DoublyLinkedList poly2 = DoublyLinkedList.createPolynomial(poly2Coefficients);
                    DoublyLinkedList resultPoly = DoublyLinkedList.addPolynomials(poly1, poly2);
                    System.out.print("Resultant Polynomial: ");
                    resultPoly.display();
                    break;

                case 4:
                    System.out.println("Graph Representation of Linked List:");
                    list.graphRepresentation();
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