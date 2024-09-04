package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
