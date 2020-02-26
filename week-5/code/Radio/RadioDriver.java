import java.util.Arrays;

public class RadioDriver{

    public static void main(String[] args){
        // create a Radio instance
        Radio       radio       = new Radio();
        Radio       radio1      = new Radio();
        Radio       radio2      = new Radio(Radio.Band.FM, Radio.FM_SPECTRUM[1]);
        Radio       radio3      = new Radio(Radio.Band.FM, Radio.FM_SPECTRUM[1]);
        BadRadio    bad_radio   = new BadRadio();

        bad_radio.on = true;
        bad_radio.volume = 9001;
        bad_radio.channel = -1100;
        System.out.println(bad_radio);

        //radio.volume = 9001;

        // call static features
        //System.out.println("AM Spectrum: " + Arrays.toString(Radio.AM_SPECTRUM));
        //System.out.println("FM Spectrum: " + Arrays.toString(Radio.FM_SPECTRUM));
        //System.out.println("Bands: {" + Radio.Band.AM + ", " + Radio.Band.FM +"}");

        radio.power();
        radio.increaseVolume();
        radio.increaseChannel();
        radio.setBand(Radio.Band.AM);

        for(int step = 0; step < 10; step++)
            radio.increaseVolume();

        for(int step = 0; step < 10; step++)
            radio.increaseChannel();

        // implicitly call toString
        System.out.println(radio1);

        //test for equality
        if(radio2 == radio3) System.out.println(radio2 + " == " + radio3);
        else                 System.out.println(radio2 + " != " + radio3);
        
        if(radio2.equals(radio3))   System.out.println(radio2 + " == " + radio3);
        else                        System.out.println(radio2 + " != " + radio3);
    }
}