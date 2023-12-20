package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Writer writer = new Writer();

        String inputFileName = "input.txt";
        int targetMonth = 5;
        String outputFileName = "output.txt";


        writer.start(new String[]{inputFileName, String.valueOf(targetMonth), outputFileName});
    }
}
