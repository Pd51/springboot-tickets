package com.epam.ticketservice.controllers;

import com.epam.ticketservice.controllers.request.TicketRequest;
import com.epam.ticketservice.exception.TicketException;
import com.epam.ticketservice.models.Ticket;
import com.epam.ticketservice.services.TicketsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<?> getTicket(@PathVariable("id") int id) throws TicketException
    {
      return  new ResponseEntity<>(ticketsService.getTicket(id),HttpStatus.OK);
    }
    @PostMapping(path = "/")
    ResponseEntity<?> addTicket(@Valid @RequestBody TicketRequest ticketRequest) throws TicketException
    {
        return new ResponseEntity<>(ticketsService.addTicket(modelMapper.map(ticketRequest,Ticket.class)),HttpStatus.CREATED);
    }

    @GetMapping(path = "/")
    ResponseEntity<?>  getAllTickets()
    {
        return  new ResponseEntity<>(ticketsService.getAllTickets(),HttpStatus.OK);
    }






}
