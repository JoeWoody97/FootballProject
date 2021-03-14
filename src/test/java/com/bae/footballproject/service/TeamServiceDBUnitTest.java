package com.bae.footballproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.footballproject.domain.Team;
import com.bae.footballproject.repos.TeamRepo;

@SpringBootTest
@ActiveProfiles("test")
public class TeamServiceDBUnitTest {
	
	@Autowired
	private TeamServiceDB service;
	
	@MockBean
	private TeamRepo repo;
	
	@Test
	void createTeamTest() {
		Team newTeam = new Team("Bayern Bru", "Jim", "Red and White", 6, "Chinley", "jim@gmail.com");
		Team savedTeam = new Team(1L,"Bayern Bru", "Jim", "Red and White", 6, "Chinley", "jim@gmail.com");
		
		Mockito.when(this.repo.save(newTeam)).thenReturn(savedTeam);
		
		assertThat(this.service.createTeam(newTeam)).isEqualTo(savedTeam);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(newTeam);
	}
	
	@Test
	void updateTeamTest() {
		Long id = 1L;
		Team updatedTeam = new Team("Rashford FC", "Jeff", "Green", 7, "Stretford", "Jeff@gmail.com");
		Optional<Team> existingTeam = Optional.of(new Team(id, "Martial Law", "Jeff", "Green", 7, "Stretford", "Jeff@gmail.com"));
		Team resultTeam = new Team(id, "Rashford FC", updatedTeam.getCaptain(), updatedTeam.getKitColour(), updatedTeam.getSquadSize(), updatedTeam.getLocation(), updatedTeam.getContactDetails());
		
		Mockito.when(this.repo.findById(id)).thenReturn(existingTeam);
		Mockito.when(this.repo.save(resultTeam)).thenReturn(resultTeam);
		
		assertThat(this.service.updateTeamById(id, updatedTeam)).isEqualTo(resultTeam);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(resultTeam);
	}
	
	@Test
	void deleteTeamTest() {
		Long id = 1L;
		
		Mockito.when(this.repo.existsById(id)).thenReturn(false);
		
		boolean result = this.service.deleteTeamById(id);
		
		assertThat(result).isFalse();
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(id);
	}
	
	@Test
	void getTeamTest() {
		Long id = 1L;
		Team team = new Team(id, "Martial Law", "Jeff", "Green", 7, "Stretford", "Jeff@gmail.com");
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(team));
		
		assertThat(this.service.getTeamById(id)).isEqualTo(team);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void getTeamNotFound() {
		Long id = 1L;
		
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.empty());
		
		assertThat(this.service.getTeamById(id)).isNull();
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}
	
	@Test
	void getTeamsTest() {
		List<Team> teams = new ArrayList<Team>();
		Mockito.when(this.repo.findAll()).thenReturn(teams);
		
		assertThat(this.service.getTeams()).isEqualTo(teams);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

}
