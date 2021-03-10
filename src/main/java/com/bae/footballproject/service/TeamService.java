package com.bae.footballproject.service;

import java.util.List;

import com.bae.footballproject.domain.Team;

public interface TeamService {

	Team createTeam(Team team);

	Team getTeamById(Long id);
	
	Team updateTeamById(Long id, Team newTeam);

	boolean deleteTeamById(Long id);

	List<Team> getTeams();

}
