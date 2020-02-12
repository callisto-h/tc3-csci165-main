import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class hw4_1{

    private static List<Integer> al;

    public static void main(String[] args){
        fillArray();

        // prints all of the values

        for(int i = 0; i < al.size(); i++){
            System.out.println(al.get(i).intValue());
        }

        // prints the mins and maxes

        int max = findMax();
        int min = findMin();
        System.out.printf("MAX: %d\nMIN: %d\n", max, min);

        // prints the percentage changes
        int[] percents = percentChange();
        for(int i = 0; i < percents.length; i++){
            System.out.println(percents[i]);
        }
    }

    public static void fillArray(){
        try{
            File file = new File("number_list.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            al = new ArrayList<Integer>(0);

            while(true){
                String line = br.readLine(); // lol breadlines
                if(line == null) break;
                al.add(Integer.valueOf(line));
            }
            fr.close();
            br.close();
        }
        catch(IOException e){
            System.out.println("LOL IOE");
        }
    }


    public static int findMax(){
        int max = al.get(0).intValue(); // sets the max to the first value in `al`
        for(int i = 0; i < al.size(); i++){
            int current = al.get(i).intValue();
            if(current > max){
                max = current;
            }
        }
        return max;
    }

    public static int findMin(){
        int min = al.get(0).intValue(); // sets the max to the first value in `al`
        for (int i = 0; i < al.size(); i++) {
            int current = al.get(i).intValue();
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    public static int[] percentChange(){
        int[] percents = new int[al.size() - 1]; //new array that is one smaller than `al`

        for(int i = 0; i < percents.length; i++){
            int current = al.get(i).intValue();
            int next = al.get(i+1).intValue();

            int difference = next - current; //finds change between adjascent elements
            percents[i] = difference * 100 / current; // finds percent, might be negative
        }
        return percents;
    }

}