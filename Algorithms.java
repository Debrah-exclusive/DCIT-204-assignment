import java.util.*;
public class Algorithms {

    // ==================== SEARCH ALGORITHMS ====================

    /**
     * Linear Search - checks each element one by one
     * Time complexity: O(n)
     */
    // PSEUDOCODE:
    // FUNCTION linearSearch(arr, target):
    //   FOR i FROM 0 TO length of arr - 1:
    //     IF arr[i] IS EQUAL TO target:
    //       RETURN i
    //     END IF
    //   END FOR
    //   RETURN -1 (not found)
    // END FUNCTION
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // found it! return the index
            }
        }
        return -1; // not found
    }

    /**
     * Binary Search - only works on sorted arrays, cuts search space in half each time
     * Time complexity: O(log n)
     */
    // PSEUDOCODE:
    // FUNCTION binarySearch(arr, target):
    //   left = 0
    //   right = length of arr - 1
    //
    //   WHILE left IS LESS THAN OR EQUAL TO right:
    //     mid = left + (right - left) / 2
    //
    //     IF arr[mid] IS EQUAL TO target:
    //       RETURN mid
    //     END IF
    //
    //     IF arr[mid] IS LESS THAN target:
    //       left = mid + 1
    //     ELSE:
    //       right = mid - 1
    //     END IF
    //   END WHILE
    //   RETURN -1 (not found)
    // END FUNCTION
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoid overflow

            if (arr[mid] == target) {
                return mid; // found it
            }

            if (arr[mid] < target) {
                left = mid + 1; // search right-hand side
            } else {
                right = mid - 1; // search left-hand side
            }
        }
        return -1; // not found
    }

    // ==================== SORTING ALGORITHMS ====================

    /**
     * Selection Sort - finds the smallest element and puts it at the beginning
     * Time complexity: O(n²)
     */
    // PSEUDOCODE:
    // FUNCTION selectionSort(arr):
    //   n = length of arr
    //   FOR i FROM 0 TO n - 2:
    //     minIdx = i
    //     FOR j FROM i + 1 TO n - 1:
    //       IF arr[j] IS LESS THAN arr[minIdx]:
    //         minIdx = j
    //       END IF
    //     END FOR
    //     // Swap arr[minIdx] and arr[i]
    //     temp = arr[minIdx]
    //     arr[minIdx] = arr[i]
    //     arr[i] = temp
    //   END FOR
    // END FUNCTION
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // assumes current position has minimum value

            // find the actual minimum in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // swap minimum with current position
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Insertion Sort - builds sorted array one element at a time
     * Time complexity: O(n²) worst case, O(n) best case
     */
    // PSEUDOCODE:
    // FUNCTION insertionSort(arr):
    //   n = length of arr
    //   FOR i FROM 1 TO n - 1:
    //     key = arr[i]
    //     j = i - 1
    //
    //     WHILE j IS GREATER THAN OR EQUAL TO 0 AND arr[j] IS GREATER THAN key:
    //       arr[j + 1] = arr[j]
    //       j = j - 1
    //     END WHILE
    //     arr[j + 1] = key
    //   END FOR
    // END FUNCTION
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // shift elements that are greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // insert key at correct position
        }
    }

    /**
     * Merge Sort - divide and conquer approach
     * Time complexity: O(n log n)
     */
    // PSEUDOCODE:
    // FUNCTION mergeSort(arr, left, right):
    //   IF left IS LESS THAN right:
    //     mid = left + (right - left) / 2
    //
    //     CALL mergeSort(arr, left, mid)
    //     CALL mergeSort(arr, mid + 1, right)
    //
    //     CALL merge(arr, left, mid, right)
    //   END IF
    // END FUNCTION
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // recursively sort both halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Helper method for merge sort - merges two sorted subarrays
     */
    // PSEUDOCODE:
    // FUNCTION merge(arr, left, mid, right):
    //   n1 = mid - left + 1
    //   n2 = right - mid
    //
    //   CREATE temp array leftArr of size n1
    //   CREATE temp array rightArr of size n2
    //
    //   FOR i FROM 0 TO n1 - 1:
    //     leftArr[i] = arr[left + i]
    //   END FOR
    //   FOR j FROM 0 TO n2 - 1:
    //     rightArr[j] = arr[mid + 1 + j]
    //   END FOR
    //
    //   i = 0, j = 0, k = left
    //
    //   WHILE i IS LESS THAN n1 AND j IS LESS THAN n2:
    //     IF leftArr[i] IS LESS THAN OR EQUAL TO rightArr[j]:
    //       arr[k] = leftArr[i]
    //       INCREMENT i
    //     ELSE:
    //       arr[k] = rightArr[j]
    //       INCREMENT j
    //     END IF
    //     INCREMENT k
    //   END WHILE
    //
    //   WHILE i IS LESS THAN n1:
    //     arr[k] = leftArr[i]
    //     INCREMENT i
    //     INCREMENT k
    //   END WHILE
    //
    //   WHILE j IS LESS THAN n2:
    //     arr[k] = rightArr[j]
    //     INCREMENT j
    //     INCREMENT k
    //   END WHILE
    // END FUNCTION
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // create temp arrays for left and right subarrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // merge the temp arrays back into arr
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // copy remaining elements
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Bubble Sort - repeatedly swaps adjacent elements if they're in wrong order
     * Time complexity: O(n²)
     */
    // PSEUDOCODE:
    // FUNCTION bubbleSort(arr):
    //   n = length of arr
    //   FOR i FROM 0 TO n - 2:
    //     swapped = FALSE
    //     FOR j FROM 0 TO n - i - 2:
    //       IF arr[j] IS GREATER THAN arr[j + 1]:
    //         // Swap arr[j] and arr[j+1]
    //         temp = arr[j]
    //         arr[j] = arr[j + 1]
    //         arr[j + 1] = temp
    //         swapped = TRUE
    //       END IF
    //     END FOR
    //     IF swapped IS FALSE:
    //       BREAK LOOP
    //     END IF
    //   END FOR
    // END FUNCTION
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // optimization: stop if no swaps made

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // array is already sorted
        }
    }

    /**
     * Quick Sort - picks a pivot and partitions array around it
     * Time complexity: O(n log n) average, O(n²) worst case
     */
    // PSEUDOCODE:
    // FUNCTION quickSort(arr, low, high):
    //   IF low IS LESS THAN high:
    //     pi = CALL partition(arr, low, high)
    //
    //     CALL quickSort(arr, low, pi - 1)
    //     CALL quickSort(arr, pi + 1, high)
    //   END IF
    // END FUNCTION
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partition index

            // recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Helper method for quick sort - partitions array around pivot
     */
    // PSEUDOCODE:
    // FUNCTION partition(arr, low, high):
    //   pivot = arr[high]
    //   i = low - 1
    //
    //   FOR j FROM low TO high - 1:
    //     IF arr[j] IS LESS THAN pivot:
    //       INCREMENT i
    //       // Swap arr[i] and arr[j]
    //       temp = arr[i]
    //       arr[i] = arr[j]
    //       arr[j] = temp
    //     END IF
    //   END FOR
    //
    //   // Swap arr[i+1] and arr[high] (pivot)
    //   temp = arr[i + 1]
    //   arr[i + 1] = arr[high]
    //   arr[high] = temp
    //
    //   RETURN i + 1
    // END FUNCTION
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Shell Sort - improved insertion sort with gap sequence
     * Time complexity: depends on gap sequence, generally better than O(n²)
     */
    // PSEUDOCODE:
    // FUNCTION shellSort(arr):
    //   n = length of arr
    //
    //   FOR gap = n / 2 DOWNTO 1 (dividing by 2 each time):
    //     FOR i FROM gap TO n - 1:
    //       temp = arr[i]
    //       j = i
    //
    //       WHILE j IS GREATER THAN OR EQUAL TO gap AND arr[j - gap] IS GREATER THAN temp:
    //         arr[j] = arr[j - gap]
    //         j = j - gap
    //       END WHILE
    //
    //       arr[j] = temp
    //     END FOR
    //   END FOR
    // END FUNCTION
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // start with large gap and reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // do insertion sort for elements at gap distance
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }
    }

    /**
     * Radix Sort - sorts by individual digits (non-comparative)
     * Time complexity: O(d × (n + k)) where d is number of digits
     */
    // PSEUDOCODE:
    // FUNCTION radixSort(arr):
    //   max = CALL getMax(arr)
    //
    //   FOR exp = 1 WHILE max / exp IS GREATER THAN 0 (multiplying by 10 each time):
    //     CALL countSort(arr, exp)
    //   END FOR
    // END FUNCTION
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // do counting sort for every digit (1s, 10s, 100s, etc.)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    /**
     * Helper method - finds maximum element in array
     */
    // PSEUDOCODE:
    // FUNCTION getMax(arr):
    //   max = arr[0]
    //   FOR i FROM 1 TO length of arr - 1:
    //     IF arr[i] IS GREATER THAN max:
    //       max = arr[i]
    //     END IF
    //   END FOR
    //   RETURN max
    // END FUNCTION
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Helper method for radix sort - counting sort based on digit position
     */
    // PSEUDOCODE:
    // FUNCTION countSort(arr, exp):
    //   n = length of arr
    //   CREATE output array of size n
    //   CREATE count array of size 10 (for digits 0-9)
    //
    //   Fill count array with 0s
    //
    //   FOR i FROM 0 TO n - 1:
    //     INCREMENT count[(arr[i] / exp) % 10]
    //   END FOR
    //
    //   FOR i FROM 1 TO 9:
    //     count[i] = count[i] + count[i - 1]
    //   END FOR
    //
    //   FOR i FROM n - 1 DOWNTO 0:
    //     output[count[(arr[i] / exp) % 10] - 1] = arr[i]
    //     DECREMENT count[(arr[i] / exp) % 10]
    //   END FOR
    //
    //   FOR i FROM 0 TO n - 1:
    //     arr[i] = output[i]
    //   END FOR
    // END FUNCTION
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // for digits 0-9

        Arrays.fill(count, 0);

        // count occurrences of each digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // change count[i] to actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // copy output array back to original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * Heap Sort - uses binary heap data structure
     * Time complexity: O(n log n)
     */
    // PSEUDOCODE:
    // FUNCTION heapSort(arr):
    //   n = length of arr
    //
    //   // Build max heap (rearrange array)
    //   FOR i FROM n / 2 - 1 DOWNTO 0:
    //     CALL heapify(arr, n, i)
    //   END FOR
    //
    //   // Extract elements one by one from heap
    //   FOR i FROM n - 1 DOWNTO 1:
    //     // Move current root (maximum element) to end of array
    //     temp = arr[0]
    //     arr[0] = arr[i]
    //     arr[i] = temp
    //
    //     // Call heapify on the reduced heap
    //     CALL heapify(arr, i, 0)
    //   END FOR
    // END FUNCTION
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // move current root (max) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Helper method - maintains max heap property
     */
    // PSEUDOCODE:
    // FUNCTION heapify(arr, n, i):
    //   largest = i
    //   left = 2 * i + 1
    //   right = 2 * i + 2
    //
    //   IF left IS LESS THAN n AND arr[left] IS GREATER THAN arr[largest]:
    //     largest = left
    //   END IF
    //
    //   IF right IS LESS THAN n AND arr[right] IS GREATER THAN arr[largest]:
    //     largest = right
    //   END IF
    //
    //   IF largest IS NOT EQUAL TO i:
    //     // Swap arr[i] and arr[largest]
    //     swap = arr[i]
    //     arr[i] = arr[largest]
    //     arr[largest] = swap
    //
    //     CALL heapify(arr, n, largest)
    //   END IF
    // END FUNCTION
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // assume root is largest
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // check if right child is larger than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // if largest is not root, swap and continue heapifying
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    /**
     * Counting Sort - counts occurrences of each element (non-comparative)
     * Time complexity: O(n + k) where k is range of input
     */
    // PSEUDOCODE:
    // FUNCTION countingSort(arr):
    //   n = length of arr
    //   max = CALL getMax(arr)
    //
    //   CREATE count array of size max + 1
    //   CREATE output array of size n
    //
    //   // Count occurrences of each element
    //   FOR i FROM 0 TO n - 1:
    //     INCREMENT count[arr[i]]
    //   END FOR
    //
    //   // Change count[i] to actual position in output array
    //   FOR i FROM 1 TO max:
    //     count[i] = count[i] + count[i - 1]
    //   END FOR
    //
    //   // Build output array
    //   FOR i FROM n - 1 DOWN TO 0:
    //     output[count[arr[i]] - 1] = arr[i]
    //     DECREMENT count[arr[i]]
    //   END FOR
    //
    //   // Copy output array back to original
    //   FOR i FROM 0 TO n - 1:
    //     arr[i] = output[i]
    //   END FOR
    // END FUNCTION
    public static void countingSort(int[] arr) {
        int n = arr.length;
        int max = getMax(arr);

        int[] count = new int[max + 1];
        int[] output = new int[n];

        // count occurrences of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // change count[i] to actual position in output array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // copy output array back to original
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * Utility method - checks if array has negative numbers
     * (needed for radix sort and counting sort)
     */
    // PSEUDOCODE:
    // FUNCTION hasNegativeNumbers(arr):
    //   FOR EACH num IN arr:
    //     IF num IS LESS THAN 0:
    //       RETURN TRUE
    //     END IF
    //   END FOR
    //   RETURN FALSE
    // END FUNCTION
    public static boolean hasNegativeNumbers(int[] arr) {
        for (int num : arr) {
            if (num < 0) {
                return true;
            }
        }
        return false;
    }
}