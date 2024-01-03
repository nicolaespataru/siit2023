package org.example;

import java.util.Queue;

public class FestivalGate {

    private final TicketQueue ticketQueue;

    public FestivalGate(){
        ticketQueue = new TicketQueue();
    }

    public synchronized Queue<TicketType> getTickets() {
       return ticketQueue.getTickets();
    }

    public synchronized void validateTicket(TicketType ticketType) {
        ticketQueue.addTicket(ticketType);
        ticketType.validateTicket();
    }

}
