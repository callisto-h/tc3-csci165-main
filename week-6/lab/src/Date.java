public class Date {

    // Class Level Instance Variables
    private int month = 1;
    private int day = 1;
    private int year = 1000;

    // static class variables
    public static final String[] months = { "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December" };

    public Date() {
    } // no argument constructor

    public Date(int year) { // constructor to accept just the year
        setYear(year);
    }

    public Date(String month, int day, int year) { // constructor to accept month as String
        setMonth(month); // call overloaded setMonth(String)
        setDay(day);
        setYear(year);
    }

    public Date(int month, int day, int year) { // constructor with all ints
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    // Copy Constructor
    public Date(Date toClone) {
        // catches nullpointerexception
        if (toClone == null) {
            return;
        }

        this.day = toClone.day;
        this.month = toClone.month;
        this.year = toClone.year;
    }

    // overloaded setMonth
    public void setMonth(String month) {
        int month_num = getMonthNumber(month); // call helper method
        if (month_num > 0) // is it valid?
            this.month = month_num; // if so, set it. If not, leave it
    }

    // private helper method
    private int getMonthNumber(String month) {
        for (int i = 0; i < months.length; ++i) { // loop through months array
            if (month.equalsIgnoreCase(months[i])) // test for equality
                return i + 1; // found it, return index + 1
        }
        return 0; // didn't find it, return 0
    }

    // instance methods
    public void setMonth(int m) {
        // perform some domain validation
        if (m >= 1 && m <= 12)
            month = m;
        else
            month = 1;
    } // end setMonth

    public int getMonth() {
        return month;
    } // end getMonth

    public void setDay(int d) {
        if (d >= 1 && d <= 31)
            day = d;
        else
            day = 1;
    } // end setDay

    public int getDay() {
        return day;
    } // end getDay

    public void setYear(int y) {
        if (y >= 1000 && y <= 9999)
            year = y;
        else
            year = 1000;
    } // end setYear

    public int getYear() {
        return year;
    } // end getYear

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    @Override
    public boolean equals(Object otherObject) {

        // checks to make sure otherObject is same type of Class
        if (otherObject == null || otherObject.getClass() != this.getClass()) {
            return false;
        }

        // casts otherObject as date for comparison of fields
        Date d = (Date) otherObject;

        return this.day == d.day && this.month == d.month && this.year == d.year;
    }

    public int compareTo(Date otherDate) {
        if (otherDate == null)
            return 1;

        if (this.year < otherDate.year)
            return -1;
        if (this.year > otherDate.year)
            return 1;

        if (this.month < otherDate.month)
            return -1;
        if (this.month > otherDate.month)
            return 1;

        if (this.day < otherDate.day)
            return -1;
        if (this.day > otherDate.day)
            return 1;

        /* they are equal */ return 0;
    }
} // end class
