package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.EventDTO;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);
   // EventDTO getEventById(Long id);
    Optional<EventDTO> getEventById(Long id);
    List<EventDTO> getAllEvents();
    EventDTO updateEvent(Long id, EventDTO eventDTO);
    void deleteEvent(Long id);
    List<EventDTO> getEventsByVenue(Long venueId);
    List<EventDTO> getEventsByOrganizer(Long organizerId);
}
