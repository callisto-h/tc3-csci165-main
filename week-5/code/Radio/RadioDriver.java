import java.util.Arrays;

public class RadioDriver{

    public static void main(String[] args){
        // create a Radio instance
        Radio radio = new Radio();

        // call static features
        System.out.println("AM Spectrum: " + Arrays.toString(Radio.AM_SPECTRUM));
        System.out.println("FM Spectrum: " + Arrays.toString(Radio.FM_SPECTRUM));
        System.out.println("Bands: {" + Radio.Band.AM + ", " + Radio.Band.FM +"}");

        // implicitly call toString
        System.out.println(radio);
    }
}