package org.example;

import java.util.Collections;
import java.util.List;

public class DisplayResults {
    private final ConsoleScanner ConsoleScanner;

    public DisplayResults() {

        ConsoleScanner = new ConsoleScanner();
    }

    public void display() {
  //      String input = ConsoleScanner.readLine();
        String csvFile = "C:/CSV/CSV.csv"; // Replace with the actual path to your CSV file
        List<BiathlonAthlete> athletes = CSVReader.read(csvFile);
        // List<BiathlonAthlete> athletes = CSVReader.read(input);
        Collections.sort(athletes);

        System.out.println("Winner - " + athletes.get(0).getAthleteName() + " " +
                formatTime(athletes.get(0).getFinalTime()));
        System.out.println("Runner-up - " + athletes.get(1).getAthleteName() + " " +
                formatTime(athletes.get(1).getFinalTime()));
        System.out.println("Third Place - " + athletes.get(2).getAthleteName() + " " +
                formatTime(athletes.get(2).getFinalTime()));
    }


    //Conversie secunde -> format Minute:Secunde
    private static String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

}