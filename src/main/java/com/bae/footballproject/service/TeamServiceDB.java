package com.bae.footballproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bae.footballproject.domain.Team;
import com.bae.footballproject.repos.TeamRepo;

@Service
public class TeamServiceDB implements TeamService {
	
	private TeamRepo repo;

	public TeamServiceDB(TeamRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Team createTeam(Team team) {
		Team saved = this.repo.save(team);
		return saved;
	}
	
	@Override
	public List<Team> getTeams() {
		return this.repo.findAll();
	}

	@Override
	public Team getTeamById(Long id) {
		Optional<Team> optTeam = this.repo.findById(id);
		return optTeam.orElse(null);
	}

	@Override
	public Team updateTeamById(Long id, Team newTeam) {
		Optional<Team> optionalTeam = this.repo.findById(id);
		Team existing = optionalTeam.get();
		
		existing.setTeamName(newTeam.getTeamName());
		existing.setCaptain(newTeam.getCaptain());
		existing.setKitColour(newTeam.getKitColour());
		existing.setSquadSize(newTeam.getSquadSize());
		existing.setLocation(newTeam.getLocation());
		existing.setContactDetails(newTeam.getContactDetails());
		
		Team updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public boolean deleteTeamById(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	
	

}
