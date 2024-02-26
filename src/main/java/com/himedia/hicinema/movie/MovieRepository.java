package com.himedia.hicinema.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long>,
		QuerydslPredicateExecutor<Movie>, MovieRepositoryCustom {
	Optional<Movie> findByTitle(String title);
	Optional<Movie> findByMovieCd(String movieCd);


}
