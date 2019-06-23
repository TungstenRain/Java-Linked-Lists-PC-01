package ch20pc01;

import java.util.Scanner;

/**
 * 
 * @author frank
 */
public class Ch20pc01 {

    /**
     * The Main Method
     * @param args String[] The command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        // this will generate an error on first run: you must make the class generic first
        GenericLinkedList<Double> linkedList = new GenericLinkedList<Double>();
        linkedList.add(25.3);
        linkedList.add(5.34);
        linkedList.add(78.3);
        linkedList.add(78.0);
        linkedList.add(2, 23.6);
        
        System.out.println("The members of the list are:");
        System.out.print(linkedList);
        
        // Test the set method
        // Get a list position
        int index = -1; // Position in the list
        double number; // New element to set
        do {
            System.out.println("Set: Enter a position in the list.");
            String indexString = keyboard.nextLine();
            index = Integer.parseInt(indexString);
            if (index < 0 || index >= linkedList.size())
                System.err.println("The number you entered is not a legal position.");
        } while (index < 0 || index >= linkedList.size());
        
        // Get the new element to set
        System.out.println("Enter a real number.");
        String numberString = keyboard.nextLine();
        number = Double.parseDouble(numberString);
        
        Double oldNumber = (Double) linkedList.set(index, number);
        System.out.println("Old number was " + oldNumber);
        
        // Display the new list
        System.out.println("The members of the list are:");
        System.out.print(linkedList);
        
        // Test the get method
        index = -1;
        do {
            System.out.println("Enter a position in the list.");
            String indexString = keyboard.nextLine();
            index = Integer.parseInt(indexString);
            if (index < 0 || index >= linkedList.size())
                System.err.println("The number you entered is not a legal position.");
        }
        while (index < 0 || index >= linkedList.size());
        System.out.println("Get: The element at that position is " + linkedList.get(index));
        //clear the list
        linkedList.clear();
        System.out.println("After clearing the list: size = " + linkedList.size());
    }
}