package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Speaker;
import com.example.demo.repositories.SpeakerRepository;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {
	@Autowired
	private SpeakerRepository speakerRepository;
	
	@GetMapping
	public List<Speaker> list(){
		return speakerRepository.findAll();
	}

	@PostMapping
	public Speaker create(@RequestBody Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	@GetMapping
	@RequestMapping(value = "{id}")
	public Speaker findOne(@PathVariable Long id) {
		return speakerRepository.getOne(id);
	}
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		 speakerRepository.deleteById(id);
	}
	
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker existSpeaker= speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, existSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(existSpeaker);
	}
}
