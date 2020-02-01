import java.util.Scanner;
import java.lang.Integer;

public class Primitives{


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("\n== TASK ONE ==");
        primitiveTypes();

        System.out.println("\n== TASK TWO ==");
        System.out.print("Please enter (1) integer:");
        int base = in.nextInt();
        powers(base);

        System.out.println("\n== TASK THREE ==");
        intTesting();

        System.out.println("\n== TASK FOUR ==");
        System.out.println("Please enter (2) floating point numbers:");
        float first = in.nextFloat();
        double second = in.nextDouble();
        finiteDecimal(first, second);

        System.out.println("\n== TASK FIVE ==");
        System.out.println("Please enter (2) integers [numerator & divisor]:");
        int numerator = in.nextInt();
        int divisor = in.nextInt();
        division(numerator, divisor);

        in.close();

    }

    public static void primitiveTypes(){
        byte testByte = 69;
        System.out.println("testByte = " + testByte);
        System.out.println("Bytes are 8 bit signed integers.\n");

        short testShort = 32767;
        System.out.println("testShort = " + testShort);
        System.out.println("Shorts are 16 bit signed integers.\n");

        int testInt = 666;
        System.out.println("testInt = " + testInt);
        System.out.println("Ints are 32 bit signed integers.\n");

        long testLong = 666666666;
        System.out.println("testLong = " + testLong);
        System.out.println("Longs are 64 bit signed integers.\n");

        float testFloat = 1.2345f;
        System.out.println("testFloat = " + testFloat);
        System.out.println("Floats are 32 bit single precison decimal bois that we learn about in CS4.\n");

        double testDouble = 69.6969696969696969;
        System.out.println("testDouble = " + testDouble);
        System.out.println("Doubles are 64 bit double precision decimal bois that we learn about in CS4.\n");

        boolean testBoolean = true;
        System.out.println("testBoolean = " + testBoolean);
        System.out.println("Booleans are True or False, baby.\n");

        char testNumericChar = '3';
        char testAlphaChar = 'B';
        System.out.println("testNumericChar = " + testNumericChar);
        System.out.println("testNumericChar = " + testAlphaChar);
        System.out.println("Chars are 16 bit unisigned allocations, or single hex characters. Unicode.\n");

        int toBeWidened = 9;
        System.out.println("toBeWidened = " + toBeWidened);
        System.out.println("And now it is widened (float): " + (float)toBeWidened + "\n");

        int toBeNarrowed = 12345678;
        System.out.println("toBeNarrowed = " + toBeNarrowed);
        System.out.println("And now it is narrowed (byte): " + (byte)toBeNarrowed + "\n");
    }

    public static void powers(int base){
        for(int exp = 2; exp < 5; exp ++){ // prints a given base taken to the 2-4th power
            double total = Math.pow(base, exp);
            System.out.print(base);
            System.out.print(" to the power of ");
            System.out.print(exp + ": ");
            System.out.println((int)total);
        }
    }

    public static void intTesting(){
        int big = Integer.MAX_VALUE;
        int small = Integer.MIN_VALUE;

        System.out.println("Max: " + big);
        System.out.println("Min: " + small);

        System.out.println("\nThe compare method returns -1, 0, or 1,");
        System.out.println("which depends on if the first num is smaller,");
        System.out.println("the same, or bigger than the second.");

        // .compare has no issues when comparing signed and unsigned integers
        for(int a = -1; a < 2; a++){
            int diff = Integer.compare(a, 0);
            System.out.println("Comparing (using .compare()): " + a + " and 0: " +diff);
        }
        // .compareUnsigned has issues when comparing signed and unsigned integers
        // if an integer is signed, it will evaluate the sign-bit as being a numeric
        // value and read the wrong number.
        
        System.out.println("\nThe compareUnsigned method returns -1, 0, or 1,");
        System.out.println("which depends on if the first num is smaller,");
        System.out.println("the same, or bigger than the second.");
        for(int b = 1; b < 4; b++){
            int unsignedDiff = Integer.compareUnsigned(b, 2);
            System.out.println("Comparing (using .compareUnsigned()): " + b + " and 2: " + unsignedDiff);
            }
    }

    public static void finiteDecimal(float first, double second){
        // won't work

        boolean fFinite = Float.isFinite(1/first);
        boolean dFinite = Double.isFinite((1/second));

        System.out.println("This is a broken exercise: " + fFinite);
        System.out.println("This is a broken exercise: " + dFinite);
    }

    public static void division(int numerator, int divisor){
        // performs various types of division

        System.out.printf("Floor divison: %d%n", (numerator / divisor));
        System.out.printf("Floor divison (.floorDiv()): %d%n", Math.floorDiv(numerator, divisor));

        System.out.printf("Floor modulus: %d%n", (numerator % divisor));
        System.out.printf("Floor modulus (.floorMod()): %d%n", Math.floorMod(numerator ,divisor));

    }
}