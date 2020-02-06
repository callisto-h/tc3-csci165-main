/*
    I made the translator more compact in problem2, this one isn't as tidy
*/

import java.util.Scanner;

public class KenSpeakProblem1{
    public static void main(String[] args){
        String codes = "*BEA@FK%RM";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a sequence of base10 digits for encoding: ");
        char[] sequence = scanner.nextLine().toCharArray(); //converts user input for easy comparison
        scanner.close();

        int SIZE = sequence.length;

        char[] encodedSequence = new char[SIZE];

        for (int i = 0; i < SIZE; i++){
            int index = (int)sequence[i] - 48; // 48 is the unicode offset from 0
            encodedSequence[i] = codes.charAt(index);
        }

        String encryptedString = new String(encodedSequence);
        System.out.printf("ENCRYPTED: %s\n", encryptedString);
    }
}