package com.bae.footballproject.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.footballproject.domain.Team;
import com.bae.footballproject.service.TeamService;

@RestController
@CrossOrigin
public class TeamController {
	
	private TeamService service;

	public TeamController(TeamService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/createTeam")
	public ResponseEntity<Team> createTeam(@RequestBody Team team) {
		return new ResponseEntity<Team>(this.service.createTeam(team), HttpStatus.CREATED);
	}
	
	@GetMapping("/getTeams")
	public ResponseEntity<List<Team>> getTeams() {
		return ResponseEntity.ok(this.service.getTeams());
	}
	
	@GetMapping("/getTeam/{id}")
	public Team getTeambyId(@PathVariable Long id) {
		return this.service.getTeamById(id);
	}
	
	@PutMapping("/updateTeam/{id}")
	public Team updateTeamById(@PathVariable Long id, @RequestBody Team newTeam) {
		return this.service.updateTeamById(id, newTeam);
	}
	
	@DeleteMapping("/deleteTeam/{id}")
	public boolean deleteTeamById(@PathVariable Long id) {
		return this.service.deleteTeamById(id);
	}

}
