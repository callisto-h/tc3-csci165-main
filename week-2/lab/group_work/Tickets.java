import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Tickets{

    public static void main(String[] args){

        /* 
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt   

        */

        try{
            File inputFile = new File("tickets.txt"); // adds a new file object associated with "tickets.txt"
            java.util.Scanner fileScanner = new Scanner(inputFile); // adds a new scanner, pointing at inputFile as input source
            FileWriter outputFile = new FileWriter("valid_tix.txt"); // instantiate a new FileWriter, pointing ata new txt file as output.
            // we will be conditionally adding to a buffer for writing. 

            while(fileScanner.hasNext()){
                String  ticket  = fileScanner.nextLine(); // initializes a new ticket

                String  last = ticket.substring(ticket.length() - 1); 
                // creates a new string equal to the last character in the ticket string. 
                // subString() actually runs from the provided index until the end of the string, but it doesn't make a difference in this case. 

                int     last_digit = Integer.valueOf(last); 
                // gets the integer value of the last character in ticket. valueOf returns the integer value of the binary of the character.

                String  reduced_ticket = ticket.substring(0, ticket.length() - 1);
                // creates a new string from the first character to the last (exclusive) of ticket.

                int     ticket_number = Integer.valueOf(reduced_ticket);
                // creates a new int out of the value of reduced_ticket

                int     remainder = ticket_number % 7; 
                // creates a new int variable of the remainder of ticket_number modulus divison of 7

                boolean validity = remainder == last_digit; 
                // checks to see if the remaiander and last digit are equal to each other. 
                // it stores the result of this boolean operation in the validity variable

                if(validity){
                    outputFile.write(ticket+"\n"); // adds the ticket plus a newline character to a buffer
                }
            }
            outputFile.close(); // closes the output and writes the uffer to the file
            fileScanner.close(); // closes the file scanner
        }
        catch(IOException e){
            System.out.println("IO EXCEPTION");
        }

        //String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n";
        // creates a new string, format, with formattable and newline characters in it. cool, didn't know you could do this.

        //System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);
        // prints the format string, and supplies arguments that are formatted into the string.   
    }
}