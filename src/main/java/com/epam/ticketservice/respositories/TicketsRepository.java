package com.epam.ticketservice.respositories;

import com.epam.ticketservice.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface TicketsRepository extends CrudRepository<Ticket,Integer> {
    Ticket findByTicketName(String name);
}
