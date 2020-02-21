class Marker 
{ 
    public static void main(String[] args) 
    { 
        printGrade(90);
    } 

    /**
     * This method will print a message based a provided value. Only one message should be printed
     * 
     * @param mark - the mark used to determine the message.
     */
    public static void printGrade(int mark) 
    { 
        if (mark >= 85) 
            System.out.println("High Distinction"); 
        if (mark >= 75) 
            System.out.println("Distinction"); 
        if (mark >= 65) 
            System.out.println("Credit"); 
        if (mark >= 50) 
            System.out.println("Pass"); 
        if (mark >= 45) 
            System.out.println("Concessional Pass"); 
        if (mark < 45) 
            System.out.println("Fail"); 
    } 
} 
