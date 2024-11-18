package com.task.management.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.*;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String task;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Submitted_Time", updatable = false)
    private Date Submitted_Time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getSubmitted_Time() {
        return Submitted_Time;
    }

    public void setSubmitted_Time(Date submitted_Time) {
        Submitted_Time = submitted_Time;
    }



    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", Submitted_Time=" + Submitted_Time +
                '}';
    }
}

