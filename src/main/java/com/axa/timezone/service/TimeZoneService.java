package com.axa.timezone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axa.timezone.model.TimeZone;

@Service("timeZoneService")
public interface TimeZoneService {

	List<TimeZone> findAll();

	TimeZone findById(int id);

	TimeZone save(TimeZone timeZone);

}