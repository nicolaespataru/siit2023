package org.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);

        statisticsThread.start();
        for (int i = 0; i < 100; i++) {
            TicketType ticketType = TicketType.values()[ThreadLocalRandom.current().nextInt(TicketType.values().length)];
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
            attendee.start();
        }
    }

}
