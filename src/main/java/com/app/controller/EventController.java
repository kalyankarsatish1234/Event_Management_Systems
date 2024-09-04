package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.EventDTO;
import com.app.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Create a new Event
    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventDTO createdEvent = eventService.createEvent(eventDTO);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

//    // Get Event by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
//        EventDTO eventDTO = eventService.getEventById(id);
//        return ResponseEntity.ok(eventDTO);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id){
        Optional<EventDTO> event = eventService.getEventById(id);
        return  event.isPresent() ?  ResponseEntity.ok(event.get()): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with ID " +id+ " not found");
    }


    // Get all Events
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    // Update an existing Event by ID
    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = eventService.updateEvent(id, eventDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    // Delete an Event by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    // Get Events by Venue ID
    @GetMapping("/venue/{venueId}")
    public ResponseEntity<List<EventDTO>> getEventsByVenue(@PathVariable Long venueId) {
        List<EventDTO> events = eventService.getEventsByVenue(venueId);
        return ResponseEntity.ok(events);
    }

    // Get Events by Organizer ID
    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<List<EventDTO>> getEventsByOrganizer(@PathVariable Long organizerId) {
        List<EventDTO> events = eventService.getEventsByOrganizer(organizerId);
        return ResponseEntity.ok(events);
    }
}
