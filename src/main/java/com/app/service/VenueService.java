package com.app.service;

import java.util.List;

import com.app.dto.VenueDTO;

public interface VenueService {
    VenueDTO createVenue(VenueDTO venueDTO);
    VenueDTO getVenueById(Long id);
    List<VenueDTO> getAllVenues();
    VenueDTO updateVenue(Long id, VenueDTO venueDTO);
    void deleteVenue(Long id);
}
