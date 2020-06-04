package com.epam.ticketservice.services;

import com.epam.ticketservice.exception.TicketException;
import com.epam.ticketservice.models.Task;
import com.epam.ticketservice.models.Ticket;
import com.epam.ticketservice.respositories.TasksRepository;
import com.epam.ticketservice.respositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class TicketsService {

    @Autowired
    TicketsRepository ticketsRepository;

    @Autowired
    TasksRepository tasksRepository;

    public Ticket addTicket(Ticket ticket) throws TicketException {

        Ticket ticketInDb = ticketsRepository.findByTicketName(ticket.getTicketName());
        if (ticketInDb==null)
           return ticketsRepository.save(ticket);

        throw new TicketException("already exists");
    }

    public Task addTask(Task task) throws TicketException {
        Ticket ticket = getTicket(task.getId());
//        List<Task> tasksList = ticket.getTaskList();
//        if (tasksList == null) {
//            tasksList = new ArrayList<>();
//        }
//
//        tasksList.add(task);
//        ticketsRepository.save(ticket);
        tasksRepository.save(task);
        return task;
    }


    public void deleteTicket(int id) {
        ticketsRepository.deleteById(id);
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> ticketList = (List<Ticket>) ticketsRepository.findAll();

        if (ticketList == null)
            ticketList = Collections.emptyList();

        return ticketList;
    }

    public void deleteTask(int id) {
        tasksRepository.deleteById(id);
    }

    public Ticket getTicket(int id) throws TicketException {

        Optional<Ticket> ticket = ticketsRepository.findById(id);
        if (ticket.isPresent()) {
            return ticket.get();
        }
        throw new TicketException("not found");
    }

    public List<Task> getAllTasks(int id) throws TicketException {
        return getTicket(id).getTaskList();
    }

}
