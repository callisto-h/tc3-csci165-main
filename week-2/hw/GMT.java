import java.util.Scanner;

public final class GMT{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Input the time zone offset to GMT: ");
        long offset = in.nextLong();
        long time = System.currentTimeMillis();
        time += offset * 3600000; // we calculate the change from time zone by adding or subtracting whole hours

        time %= 86400000; // removes extra days

        long hour = time / 3600000;
        time %= 3600000;

        long minute = time / 60000;
        time %= 60000;

        long second = time / 1000;

        System.out.printf("%02d:%02d:%02d%n", hour, minute, second); // easy peasy

        in.close();
    }


}