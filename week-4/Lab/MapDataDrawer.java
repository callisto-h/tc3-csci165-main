import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Lots of messy code that I planned on refactoring 
 * but was on a serious time crunch, next lab is
 * going to be much nicer and properly decomposed
 */

class MapDataDrawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    // setting global variables ... I didn't really know
    // what static actually did when I wrote this. neat.
    public static int[][] data;
    public static int COLUMNS;
    public static int ROWS;
    public static int MAX;
    public static int MIN;

    public MapDataDrawer() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("Elevation");
        window.setSize(COLUMNS, ROWS + 20);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderElevation(g);
        indexOfLowestElevPath(g);
    }

    private void renderElevation(Graphics g){

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;

        // scans through array in row major order but 
        // draws to the canvas in column major order
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                int color = computeColor(data[i][j]); // gets the current colorvalue for the elevation. [0-255]
                g2d.setColor(new Color(color, color, color));
                g2d.fillRect(j , i , 1 , 1 ); // draws in column major order
            }
        }
    }// end renderElevation
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Error -- please enter one filename as command line arg.");
        }
        else{
            String filename = args[0];
            int[] colsByRows = dissectFilename(filename);
            COLUMNS = colsByRows[0]; // initializes columns
            ROWS = colsByRows[1]; // initializes rows

            arrayBuilder(filename);

            findMax();
            findMin();
            System.out.printf("MAX ELEVATION: %d\n", MAX);
            System.out.printf("MIN ELEVATION: %d\n", MIN);

        }

        EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
        MapDataDrawer ex = new MapDataDrawer();
        ex.setVisible(true);
        }
        });

    } // end main

    public static int[] dissectFilename(String filename) {
        // takes the filename entered on the command line
        // and dissects it into the columns value and rows
        // values.
        int underscoreIndex = filename.indexOf('_');
        int xIndex = filename.indexOf('x');
        int dotIndex = filename.indexOf('.');

        int[] colsByRows = new int[2];
        // converts the string numbers to ints
        colsByRows[0] = Integer.parseInt(filename.substring(underscoreIndex + 1, xIndex));
        colsByRows[1] = Integer.parseInt(filename.substring(xIndex + 1, dotIndex));

        return colsByRows;
    } // end dissectFilename

    public static void arrayBuilder(String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            data = new int[ROWS][COLUMNS];

            for (int i = 0; i < ROWS; i++) { // read row major order
                for (int j = 0; j < COLUMNS; j++) {
                	data[i][j] = sc.nextInt();
                }
            }
            sc.close();
        } catch (FileNotFoundException f) {
            System.out.print("404 File not found");
        }
    } // end arrayBuilder
    
    public static void findMax(){
        int max = data[0][0]; // grabs first item
        for (int i = 0; i < ROWS; i++) {
            int current = findMaxOfRow(i); // just gets the max of each row
            if (current > max) {
                max = current;
            }
        }
        MAX = max; // sets global variable
    } // end findMax

    public static void findMin() {
        int min = data[0][0]; // grabs first item
        for (int i = 0; i < ROWS; i++) {
            int current = findMinOfRow(i); // just gets the max of each row
            if (current < min) {
                min = current;
            }
        }
        MIN = min; // sets global variable
    } // end findMin

    public static int findMaxOfRow(int row) {
        int max = data[row][0]; // grabs first item in specified row
        for (int i = 0; i < COLUMNS; i++) {
            int current = data[row][i]; // only column changes
            if (current > max) {
                max = current;
            }
        }
        return max;
    } //end findMaxOfRow

    public static int findMinOfRow(int row) {
        int min = data[row][0]; // grabs first item in specified row
        for (int i = 0; i < COLUMNS; i++) {
            int current = data[row][i]; // only columnn changes
            if (current < min) {
                min = current;
            }
        }
        return min;
    } // end findMinOfRow

    public static int computeColor(int elevation){
        double percent = (elevation - MIN) / (double)(MAX - MIN);
        int rgb = (int)(percent * 255); // gets the appropriate RGB value for relative hight from MIN or MAX
        return rgb;
    }

    public static int drawLowestElevPath(Graphics g, int row, String color){

        // I would have refactored this method into two, one that 
        // iterated through the COLS, and one that iterated through
        // the three choices -- would have been much more neat
        // to 


        Graphics2D g2d = (Graphics2D) g;

        // enables different color line painting
        if(color.equals("green")){
            g2d.setColor(new Color(0, 255, 0));
        }
        else{
            g2d.setColor(new Color(255, 0, 0));
        }        

        int top, middle, bottom;
        int totalElevationChange = 0;
        
        for(int i = 0; i < COLUMNS; i++){
            g2d.fillRect(i , row , 1 , 1 );
            if(i == COLUMNS -1) break;
            int currentElevation = data[row][i];

            // we need to check to make sure that the current row that 
            // we are on is not either the very first or last index.
            // if it is, checking "up" or "down" would yield an out of
            // bounds error. To get around this, we are manually assigning
            // a height to the "non-existant" altitutes that will never
            // be selected by our pathing algo.


            if(row == 0){
                top = 100000; // sets to arbitrary value
                bottom = data[row + 1][i + 1];
            }
            else if(row == ROWS - 1){
                top = data[row - 1][i + 1];
                bottom = 100000; // sets to arbitrary value
            }
            else{
                top = data[row - 1][i + 1];
                bottom = data[row + 1][i + 1];
            }
            middle = data[row][i + 1]; // will always need to eval

            int topChange = Math.abs(currentElevation - top);
            int middleChange = Math.abs(currentElevation - middle);
            int bottomChange = Math.abs(currentElevation - bottom);

            // checks to see if middle path is smaller or equal to the others,
            // if it is, it will add the change in elevation to our sum, but
            // not alter the row variable
            if(middleChange <= topChange && middleChange <= bottomChange){
                totalElevationChange += middleChange;
            }
            else if(topChange < bottomChange){
                totalElevationChange += topChange;
                row--; // selects top row
            }
            else if(bottomChange < topChange){
                totalElevationChange += bottomChange;
                row++; // selects bottom row
            }
            else{
                Random r = new Random();
                int coinflip = r.nextInt(2);
                if(coinflip == 0){
                    totalElevationChange += topChange;
                    row--; // selects top row
                }
                else{
                    totalElevationChange += bottomChange;
                    row++; // selects bottom row
                }
            }
            
        }
        return totalElevationChange;
    }

    public static int indexOfLowestElevPath(Graphics g){

        // yikes I hate that this is three separate loops ... it sucks but works

        // loops through and draws the paths, adds each elevation 
        // total to an array
        int[] elevations = new int[ROWS];
        for(int i = 0; i < ROWS; i++){
            elevations[i] = drawLowestElevPath(g, i, "red");
        }

        // loops through the elevations and finds the smallest one
        int minValue = elevations[0];
        for(int i = 0; i < elevations.length; i++){
            int currentValue = elevations[i];
            if(currentValue < minValue){
                minValue = currentValue;
            }
        }
        System.out.printf("MIN ROW ELEVATION: %d\n", minValue);

        // loops through and finds the index of the min value
        int j = 0;
        for(; j < elevations.length; j++){
            if(elevations[j] == minValue){
                drawLowestElevPath(g, j, "green");
                break;
            }
        }
        System.out.printf("MIN ROW #: %d\n", j);
        return minValue;
    }
} // end class
