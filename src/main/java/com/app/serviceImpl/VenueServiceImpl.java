package com.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.VenueDTO;
import com.app.entity.Venue;
import com.app.exception.VenueNotFoundException;
import com.app.repository.VenueRepository;
import com.app.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public VenueDTO createVenue(VenueDTO venueDTO) {
        Venue venue = new Venue();
        venue.setName(venueDTO.getName());
        venue.setLocation(venueDTO.getLocation());
        venue.setCapacity(venueDTO.getCapacity());
        // Set other properties as needed

        Venue savedVenue = venueRepository.save(venue);
        return convertToDTO(savedVenue);
    }

    @Override
    public VenueDTO getVenueById(Long id) {
        return venueRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID " + id + " not found"));
    }

    @Override
    public List<VenueDTO> getAllVenues() {
        return venueRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VenueDTO updateVenue(Long id, VenueDTO venueDTO) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID " + id + " not found"));

        venue.setName(venueDTO.getName());
        venue.setLocation(venueDTO.getLocation());
        venue.setCapacity(venueDTO.getCapacity());
        // Update other properties as needed

        Venue updatedVenue = venueRepository.save(venue);
        return convertToDTO(updatedVenue);
    }

    @Override
    public void deleteVenue(Long id) {
        if (!venueRepository.existsById(id)) {
            throw new VenueNotFoundException("Venue with ID " + id + " not found");
        }
        venueRepository.deleteById(id);
    }

    private VenueDTO convertToDTO(Venue venue) {
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setLocation(venue.getLocation());
        venueDTO.setCapacity(venue.getCapacity());
        // Set other properties as needed
        return venueDTO;
    }
}
