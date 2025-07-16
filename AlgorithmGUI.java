import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class AlgorithmGUI extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JTextField searchField;
    private JButton[] sortButtons;
    private JButton[] searchButtons;
    private int[] currentArray;
    
    public AlgorithmGUI() {
        setTitle("Algorithm Application - GUI Version");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initializeComponents() {
        // Input area for array
        inputArea = new JTextArea(3, 30);
        inputArea.setBorder(BorderFactory.createTitledBorder("Enter Array (comma-separated numbers)"));
        inputArea.setText("5, 2, 8, 1, 9, 3");
        
        // Output area
        outputArea = new JTextArea(15, 30);
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        outputArea.setBorder(BorderFactory.createTitledBorder("Results"));
        
        // Search field
        searchField = new JTextField(10);
        searchField.setBorder(BorderFactory.createTitledBorder("Search Target"));
        
        // Sorting algorithm buttons
        String[] sortNames = {
            "Selection Sort", "Insertion Sort", "Merge Sort", "Bubble Sort",
            "Quick Sort", "Shell Sort", "Radix Sort", "Heap Sort", 
            "Nearly Sorted", "Counting Sort"
        };
        
        sortButtons = new JButton[sortNames.length];
        for (int i = 0; i < sortNames.length; i++) {
            sortButtons[i] = new JButton(sortNames[i]);
            sortButtons[i].setPreferredSize(new Dimension(120, 30));
        }
        
        // Search algorithm buttons
        String[] searchNames = {"Linear Search", "Binary Search"};
        searchButtons = new JButton[searchNames.length];
        for (int i = 0; i < searchNames.length; i++) {
            searchButtons[i] = new JButton(searchNames[i]);
            searchButtons[i].setPreferredSize(new Dimension(120, 30));
        }
    }
    
    private void setupLayout() {
        // Top panel for input
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Search for:"));
        searchPanel.add(searchField);
        topPanel.add(searchPanel, BorderLayout.SOUTH);
        
        // Center panel for buttons
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Sorting algorithms panel
        JPanel sortPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        sortPanel.setBorder(new TitledBorder("Sorting Algorithms"));
        for (JButton button : sortButtons) {
            sortPanel.add(button);
        }
        
        // Search algorithms panel
        JPanel searchAlgoPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        searchAlgoPanel.setBorder(new TitledBorder("Search Algorithms"));
        for (JButton button : searchButtons) {
            searchAlgoPanel.add(button);
        }
        
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(searchAlgoPanel, BorderLayout.NORTH);
        
        centerPanel.add(sortPanel);
        centerPanel.add(rightPanel);
        
        // Bottom panel for output
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        // Add panels to main frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private void setupEventHandlers() {
        // Sorting algorithm handlers
        sortButtons[0].addActionListener(e -> performSort("Selection Sort", () -> Algorithms.selectionSort(currentArray)));
        sortButtons[1].addActionListener(e -> performSort("Insertion Sort", () -> Algorithms.insertionSort(currentArray)));
        sortButtons[2].addActionListener(e -> performSort("Merge Sort", () -> Algorithms.mergeSort(currentArray, 0, currentArray.length - 1)));
        sortButtons[3].addActionListener(e -> performSort("Bubble Sort", () -> Algorithms.bubbleSort(currentArray)));
        sortButtons[4].addActionListener(e -> performSort("Quick Sort", () -> Algorithms.quickSort(currentArray, 0, currentArray.length - 1)));
        sortButtons[5].addActionListener(e -> performSort("Shell Sort", () -> Algorithms.shellSort(currentArray)));
        sortButtons[6].addActionListener(e -> performRadixSort());
        sortButtons[7].addActionListener(e -> performSort("Heap Sort", () -> Algorithms.heapSort(currentArray)));
        sortButtons[8].addActionListener(e -> performSort("Nearly Sorted (Insertion Sort)", () -> Algorithms.insertionSort(currentArray)));
        sortButtons[9].addActionListener(e -> performCountingSort());
        
        // Search algorithm handlers
        searchButtons[0].addActionListener(e -> performLinearSearch());
        searchButtons[1].addActionListener(e -> performBinarySearch());
    }
    
    private int[] parseArray() {
        try {
            String input = inputArea.getText().trim();
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Please enter some numbers");
            }
            
            String[] parts = input.split(",");
            int[] array = new int[parts.length];
            
            for (int i = 0; i < parts.length; i++) {
                array[i] = Integer.parseInt(parts[i].trim());
            }
            
            return array;
        } catch (NumberFormatException e) {
            outputArea.append("Error: Please enter valid integers separated by commas\n\n");
            return null;
        } catch (IllegalArgumentException e) {
            outputArea.append("Error: " + e.getMessage() + "\n\n");
            return null;
        }
    }
    
    private void performSort(String algorithmName, Runnable sortFunction) {
        currentArray = parseArray();
        if (currentArray == null) return;
        
        int[] originalArray = currentArray.clone();
        
        outputArea.append("=== " + algorithmName + " ===\n");
        outputArea.append("Original Array: " + Arrays.toString(originalArray) + "\n");
        
        long startTime = System.nanoTime();
        sortFunction.run();
        long endTime = System.nanoTime();
        
        outputArea.append("Sorted Array:   " + Arrays.toString(currentArray) + "\n");
        outputArea.append("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    private void performRadixSort() {
        currentArray = parseArray();
        if (currentArray == null) return;
        
        if (Algorithms.hasNegativeNumbers(currentArray)) {
            outputArea.append("=== Radix Sort ===\n");
            outputArea.append("Error: Radix sort works only with non-negative integers!\n\n");
            return;
        }
        
        performSort("Radix Sort", () -> Algorithms.radixSort(currentArray));
    }
    
    private void performCountingSort() {
        currentArray = parseArray();
        if (currentArray == null) return;
        
        if (Algorithms.hasNegativeNumbers(currentArray)) {
            outputArea.append("=== Counting Sort ===\n");
            outputArea.append("Error: Counting sort works only with non-negative integers!\n\n");
            return;
        }
        
        performSort("Counting Sort", () -> Algorithms.countingSort(currentArray));
    }
    
    private void performLinearSearch() {
        currentArray = parseArray();
        if (currentArray == null) return;
        
        try {
            int target = Integer.parseInt(searchField.getText().trim());
            
            outputArea.append("=== Linear Search ===\n");
            outputArea.append("Array: " + Arrays.toString(currentArray) + "\n");
            outputArea.append("Searching for: " + target + "\n");
            
            long startTime = System.nanoTime();
            int result = Algorithms.linearSearch(currentArray, target);
            long endTime = System.nanoTime();
            
            if (result != -1) {
                outputArea.append("Result: Element " + target + " found at index " + result + "\n");
            } else {
                outputArea.append("Result: Element " + target + " not found in the array\n");
            }
            outputArea.append("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n\n");
            
        } catch (NumberFormatException e) {
            outputArea.append("Error: Please enter a valid number to search for\n\n");
        }
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    private void performBinarySearch() {
        currentArray = parseArray();
        if (currentArray == null) return;
        
        try {
            int target = Integer.parseInt(searchField.getText().trim());
            
            // Sort array first for binary search
            int[] sortedArray = currentArray.clone();
            Arrays.sort(sortedArray);
            
            outputArea.append("=== Binary Search ===\n");
            outputArea.append("Original Array: " + Arrays.toString(currentArray) + "\n");
            outputArea.append("Sorted Array:   " + Arrays.toString(sortedArray) + "\n");
            outputArea.append("Searching for: " + target + "\n");
            
            long startTime = System.nanoTime();
            int result = Algorithms.binarySearch(sortedArray, target);
            long endTime = System.nanoTime();
            
            if (result != -1) {
                outputArea.append("Result: Element " + target + " found at index " + result + " in sorted array\n");
            } else {
                outputArea.append("Result: Element " + target + " not found in the array\n");
            }
            outputArea.append("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n\n");
            
        } catch (NumberFormatException e) {
            outputArea.append("Error: Please enter a valid number to search for\n\n");
        }
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new AlgorithmGUI();
        });
    }
}