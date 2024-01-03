package org.example;

import java.util.Queue;

public class FestivalStatisticsThread extends Thread{

   private FestivalGate gate;

   public FestivalStatisticsThread(FestivalGate gateInput){
       this.gate=gateInput;
   }

    @Override
    public void run() {
        while (true) {
            try {
                // Delay for 5 seconds to let people enter
                Thread.sleep(5000);
                // Read data
                Queue<TicketType> tickets = gate.getTickets();
                if (!tickets.isEmpty()) {
                    System.out.println(tickets.size() + " people entered");
                    for (TicketType type : TicketType.values()) {
                        long count = tickets.stream().filter(t -> t == type).count();
                        System.out.println(count + " people have " + type + " tickets");
                    }
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

