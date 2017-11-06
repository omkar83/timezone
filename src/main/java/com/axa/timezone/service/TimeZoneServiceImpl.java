package com.axa.timezone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.timezone.model.TimeZone;
import com.axa.timezone.repository.TimeZoneRepository;

@Service("timeZoneService")
public class TimeZoneServiceImpl implements TimeZoneService {
	@Autowired
	TimeZoneRepository timeZoneRepository;

	@Override
	public List<TimeZone> findAll() {
		return timeZoneRepository.findAll();
	}

	@Override
	public TimeZone findById(int id) {
		return timeZoneRepository.findById(id);
	}

	@Override
	public TimeZone save(TimeZone timeZone) {
		return timeZoneRepository.save(timeZone);
	}

}
