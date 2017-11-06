package com.axa.timezone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.axa.timezone.model.TimeZone;

@Repository("timeZoneRepository")
public interface TimeZoneRepository extends JpaRepository<TimeZone, Long> {

	TimeZone findById(int id);

}
