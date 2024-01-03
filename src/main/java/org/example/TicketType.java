package org.example;

public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;
    public String state = "Invalid";
    public void validateTicket(){
        this.state="Valid";
    }

    public String getTicketState(){
        return this.state;
    }
}

