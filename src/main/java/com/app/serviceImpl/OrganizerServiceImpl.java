package com.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.OrganizerDTO;
import com.app.entity.Organizer;
import com.app.exception.OrganizerNotFoundException;
import com.app.repository.OrganizerRepository;
import com.app.service.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    public OrganizerDTO createOrganizer(OrganizerDTO organizerDTO) {
        Organizer organizer = new Organizer();
        organizer.setName(organizerDTO.getName());
        organizer.setContactInfo(organizerDTO.getContactInfo());
        // Set other properties as needed

        Organizer savedOrganizer = organizerRepository.save(organizer);
        return convertToDTO(savedOrganizer);
    }

    @Override
    public OrganizerDTO getOrganizerById(Long id) {
        return organizerRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new OrganizerNotFoundException("Organizer with ID " + id + " not found"));
    }

    @Override
    public List<OrganizerDTO> getAllOrganizers() {
        return organizerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizerDTO updateOrganizer(Long id, OrganizerDTO organizerDTO) {
        Organizer organizer = organizerRepository.findById(id)
                .orElseThrow(() -> new OrganizerNotFoundException("Organizer with ID " + id + " not found"));

        organizer.setName(organizerDTO.getName());
        organizer.setContactInfo(organizerDTO.getContactInfo());
        // Update other properties as needed

        Organizer updatedOrganizer = organizerRepository.save(organizer);
        return convertToDTO(updatedOrganizer);
    }

    @Override
    public void deleteOrganizer(Long id) {
        if (!organizerRepository.existsById(id)) {
            throw new OrganizerNotFoundException("Organizer with ID " + id + " not found");
        }
        organizerRepository.deleteById(id);
    }

    private OrganizerDTO convertToDTO(Organizer organizer) {
        OrganizerDTO organizerDTO = new OrganizerDTO();
        organizerDTO.setId(organizer.getId());
        organizerDTO.setName(organizer.getName());
        organizerDTO.setContactInfo(organizer.getContactInfo());
        // Set other properties as needed
        return organizerDTO;
    }
}
