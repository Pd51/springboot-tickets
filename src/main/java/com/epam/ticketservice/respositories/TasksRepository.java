package com.epam.ticketservice.respositories;

import com.epam.ticketservice.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TasksRepository extends CrudRepository<Task,Integer> {
}
