package com.tech.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tech.team.model.Team;
import com.tech.team.repository.TeamRepository;

@RestController
public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	@Value("${lucky-word}")
	String luckyWord;

	@GetMapping("/lucky-word")
	public String showLuckyWord() {
		return "The lucky word is: " + luckyWord;
	}

	@GetMapping("/teams")
	public Iterable<Team> getTeams() {
		return teamRepository.findAll();
	}

	@GetMapping("/teams/{id}")
	public Team getTeam(@PathVariable Long id) {
		return teamRepository.findOne(id);
	}
}
