package com.yaksha.assignment;

import java.util.Scanner;

public class ForEachLoopAssignment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: Print Array Elements
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Array elements:");
        for (int element : array) {
            System.out.println(element);
        }

        // Task 2: Sum of Elements in an Array
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        System.out.println("Sum of elements: " + sum);

        // Task 3: Print Characters of a String
        System.out.print("Enter a string: ");
        String str = scanner.next();
        System.out.println("Characters of the string:");
        for (char ch : str.toCharArray()) {
            System.out.println(ch);
        }

        // Task 4: Find Maximum Element in an Array
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        System.out.println("Maximum element: " + max);

        // Task 5: Count Occurrences of a Specific Element in an Array
        System.out.print("Enter the element to search for: ");
        int target = scanner.nextInt();
        int count = 0;
        for (int element : array) {
            if (element == target) {
                count++;
            }
        }
        System.out.println("Occurrences of " + target + ": " + count);
    }
}
