package com.epam.ticketservice.controllers.request;

import javax.validation.constraints.NotNull;

public class TaskRequest {

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "{constraints.NotEmpty.message}")
    int ticketId;
    @NotNull(message = "{constraints.NotEmpty.message}")
    String description;
}
