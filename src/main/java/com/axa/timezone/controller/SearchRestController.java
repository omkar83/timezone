package com.axa.timezone.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.timezone.model.TimeZone;
import com.axa.timezone.service.TimeZoneService;

@RestController
@RequestMapping("/tz")
public class SearchRestController {
	@Autowired
	TimeZoneService timeZoneService;

	@GetMapping("/")
	public ResponseEntity<List<TimeZone>> listTimeZone() {

		List<TimeZone> tz = timeZoneService.findAll();
		if (tz.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tz, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TimeZone> getTimeZobeById(@PathVariable int id) {
		return new ResponseEntity<TimeZone>(timeZoneService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<TimeZone> addTimeZone(@RequestBody TimeZone timeZone) {
		
		//java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Tokyo"));
		TimeZone mockTimeZone = new TimeZone();
		mockTimeZone.setId(timeZone.getId());
		mockTimeZone.setCreateDate(new Date());
		mockTimeZone.setUpdateDate(new Date());
		mockTimeZone.setUpdatedBy(timeZone.getUpdatedBy());
		
		return new ResponseEntity<TimeZone>(timeZoneService.save(mockTimeZone), HttpStatus.OK);
	}
	
	
	
}