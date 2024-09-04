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

import com.app.dto.OrganizerDTO;
import com.app.service.OrganizerService;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    // Create a new Organizer
    @PostMapping
    public ResponseEntity<OrganizerDTO> createOrganizer(@RequestBody OrganizerDTO organizerDTO) {
        OrganizerDTO createdOrganizer = organizerService.createOrganizer(organizerDTO);
        return new ResponseEntity<>(createdOrganizer, HttpStatus.CREATED);
    }

    // Get Organizer by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganizerDTO> getOrganizerById(@PathVariable Long id) {
        OrganizerDTO organizerDTO = organizerService.getOrganizerById(id);
        return ResponseEntity.ok(organizerDTO);
    }

    // Get all Organizers
    @GetMapping
    public ResponseEntity<List<OrganizerDTO>> getAllOrganizers() {
        List<OrganizerDTO> organizers = organizerService.getAllOrganizers();
        return ResponseEntity.ok(organizers);
    }

    // Update an existing Organizer by ID
    @PutMapping("/{id}")
    public ResponseEntity<OrganizerDTO> updateOrganizer(@PathVariable Long id, @RequestBody OrganizerDTO organizerDTO) {
        OrganizerDTO updatedOrganizer = organizerService.updateOrganizer(id, organizerDTO);
        return ResponseEntity.ok(updatedOrganizer);
    }

    // Delete an Organizer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }
}
