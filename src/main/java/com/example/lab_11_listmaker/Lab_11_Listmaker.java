package com.example.lab_11_listmaker;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {
        private static ArrayList<String> list = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean quit = false;

            while (!quit) {
                displayMenu();
                String choice = SafeInput.getRegExString("Enter your choice (A/D/P/Q): ", "[AaDdPpQq]");

                switch (choice.toUpperCase()) {
                    case "A":
                        addItem();
                        break;
                    case "D":
                        deleteItem();
                        break;
                    case "P":
                        displayList();
                        break;
                    case "Q":
                        quit = confirmQuit();
                        break;
                }
            }
        }

        private static void displayMenu() {
            System.out.println("ListMaker Menu:");
            System.out.println("A - Add an item to the list");
            System.out.println("D - Delete an item from the list");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit");
        }

        private static void addItem() {
            String item = SafeInput.getNonEmptyString("Enter an item to add: ");
            list.add(item);
            System.out.println("Item added to the list.");
        }

        private static void deleteItem() {
            if (list.isEmpty()) {
                System.out.println("The list is empty.");
                return;
            }

            displayList();

            int itemNumber = SafeInput.getRangedInt("Enter the item number to delete: ", 1, list.size());
            String deletedItem = list.remove(itemNumber - 1);
            System.out.println("Item " + deletedItem + " removed from the list.");
        }

        private static void displayList() {
            System.out.println("Current List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }

        private static boolean confirmQuit() {
            return SafeInput.getYNConfirm("Are you sure you want to quit? (y/n): ");
        }
    }
