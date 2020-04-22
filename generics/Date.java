public class Date{

    // Class Level Instance Variables
    private int month;
    private int day;
    private int year;

    public Date(int m, int d, int y){
        setMonth(m);
        setDay(d);
        setYear(y);
    }
    // instance methods
    public void setMonth(int m){
        // perform some domain validation
        if(m >= 1 && m <= 12)
            month = m;
        else month = 1;
    } // end setMonth

    public int getMonth(){
        return month;
    } // end getMonth

    public void setDay(int d){
        if(d >= 1 && d <= 31)
            day = d;
        else day = 1;
    } // end setDay

    public int getDay(){
        return day;
    } // end getDay

    public void setYear(int y){
        if(y >= 1000 && y <= 9999)
            year = y;
        else year = 1000;
    } // end setYear

    public int getYear(){
        return year;
    } // end getYear

    public String toString(){
        return month + "/" + day + "/" + year;
    }

    public boolean equals(Date d){
        return  this.day    == d.day    &&
                this.month  == d.month  &&
                this.year   == d.year;
    }

} // end class
