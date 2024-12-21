package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner groceryScanner = new Scanner(System.in);//creating a Scanner Object
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nGrocery List Management");
            System.out.println("0 - Exit");
            System.out.println("1 - Add items to the grocery list");
            System.out.println("2 - Remove items from the grocery list");
            System.out.print("Choose an option: ");

            int option = groceryScanner.nextInt();
            groceryScanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Exiting the application...");
                    isRunning = false;
                    break;
                case 1:
                    System.out.print("Enter items to add (comma-separated or single item): ");
                    String itemsToAdd = groceryScanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.print("Enter items to remove (comma-separated or single item): ");
                    String itemsToRemove = groceryScanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
            }
        }

    }

    public static void printSorted() {
        Collections.sort(groceryList); // Liste sıralanır
        System.out.println("\nCurrent Grocery List (Sorted):");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }

    public static void addItems(String itemsToAdd) {
        String[] items = itemsToAdd.split(",\\s*"); // Virgülle ayır ve gereksiz boşlukları temizle
        for (String item : items) {
            item = item.trim(); // Elemanlardaki gereksiz boşlukları temizle
            if (!checkItemIsInList(item)) { // Eğer listede yoksa ekle
                groceryList.add(item);
            } else {
                System.out.println("'" + item + "' is already in the list.");
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String itemsToRemove) {
        String[] items = itemsToRemove.split(",\\s*");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println("'" + item + "' is not in the list.");
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

}
