package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    //input adresa CSV-ului
    public static List<BiathlonAthlete> read(String csvFile) {
        // declaram o lista de atleti ca sa adaugam la ea
        List<BiathlonAthlete> athletes = new ArrayList<>();

        // adaugam pana readline returneaza null
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // datele au split cu ,
                String[] data = line.split(",");
                // adaugam atletul
                athletes.add(new BiathlonAthlete(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return athletes;
    }
}
