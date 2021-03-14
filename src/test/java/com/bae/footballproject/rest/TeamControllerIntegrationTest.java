package com.bae.footballproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.footballproject.domain.Team;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:team-schema.sql",
	"classpath:team-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class TeamControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Team newTeam = new Team("Bayern Bru", "Jim", "Red and White", 6, "Chinley", "jim@gmail.com");
		String newTeamAsJSON = this.mapper.writeValueAsString(newTeam);
		RequestBuilder mockRequest = post("/createTeam").contentType(MediaType.APPLICATION_JSON)
				.content(newTeamAsJSON);
		
		Team savedTeam = new Team(2L, "Bayern Bru", "Jim", "Red and White", 6, "Chinley", "jim@gmail.com");
		String savedTeamAsJSON = this.mapper.writeValueAsString(savedTeam);
		
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedTeamAsJSON);
		
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		
	}
	
	@Test
	void updateTest() throws Exception {
		Team testTeam = new Team("Martial Law", "Jeff", "Green", 7, "Stretford", "Jeff@gmail.com");
		String testTeamAsJSON = this.mapper.writeValueAsString(testTeam);

		RequestBuilder mockRequest = put("/updateTeam/1").contentType(MediaType.APPLICATION_JSON)
				.content(testTeamAsJSON);

		Team updatedTeam = new Team(1L, "Martial Law", "Jeff", "Green", 7, "Stretford", "Jeff@gmail.com");
		String updatedTeamAsJSON = this.mapper.writeValueAsString(updatedTeam);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(updatedTeamAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void readTest() throws Exception {
		Team testTeam = new Team(1L, "Team default", "Jimmy", "Black", 5, "Chorley", "test@gmail.com");
		List<Team> allTeams = List.of(testTeam);
		String testTeamAsJSON = this.mapper.writeValueAsString(allTeams);
		
		RequestBuilder mockRequest = get("/getTeams");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testTeamAsJSON);
		
		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void deleteTest() throws Exception {
		RequestBuilder mockRequest = delete("/deleteTeam/1");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("false");
		
		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
	}

}
