import java.util.Scanner;
public class ExceptionDriver {

    public static void main(String[] args){

        DeepCallStack dcs = new DeepCallStack();
        dcs.methodA();

        /*Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter numerator: ");
        double n = keyboard.nextInt();
        System.out.println("Enter denominator: ");
        double d = keyboard.nextInt();

        try{
            double result = Calculator.divide(n, d);
            System.out.printf("The result is %.2f\n", result);
        }catch(DivisionByZeroException dbz){
            System.out.println(dbz.getMessage());
        }
        */

    }

}
