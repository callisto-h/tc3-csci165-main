public class Radio{
    
    // static class features
    public static enum          Band{AM, FM};                 // collection of constant integers to be used symbollically
    public static final int[]   AM_SPECTRUM = {535, 1700};    // minimum and maximum spectrum values for AM
    public static final int[]   FM_SPECTRUM = {88, 108};      // minimum and maximum soectrum values for FM
    public static final int     VOLUME_MAX  = 30;
    public static final int     VOLUME_MIN  = 0;   

    // non-static instance features
    // each instance will get unique copies of these variables
    // this information should be hidden from public access
    private int     volume  = 0;
    private boolean on      = false;
    private Band    band    = Band.FM;
    private double  channel = FM_SPECTRUM[0];

    // constructors: define various ways for instances to be created
    public Radio(){} // no argument constructor

    public Radio(Band band){
        setBand(band);
    }

    public Radio(Band band, double channel){
        // call overloaded constructor
        this(VOLUME_MIN, band, channel);

    }
    public Radio(int volume, Band band, double channel){
        this.on     = true;
        this.volume = volume;
        this.band   = band;
        setChannel(channel);
    }

    // public interface
    // route all external interaction through these methods
    public void increaseVolume(){
        if(volume < VOLUME_MAX) ++volume;
    }

    public void decreaseVolume(){
        if(volume > VOLUME_MIN) --volume;
    }

    public int getVolume(){
        return volume;
    }

    public void setBand(Band band){
        if(band == Band.AM) this.channel = AM_SPECTRUM[0];
        else this.channel = FM_SPECTRUM[0];
        this.band = band;
    }

    public Band getBand(){
        return band;
    }

    public void increaseChannel(){
        if(this.band == Band.AM && this.channel < AM_SPECTRUM[1]){
            channel++;
            return;
        }
        if(this.band == Band.AM && this.channel == AM_SPECTRUM[1]){ 
            channel = AM_SPECTRUM[0];
            return;
        }
        if(this.band == Band.FM && this.channel < FM_SPECTRUM[1]){
            channel++;
            return;
        }
        if(this.band == Band.FM && this.channel == FM_SPECTRUM[1]){ 
            channel = FM_SPECTRUM[0];
            return;
        }
    }

    public void decreaseChannel(){
        if(this.band == Band.AM && this.channel > AM_SPECTRUM[0]){
            channel--;
            return;
        }
        if(this.band == Band.AM && this.channel == AM_SPECTRUM[0]){ 
            channel = AM_SPECTRUM[1];
            return;
        }
        if(this.band == Band.FM && this.channel > FM_SPECTRUM[0]){
            channel--;
            return;
        }
        if(this.band == Band.FM && this.channel == FM_SPECTRUM[0]){ 
            channel = FM_SPECTRUM[1];
            return;
        }
    }

    public void setChannel(double channel){
        if(this.band == Band.AM && AMChannelIsCorrect(channel)){
            this.channel = channel;
            return;
        }
        if(this.band == Band.FM && FMChannelIsCorrect(channel)){
            this.channel = channel;
            return;
        }
    }

    // overloaded setChannel
    public void setChannel(){
        setBand(this.band);
    }

    // private helpers. No need to expose this behavior. Just for decomposition
    private boolean AMChannelIsCorrect(double channel){
        return channel >= AM_SPECTRUM[0] && channel <= AM_SPECTRUM[1];
    }

    private boolean FMChannelIsCorrect(double channel){
        return channel >= FM_SPECTRUM[0] && channel <= FM_SPECTRUM[1];
    }

    public void power(){
        on = !on;
    }

    @Override
    public String toString(){
        String state = "";
        if(on) state = (band == Band.FM  ? "FM: " : "AM: ") + channel + " Volume: " + volume;
        else   state = "Radio Off";
        return state;
    }

    public boolean equals(Radio otherRadio){
        return  this.on         == otherRadio.on        &&
                this.channel    == otherRadio.channel   &&
                this.band       == otherRadio.band      &&
                this.volume     == otherRadio.volume;
    }
}