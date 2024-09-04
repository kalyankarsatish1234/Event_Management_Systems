package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EventDTO {
    private Long id;

    @NotEmpty(message = "Event name must not be empty")
    private String eventName;

    @NotNull(message = "Event date must not be null")
    private LocalDate eventDate;

    @NotEmpty(message = "Description must not be empty")
    private String description;

    @NotNull(message = "Organizer ID must not be null")
    private Long organizerId;

    @NotNull(message = "Venue ID must not be null")
    private Long venueId;
}
