import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class hw4_2{
    private final static int ROWS = 50;
    private final static int COLUMNS = 20;

    public static void main(String[] args){
        

        int[][] numbers = new int[ROWS][COLUMNS];
        fillArray(numbers);
        
        int max = findMax(numbers);
        System.out.printf("MAX: %d\n", max);

        int min = findMin(numbers);
        System.out.printf("MIN: %d\n", min);

        int minCol0 = findMinOfColumn(numbers, 0);
        int maxCol0 = findMaxOfColumn(numbers, 0);
        int minRow0 = findMinOfRow(numbers, 0);
        int maxRow0 = findMaxOfRow(numbers, 0);

        System.out.printf("COLUMN 0\nMAX: %d - MIN: %d\nROW 0\nMAX: %d - MIN: %d\n", minCol0, maxCol0, minRow0, maxRow0);

        for(int i = 0; i < COLUMNS; i++){
            System.out.printf("%d, ", numbers[0][i]);
        }
    }

    public static void fillArray(int[][] matrix){
        try{
            File file = new File("number_list.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            for(int i = 0; i < ROWS; i++){ // row major order
                for(int j = 0; j < COLUMNS; j++){
                    matrix[i][j] = Integer.parseInt(br.readLine()); 
                }// ends columns loop
            }// ends rows loop

            fr.close();
            br.close();
        }
        catch(IOException e){
            System.out.println("LOL IOE");
        }
    }

    public static int findMax(int[][] matrix){
        int max = matrix[0][0]; //grabs first item
        for(int i = 0; i < ROWS; i ++){
            int current = findMaxOfRow(matrix, i); // just gets the max of each row
            if (current > max){
                max = current;
            }
        }
        return max;
    }

    public static int findMin(int[][] matrix){
        int min = matrix[0][0]; // grabs first item
        for (int i = 0; i < ROWS; i++) {
            int current = findMinOfRow(matrix, i); // just gets the max of each row
            if (current < min) {
                min = current;
            }
        }
        return min;
    }


    public static int findMaxOfRow(int[][] matrix, int row){
        int max = matrix[row][0]; // grabs first item in specified row
        for(int i = 0; i < COLUMNS; i++){
            int current = matrix[row][i]; // only column changes
            if (current > max){
                max = current;
            }
        }
        return max;
    }

    public static int findMinOfRow(int[][] matrix, int row){
        int min = matrix[row][0]; // grabs first item in specified row
        for (int i = 0; i < COLUMNS; i++) {
            int current = matrix[row][i]; // only columnn changes
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    public static int findMaxOfColumn(int[][] matrix, int column){
        int max = matrix[0][column]; // grabs first item in specified column
        for (int i = 0; i < ROWS; i++) {
            int current = matrix[i][column]; // only row changes
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static int findMinOfColumn(int[][] matrix, int column){
        int min = matrix[0][column]; // grabs first item in specified column
        for (int i = 0; i < ROWS; i++) {
            int current = matrix[i][column]; //only row changes
            if (current < min) {
                min = current;
            }
        }
        return min;
    }
}
