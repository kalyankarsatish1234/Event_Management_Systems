package com.app.service;

import com.app.dto.OrganizerDTO;
import java.util.List;

public interface OrganizerService {
    OrganizerDTO createOrganizer(OrganizerDTO organizerDTO);
    OrganizerDTO getOrganizerById(Long id);
    List<OrganizerDTO> getAllOrganizers();
    OrganizerDTO updateOrganizer(Long id, OrganizerDTO organizerDTO);
    void deleteOrganizer(Long id);
}
