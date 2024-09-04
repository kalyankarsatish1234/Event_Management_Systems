package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String eventName;
    private LocalDate eventDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
}
