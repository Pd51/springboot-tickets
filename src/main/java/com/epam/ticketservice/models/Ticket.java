package com.epam.ticketservice.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {


    @Id
    @GeneratedValue
    int id;
    String ticketName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketId")
    List<Task> taskList=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }


    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }


}
