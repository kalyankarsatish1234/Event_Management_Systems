package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EventDTO;
import com.app.entity.Event;
import com.app.entity.Organizer;
import com.app.entity.Venue;
import com.app.exception.EventNotFoundException;
import com.app.exception.OrganizerNotFoundException;
import com.app.exception.VenueNotFoundException;
import com.app.repository.EventRepository;
import com.app.repository.OrganizerRepository;
import com.app.repository.VenueRepository;
import com.app.service.EventService;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setEventName(eventDTO.getEventName());
        event.setEventDate(eventDTO.getEventDate());
        event.setDescription(eventDTO.getDescription());
        Organizer organizer = organizerRepository.findById(eventDTO.getOrganizerId())
                .orElseThrow(() -> new OrganizerNotFoundException("Organizer with ID " + eventDTO.getOrganizerId() + " not found"));
        event.setOrganizer(organizer);

        Venue venue = venueRepository.findById(eventDTO.getVenueId())
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID " + eventDTO.getVenueId() + " not found"));
        event.setVenue(venue);

        Event savedEvent = eventRepository.save(event);
        return convertToDTO(savedEvent);
    }

//    @Override
//    public EventDTO getEventById(Long id) {
//        return eventRepository.findById(id)
//                .map(this::convertToDTO)
//                .orElseThrow(() -> new EventNotFoundException("Event with ID " + id + " not found"));
//    }
   public  Optional<EventDTO> getEventById(Long id){
        return eventRepository.findById(id).map(  event -> convertToDTO(event));
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event with ID " + id + " not found"));

        event.setEventName(eventDTO.getEventName());
        event.setEventDate(eventDTO.getEventDate());
        event.setDescription(eventDTO.getDescription());
        event.setOrganizer(organizerRepository.findById(eventDTO.getOrganizerId()).orElseThrow(() -> new OrganizerNotFoundException("Orgniazer with ID " + id + "not found")));
        event.setVenue(venueRepository.findById(eventDTO.getVenueId()).orElseThrow(() -> new VenueNotFoundException("Venue with ID "+id +" not found")));

        Event updatedEvent = eventRepository.save(event);
        return convertToDTO(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventDTO> getEventsByVenue(Long venueId) {
        return eventRepository.findByVenueId(venueId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setOrganizerId(event.getOrganizer() != null ? event.getOrganizer().getId() : null);
        eventDTO.setVenueId(event.getVenue() != null ? event.getVenue().getId() : null);
        return eventDTO;
    }
}
