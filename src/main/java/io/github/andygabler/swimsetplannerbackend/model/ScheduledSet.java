package io.github.andygabler.swimsetplannerbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(
    name = "SCHEDULED_SET",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"DATE_SCHEDULED", "SET_ORDER"})
    }
)
public class ScheduledSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "DATE_SCHEDULED")
    private Date dateScheduled;

    @Column(name = "SET_ORDER")
    private int order;

    @ManyToOne
    private SwimSet scheduledSet;
}
