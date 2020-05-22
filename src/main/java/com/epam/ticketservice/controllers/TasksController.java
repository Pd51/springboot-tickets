package com.epam.ticketservice.controllers;

import com.epam.ticketservice.controllers.request.TaskRequest;
import com.epam.ticketservice.exception.TicketException;
import com.epam.ticketservice.models.Task;
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
@RequestMapping(path = "/tasks")
public class TasksController {

    @Autowired
    TicketsService ticketsService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping(path = "/")
    ResponseEntity<?> addTask(@Valid @RequestBody TaskRequest taskRequest)throws TicketException
    {
        return  new ResponseEntity<>(ticketsService.addTask(modelMapper.map(taskRequest,Task.class)),HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?>  getAllTasks(@PathVariable("id") int id)throws TicketException
    {
        return  new ResponseEntity<>(ticketsService.getAllTasks(id), HttpStatus.OK);
    }
    
}
