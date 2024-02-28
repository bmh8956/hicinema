package com.himedia.hicinema.movie.theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TheaterRepository extends JpaRepository<Theater, Long>,
		QuerydslPredicateExecutor<Theater>, TheaterRepositoryCustom {

}
