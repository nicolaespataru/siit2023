package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {
    @Test
    public void testCSVParser() {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";

        List<BiathlonAthlete> athletes = CSVReader.read(csvData);

        assertEquals(3, athletes.size());
        assertEquals("Umar Jorgson", athletes.get(0).getAthleteName());
        assertEquals("Jimmy Smiles", athletes.get(1).getAthleteName());
        assertEquals("Piotr Smitzer", athletes.get(2).getAthleteName());
    }
}