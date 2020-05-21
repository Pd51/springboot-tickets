package com.epam.ticketservice.exception;

import com.epam.ticketservice.models.Ticket;

public class TicketException extends Exception {
    public TicketException(String message){
        super("ticket "+message);
    }
}
