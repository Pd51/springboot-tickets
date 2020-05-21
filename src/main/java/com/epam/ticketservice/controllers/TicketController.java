package com.epam.ticketservice.controllers;

import com.epam.ticketservice.controllers.request.TicketRequest;
import com.epam.ticketservice.exception.TicketException;
import com.epam.ticketservice.models.Ticket;
import com.epam.ticketservice.services.TicketsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {

    @Autowired
    TicketsService ticketsService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(path = "/{id}")
    Ticket getTicket(@PathVariable("id") int id) throws TicketException
    {
        return ticketsService.getTicket(id);
    }
    @PostMapping(path = "/")
    Ticket addTicket(@Valid @RequestBody TicketRequest ticketRequest) throws TicketException
    {
        return ticketsService.addTicket(modelMapper.map(ticketRequest,Ticket.class));
    }

    @GetMapping(path = "/")
    List<Ticket> getAllTickets()
    {
        return ticketsService.getAllTickets();
    }






}
