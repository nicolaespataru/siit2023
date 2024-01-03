package org.example;

import java.util.LinkedList;
import java.util.Queue;

class TicketQueue {
    private Queue<TicketType> ticketQueue = new LinkedList<>();

    public synchronized void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public synchronized Queue<TicketType> getTickets() {
        return ticketQueue;
    }
}
