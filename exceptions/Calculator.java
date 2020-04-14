public class Calculator{

    public static double divide(double a, double b) throws DivisionByZeroException{
        if (b == 0) throw new DivisionByZeroException();
        return a / b;
    }
}
