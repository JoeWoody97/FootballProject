package com.bae.footballproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.footballproject.domain.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {

	
}
