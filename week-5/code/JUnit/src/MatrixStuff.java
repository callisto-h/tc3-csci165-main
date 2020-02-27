import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MatrixStuff{

    public static void fillArray(int[][] matrix){
        try{
            File            file    = new File("MOCK_DATA.txt");
            FileReader      fr      = new FileReader(file);
            BufferedReader  br      = new BufferedReader(fr);

            for(int i = 0; i < matrix.length; i++)
                for(int j = 0; j < matrix[0].length; j++)
                    matrix[i][j] = Integer.parseInt(br.readLine()); 

            fr.close();
            br.close();
        }
        catch(IOException e){
            System.out.println("LOL IOE");
        }
    }

    public static int findMax(int[][] matrix){
        int max = matrix[0][0];
        for(int i = 0; i < matrix.length; i ++){
            int current = findMaxOfRow(matrix, i); 
            if (current > max) max = current;
        }
        return max;
    }

    public static int findMin(int[][] matrix){
        int min = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int current = findMinOfRow(matrix, i);
            if (current < min) min = current;
        }
        return min;
    }

    public static int findMaxOfRow(int[][] matrix, int row){
        int max = matrix[row][0];
        for(int i = 0; i < matrix[0].length; i++){
            int current = matrix[row][i];
            if (current > max) max = current;
        }
        return max;
    }

    public static int findMinOfRow(int[][] matrix, int row){
        int min = matrix[row][0];
        for (int i = 0; i < matrix[0].length; i++) {
            int current = matrix[row][i];
            if (current < min) min = current;
        }
        return min;
    }

    public static int findMaxOfColumn(int[][] matrix, int column){
        int max = matrix[0][column];
        for (int i = 0; i < matrix.length; i++) {
            int current = matrix[i][column]; 
            if (current > max) max = current;
        }
        return max;
    }

    public static int findMinOfColumn(int[][] matrix, int column){
        int min = matrix[0][column];
        for (int i = 0; i < matrix.length; i++) {
            int current = matrix[i][column];
            if (current < min) min = current;
        }
        return min;
    }
}
