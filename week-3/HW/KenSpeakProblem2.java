import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.IOException;

public class KenSpeakProblem2{

    public static void main(String[] args){
        try{
            String inputFileName = "numbers.txt";
            FileReader fr = new FileReader(inputFileName);
            BufferedReader br = new BufferedReader(fr);

            String outputFileName = "encodedNumbers.txt";
            FileWriter fw = new FileWriter(outputFileName);
            BufferedWriter bw = new BufferedWriter(fw);
            


            while(true){
                String line = br.readLine(); // lol breadlines
                if (line == null) break;
                String translation = translate(line) + '\n';

                bw.write(translation);
            }

            bw.flush();
            bw.close();
            fr.close();
        }
        catch(IOException ioe){
            System.out.println("IOE");
        }
    }

    public static String translate(String line){
        String codes = "*BEA@FK%RM";
        char[] translation = new char[line.length()]; //new char array of LINE length

        for(int i = 0; i < line.length(); i++){
            int num = Character.getNumericValue(line.charAt(i));
            translation[i] = codes.charAt(num);
        }
        String translationString = new String(translation);
        return translationString;
    }
}