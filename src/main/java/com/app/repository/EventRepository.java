package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Event;


public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByVenueId(Long venueId);
    List<Event> findByOrganizerId(Long organizerId);
 
    
}
