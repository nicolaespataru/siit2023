package org.example;


import java.util.Random;

public class FestivalAttendeeThread extends Thread{
    private TicketType ticketType;
    private FestivalGate gate;
    private volatile Boolean attendingConcert = true;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate){
        this.ticketType=ticketType;
        this.gate=gate;
    }

    public void exitConcert() {
        attendingConcert = false;
    }

    @Override
    public void run() {
        while (attendingConcert) {
            try {
                Thread.sleep(new Random().nextInt(5000));
                gate.validateTicket(ticketType);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
