import java.util.Scanner;

public final class Initials{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = in.nextLine();

        char firstNameLetter = name.charAt(0);
        int firstNameVal = (int)firstNameLetter;
        char lastNameLetter = name.charAt(name.indexOf(" ") + 1);
        int lastNameVal = (int)lastNameLetter;

        System.out.printf("First name, first letter: %c%n", firstNameLetter);
        System.out.printf("Last name, first letter: %c%n", lastNameLetter);
        System.out.printf("First name, first letter (value): %d%n", firstNameVal);
        System.out.printf("Last name, first letter (value): %d%n", lastNameVal);
        System.out.printf("Sum of their values: %d%n", firstNameVal + lastNameVal);
        System.out.println(""+firstNameLetter+lastNameLetter); // apparently has bad performance compared to a stringBuilder()

        in.close();
    }
}