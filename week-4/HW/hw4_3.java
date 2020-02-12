import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class hw4_3{
    private final static int ROWS = 50;
    private final static int COLUMNS = 20;

    public static void main(String[] args) {
        int[][] numbers = new int[ROWS][COLUMNS];
        fillArray(numbers);

        printRow(numbers, 0, 3);

        System.out.printf("Row with least change: %d\n", smallestChange(numbers));
    }

    public static void fillArray(int[][] matrix){
        try{
            File file = new File("number_list.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            for(int i = 0; i < COLUMNS; i++){ // column major order
                for(int j = 0; j < ROWS; j++){
                    matrix[j][i] = Integer.parseInt(br.readLine()); // column major 
                }// ends columns loop
            }// ends rows loop

            fr.close();
            br.close();
        }
        catch(IOException e){
            System.out.println("LOL IOE");
        }
    }
    
    public static void printRow(int[][] matrix, int row, int num_cols) {
        for(int i = 1; i < COLUMNS + 1; i ++){
            System.out.printf("%5d", matrix[row][i - 1]);
            if(i % num_cols == 0) System.out.println(); // inserts line break every `num_cols` prints
        }
        System.out.println();
        
    }

    public static int smallestChange(int[][] matrix){
        // returns the index of the row that has the smallest difference
        // between MAX and MIN
        int min_index = 0;
        for(int i = 0; i < ROWS; i++){
            int min_change = findMaxOfRow(matrix, min_index) - findMinOfRow(matrix, min_index);
            int current_change = findMaxOfRow(matrix, i) - findMinOfRow(matrix, i);

            if(current_change < min_change){
                min_index = i;
            }
        }
        return min_index;
    }


    public static int findMaxOfRow(int[][] matrix, int row) {
        int max = matrix[row][0]; // grabs first item in specified row
        for (int i = 0; i < COLUMNS; i++) {
            int current = matrix[row][i]; // only column changes
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static int findMinOfRow(int[][] matrix, int row) {
        int min = matrix[row][0]; // grabs first item in specified row
        for (int i = 0; i < COLUMNS; i++) {
            int current = matrix[row][i]; // only columnn changes
            if (current < min) {
                min = current;
            }
        }
        return min;
    }
    
}