package workshop01;

import java.util.Scanner;

public class Main {

    // initializing the position of "cmd"
    // CMD position will always be at index 0
    public static final int CMD_POS = 0;

    //main function of the program
    public static void main(String[] args) {
        // stop command to end program
        boolean stop = false;

        //scanner to be able to enter input in terminal
       Scanner scanner = new Scanner(System.in);

        // calling ShoppingCart constructor from ShoppingCart.java
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println("Welcome to your shopping cart");

        while (!stop) {
            System.out.println(">>>");

            String input = scanner.nextLine();

            // splitting by " " because when we add items,
            // we type in "add orange, apple etc" and it helps to split items up
            String[] terms = input.split(" ");

            // declare that cmd will forever be at index 0 for our String[] called terms
            String cmd = terms[CMD_POS].toUpperCase();

            switch (cmd) {

                // to list cart items
                case "LIST":
                    shoppingCart.listItems();
                    break;

                // added to make it more realistic if it was used in real life
                case "STOP":
                    stop = true;
                    break;

                // to add items to cart
                case "ADD":
                    for (int idx = 1; idx < terms.length; idx++) {
                        shoppingCart.addItems(terms[idx]);

                    }
                    break;

                case "DELETE":
                    // parseInt is function to convert a String, containing a number, to an actual Integer
                    // e.g. "delete 2" - delete is the CMD_POS at terms[0] and the integer 2 is at terms[1]
                    int itemIndexRemove = Integer.parseInt(terms[1]);
                    shoppingCart.removeItems(itemIndexRemove);
                    break;

                default:
                    System.out.println("Unknown command. Only enter 'list', 'add', 'stop', or 'delete'.");
                    break;

            }

        }

    }

}
