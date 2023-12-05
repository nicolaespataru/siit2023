package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiathlonCalculatorTest {

    @Test
    public void testRankings() {

        List<BiathlonAthlete> athletes = new ArrayList<>();
        BiathlonAthlete athlete1 = new BiathlonAthlete();
        BiathlonAthlete athlete2 = new BiathlonAthlete();
        BiathlonAthlete athlete3 = new BiathlonAthlete();

        athlete1.setAthleteName("Ion Andrei");
        athlete1.setFinalTime(10);


        athlete2.setAthleteName("Marian Dumitru");
        athlete2.setFinalTime(20);


        athlete3.setAthleteName("George Costel");
        athlete2.setFinalTime(30);

        athletes.add(athlete1);
        athletes.add(athlete2);
        athletes.add(athlete3);

        Collections.sort(athletes);

        assertEquals("Ion Andrei", athletes.get(0).getAthleteName());
        assertEquals("Marian Dumitru", athletes.get(1).getAthleteName());
        assertEquals("George Costel", athletes.get(2).getAthleteName());

    }
}