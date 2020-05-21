package com.epam.ticketservice.controllers.request;

import javax.validation.constraints.NotNull;

public class TicketRequest {

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    @NotNull(message = "ticketname cannot be empty")
    String ticketName;
}
