package com.tech.team.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.team.model.Team;
import com.tech.team.repository.TeamRepository;

@RestController
public class TeamController {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;

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

	@GetMapping("/members")
	public @ResponseBody String getSentence() {
		return getMembers("Member");
	}

	public String getMembers(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		return restTemplate.getForObject("http://" + service, String.class);
	}
}
