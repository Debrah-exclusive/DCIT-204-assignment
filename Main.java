import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to Algorithm Application!");
        System.out.println("=====================================");
        System.out.println("Choose interface mode:");
        System.out.println("1. Console Mode (Text-based)");
        System.out.println("2. GUI Mode (Graphical)");
        System.out.print("Enter your choice (1-2): ");
        
        int choice = getChoice();
        
        switch (choice) {
            case 1:
                runConsoleMode();
                break;
            case 2:
                System.out.println("Starting GUI mode...");
                AlgorithmGUI.main(args);
                break;
            default:
                System.out.println("Invalid choice! Starting console mode by default.");
                runConsoleMode();
        }
    }
    
    private static void runConsoleMode() {
        System.out.println("\n=== Console Mode ===");
        
        while (true) {
            displayMainMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    handleSearchAlgorithms();
                    break;
                case 2:
                    handleSortingAlgorithms();
                    break;
                case 3:
                    System.out.println("Thank you for using Algorithm Application!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Search Algorithms");
        System.out.println("2. Sorting Algorithms");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
    }
    
    private static void handleSearchAlgorithms() {
        System.out.println("\nSearch Algorithms:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Enter your choice (1-2): ");
        
        int choice = getChoice();
        switch (choice) {
            case 1:
                performLinearSearch();
                break;
            case 2:
                performBinarySearch();
                break;
            default:
                System.out.println("Invalid choice!\n");
        }
    }
    
    private static void handleSortingAlgorithms() {
        System.out.println("\nSorting Algorithms:");
        System.out.println("1. Selection Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Bubble Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Shell Sort");
        System.out.println("7. Radix Sort");
        System.out.println("8. Heap Sort");
        System.out.println("9. Nearly Sorted");
        System.out.println("10. Counting Sort");
        System.out.print("Enter your choice (1-10): ");
        
        int choice = getChoice();
        switch (choice) {
            case 1:
                performSelectionSort();
                break;
            case 2:
                performInsertionSort();
                break;
            case 3:
                performMergeSort();
                break;
            case 4:
                performBubbleSort();
                break;
            case 5:
                performQuickSort();
                break;
            case 6:
                performShellSort();
                break;
            case 7:
                performRadixSort();
                break;
            case 8:
                performHeapSort();
                break;
            case 9:
                performNearlySorted();
                break;
            case 10:
                performCountingSort();
                break;
            default:
                System.out.println("Invalid choice!\n");
        }
    }
    
    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
    
    private static int[] getArrayFromUser() {
        System.out.print("Enter the size of array: ");
        int size = getChoice();
        if (size <= 0) {
            System.out.println("Invalid size!");
            return new int[0];
        }
        
        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = getChoice();
        }
        return arr;
    }
    
    private static void printArray(int[] arr, String message) {
        System.out.println(message + Arrays.toString(arr));
    }
    
    // Search Algorithm Implementations
    private static void performLinearSearch() {
        System.out.println("\n=== Linear Search ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        System.out.print("Enter element to search: ");
        int target = getChoice();
        
        printArray(arr, "Array: ");
        int result = Algorithms.linearSearch(arr, target);
        
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
        System.out.println();
    }
    
    private static void performBinarySearch() {
        System.out.println("\n=== Binary Search ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        // Sort array first for binary search
        Arrays.sort(arr);
        printArray(arr, "Sorted Array: ");
        
        System.out.print("Enter element to search: ");
        int target = getChoice();
        
        int result = Algorithms.binarySearch(arr, target);
        
        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
        System.out.println();
    }
    
    // Sorting Algorithm Implementations
    private static void performSelectionSort() {
        System.out.println("\n=== Selection Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.selectionSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performInsertionSort() {
        System.out.println("\n=== Insertion Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.insertionSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performMergeSort() {
        System.out.println("\n=== Merge Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.mergeSort(arr, 0, arr.length - 1);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performBubbleSort() {
        System.out.println("\n=== Bubble Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.bubbleSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performQuickSort() {
        System.out.println("\n=== Quick Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.quickSort(arr, 0, arr.length - 1);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performShellSort() {
        System.out.println("\n=== Shell Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.shellSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performRadixSort() {
        System.out.println("\n=== Radix Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        // Check for negative numbers
        if (Algorithms.hasNegativeNumbers(arr)) {
            System.out.println("Radix sort works only with non-negative integers!");
            return;
        }
        
        printArray(arr, "Original Array: ");
        Algorithms.radixSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performHeapSort() {
        System.out.println("\n=== Heap Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        Algorithms.heapSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performNearlySorted() {
        System.out.println("\n=== Nearly Sorted (Insertion Sort Optimized) ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        printArray(arr, "Original Array: ");
        System.out.println("Note: This uses insertion sort which is efficient for nearly sorted arrays.");
        Algorithms.insertionSort(arr); // Insertion sort is optimal for nearly sorted arrays
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
    
    private static void performCountingSort() {
        System.out.println("\n=== Counting Sort ===");
        int[] arr = getArrayFromUser();
        if (arr.length == 0) return;
        
        // Check for negative numbers
        if (Algorithms.hasNegativeNumbers(arr)) {
            System.out.println("Counting sort works only with non-negative integers!");
            return;
        }
        
        printArray(arr, "Original Array: ");
        Algorithms.countingSort(arr);
        printArray(arr, "Sorted Array: ");
        System.out.println();
    }
}