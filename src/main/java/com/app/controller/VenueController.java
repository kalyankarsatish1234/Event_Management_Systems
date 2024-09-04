package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VenueDTO;
import com.app.service.VenueService;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    // Create a new Venue
    @PostMapping
    public ResponseEntity<VenueDTO> createVenue(@RequestBody VenueDTO venueDTO) {
        VenueDTO createdVenue = venueService.createVenue(venueDTO);
        return new ResponseEntity<>(createdVenue, HttpStatus.CREATED);
    }

    // Get Venue by ID
    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Long id) {
        VenueDTO venueDTO = venueService.getVenueById(id);
        return ResponseEntity.ok(venueDTO);
    }

    // Get all Venues
    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        List<VenueDTO> venues = venueService.getAllVenues();
        return ResponseEntity.ok(venues);
    }

    // Update an existing Venue by ID
    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> updateVenue(@PathVariable Long id, @RequestBody VenueDTO venueDTO) {
        VenueDTO updatedVenue = venueService.updateVenue(id, venueDTO);
        return ResponseEntity.ok(updatedVenue);
    }

    // Delete a Venue by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return ResponseEntity.noContent().build();
    }
}
