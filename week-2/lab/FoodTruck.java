import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;


/*

Alright so there are a bunch of different arrays
throughout this lab that are all tracking data 
and are supposed to run parallel to one another.
If this were a *good* language like Python, I 
could just keep all of these bits of data in the
same 2D array, but nooooooooooo, gotta keep them
separated.

Here's a visual guide to help keep track of stuff.
items are strings, prices and and subtotals are 
doubles, and quantities are ints.

Any doubles get formatted through a DecimalFormat
before being displayed on to the screen or written
to any files. Have fun - Callisto 

          0_________ 1_________ 2_________
ITEMS    | "item 1" | "item 2" | "item 3" | (strings)
          __________ __________ __________
PRICES   | 1.99     | 2.5      | 4.0      | (doubles)
          __________ __________ __________
QUANTITY | 1        | 2        | 1        | (ints)
          __________ __________ __________
SUBTOTAL | 1.99     | 5.0      | 4.0      | (doubles)


*/

public class FoodTruck{

    public static void main(String[] args){
        String[] items = new String[3];
        double[] prices = new double[3];
        try{
            File inputFile = new File("menu.txt");
            Scanner inputScanner = new Scanner(inputFile);
            int j = 0;
            while(inputScanner.hasNextLine()){
                items[j] = inputScanner.nextLine();
                j++;
            }//end while loop
            inputScanner.close();
            
            inputFile = new File("prices.txt");
            inputScanner = new Scanner(inputFile);
            int i = 0;
            while(inputScanner.hasNextLine()){
                prices[i] = Double.parseDouble(inputScanner.nextLine());
                i++;
            }
            inputScanner.close();
        }//end try
        catch(IOException e){
            System.out.println("IO ERROR");
        }//end catch

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the CS foodtruck!\n");
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        int[] quantities = getOrder(items, prices, in);

        generateReciept(items, prices, quantities, name);

        in.close();
    }//end main

    public static int[] getOrder(String[] items, double[] prices, Scanner in){
        DecimalFormat usd = new DecimalFormat("$###,##0.00"); //incase something is real expensive

        int[] quantities = new int[3];

        System.out.println("\nEnter the quantity of each item.\n");
        System.out.println("========================================\n");

        for(int i = 0; i < items.length; i++){
            String line = String.format("%s - %s: ", items[i], usd.format(prices[i])); // item -- price
            System.out.print(line); // gets input as to how many of each item the user wants to order
            quantities[i] = in.nextInt();
            System.out.println();
        }
        return(quantities);
    }//end prices

    public static void generateReciept(String[] items, double[] prices, int[] quantities, String name){
        final double TAX_PERCENT = 6.25;

        DecimalFormat usd = new DecimalFormat("$###,##0.00"); // format we shall be using for the monies

        double[] subTotals = new double[3]; // parallel array with items, prices, and quantities

        for(int m = 0; m < quantities.length; m ++){
            subTotals[m] = prices[m] * (double)quantities[m]; // alligns entries of prices and quantites, stores sum in subTotals
        }

        String[] recieptLines = new String[22]; // gonna use a 21 entry long array of strings to represent the reciept

        for(int i = 0; i < recieptLines.length; i++){
            recieptLines[i] = "\n"; // each entry is now a newline character. Not scalable in the slightest but neat
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //two month characters despite lab showing differently, I WILL fight you over this
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss"); //using 24h time

        String date = dateFormatter.format(now);
        String time = timeFormatter.format(now);
        String invoiceNumber = generateInvoiceNumber(name, now);

        double subTotalSum = subTotals[0] + subTotals[1] + subTotals[2];
        double subTotalTax = (TAX_PERCENT / 100) * subTotalSum;
        double total = subTotalSum + subTotalTax;

        recieptLines[0] = String.format("%-30s%-30s\n", "Invoice Number:", invoiceNumber);
        recieptLines[1] = String.format("%-30s%-30s\n", "Date:", date);
        recieptLines[2] = String.format("%-30s%-30s\n", "Time:", time); //this could have been consolidated into a loop, don't care tho

        recieptLines[4] = String.format("%-30s%-10s%-10s%-10s\n", "Item", "Quantity", "Price", "Total");

        recieptLines[6] = "============================================================\n"; // lol 60 long

        for(int k = 8; k < 13; k += 2){ // three loops, on lines 8, 10, 12
            int menuIndex = (k - 8) / 2; //converts the k index back into corresponding indexes for menu array, using y = (x - 8) / 2
            recieptLines[k] = String.format("%-30s%-10s%-10s%-10s\n", items[menuIndex], quantities[menuIndex], usd.format(prices[menuIndex]) , usd.format(subTotals[menuIndex])); //items, quantity, price, total 
        }

        recieptLines[14] = "============================================================\n"; // lol 60 long

        recieptLines[16] = String.format("%-50s%-10s\n", "Subtotal:", usd.format(subTotalSum));

        recieptLines[18] = String.format("%-50s%-10s\n", Double.toString(TAX_PERCENT) + "% Sales Tax:", usd.format(subTotalTax));

        recieptLines[20] = String.format("%-50s%-10s\n", "Total:", usd.format(total));

        consoleOutput(recieptLines);
        fileOutput(recieptLines, invoiceNumber);

    }//end reciept

    public static void consoleOutput(String[] line){
        for(int i = 0; i < line.length; i++){
            System.out.print(line[i]);
        }

    }//end consoleOutput

    public static void fileOutput(String[] line, String invoice){
        try{
            File output = new File(String.format("%s.txt", invoice));
            FileWriter writer = new FileWriter(output);

            for (int i = 0; i < line.length; i++){ 
                writer.write(line[i]);
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }//end fileOutput

    public static String generateInvoiceNumber(String name, LocalDateTime now){
        String firstNameTwoChar = name.substring(0, 2).toUpperCase(); //gets first name first 2 chars, uppercase
        String lastNameTwoChar = name.substring(name.indexOf(" ") + 1, name.indexOf(" ") + 3).toUpperCase(); //gets last name first two chars, uppercase

        char firstNameFirstChar = firstNameTwoChar.charAt(0);
        char lastNameFirstChar = lastNameTwoChar.charAt(0);
        int firstCharSum = (int)firstNameFirstChar + (int)lastNameFirstChar; //adds two unicode chars together
        int firstCharProduct = firstCharSum * name.length(); //multiplies by len

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMHHmm"); //initializing datetimeformat mask
        String monthDayYear = now.format(formatter); //running LocalDateTime object through mask

        String invoiceNumber = String.format("%s%s%d%s", firstNameTwoChar, lastNameTwoChar, firstCharProduct, monthDayYear); //formats into your weird, arbitrary mess

        return(invoiceNumber);
    }//end generateInvoiceNumber


}//end class