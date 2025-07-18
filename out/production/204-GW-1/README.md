# Algorithm Application

A comprehensive Java application that demonstrates various search and sorting algorithms.

## Features

This application includes implementations of:

### Search Algorithms
1. **Linear Search** - Sequential search through array elements
2. **Binary Search** - Efficient search on sorted arrays

### Sorting Algorithms
1. **Selection Sort** - Finds minimum element and places it at the beginning
2. **Insertion Sort** - Builds sorted array one element at a time
3. **Merge Sort** - Divide and conquer sorting algorithm
4. **Bubble Sort** - Repeatedly swaps adjacent elements if they're in wrong order
5. **Quick Sort** - Efficient divide and conquer algorithm using pivot
6. **Shell Sort** - Generalization of insertion sort with gap sequence
7. **Radix Sort** - Non-comparative sorting for non-negative integers
8. **Heap Sort** - Uses binary heap data structure
9. **Nearly Sorted** - Optimized insertion sort for nearly sorted arrays
10. **Counting Sort** - Non-comparative sorting for non-negative integers

## Project Structure

- **Main.java** - Main application file with user interface and menu system
- **Algorithms.java** - Contains all search and sorting algorithm implementations
- **README.md** - Documentation and usage instructions

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command prompt or terminal

### Compilation
```bash
javac Algorithms.java Main.java
```

### Execution
```bash
java Main
```

## Usage

1. **Main Menu**: Choose between Search Algorithms, Sorting Algorithms, or Exit
2. **Algorithm Selection**: Select the specific algorithm you want to demonstrate
3. **Input Data**: Enter the array size and elements when prompted
4. **View Results**: See the algorithm execution and results

### Example Usage

```
Welcome to Algorithm Application!
=====================================

Main Menu:
1. Search Algorithms
2. Sorting Algorithms
3. Exit
Enter your choice (1-3): 2

Sorting Algorithms:
1. Selection Sort
2. Insertion Sort
3. Merge Sort
4. Bubble Sort
5. Quick Sort
6. Shell Sort
7. Radix Sort
8. Heap Sort
9. Nearly Sorted
10. Counting Sort
Enter your choice (1-10): 3

=== Merge Sort ===
Enter the size of array: 5
Enter 5 elements:
Element 1: 64
Element 2: 34
Element 3: 25
Element 4: 12
Element 5: 22
Original Array: [64, 34, 25, 12, 22]
Sorted Array: [12, 22, 25, 34, 64]
```

## Algorithm Details

### Search Algorithms
- **Linear Search**: O(n) time complexity, works on unsorted arrays
- **Binary Search**: O(log n) time complexity, requires sorted array

### Sorting Algorithms
- **Selection Sort**: O(n²) time complexity, O(1) space
- **Insertion Sort**: O(n²) worst case, O(n) best case for nearly sorted
- **Merge Sort**: O(n log n) time complexity, O(n) space
- **Bubble Sort**: O(n²) time complexity, O(1) space
- **Quick Sort**: O(n log n) average, O(n²) worst case
- **Shell Sort**: Better than O(n²), depends on gap sequence
- **Radix Sort**: O(d × (n + k)) where d is digits, k is range
- **Heap Sort**: O(n log n) time complexity, O(1) space
- **Counting Sort**: O(n + k) where k is range of input

## Notes

- **Radix Sort** and **Counting Sort** work only with non-negative integers
- **Binary Search** automatically sorts the input array before searching
- **Nearly Sorted** option uses insertion sort, which is optimal for nearly sorted data
- The application includes input validation and error handling

## Educational Purpose

This application is designed for educational purposes to demonstrate:
- Different algorithmic approaches
- Time and space complexity concepts
- When to use specific algorithms
- Implementation details of classic algorithms