package io.github.andygabler.swimsetplannerbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(
    name = "SWIM_SET",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NAME"})
    }
)
public class SwimSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "REP_LENGTH")
    private int repLength;

    @Column(name = "REP_COUNT")
    private int repCount;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LABEL_TEXT")
    @JsonIgnore
    private String labelText;

    @Transient
    private String[] labels;
}
