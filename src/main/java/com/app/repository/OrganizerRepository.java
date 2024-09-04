package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
