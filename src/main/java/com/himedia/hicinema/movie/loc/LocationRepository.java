package com.himedia.hicinema.movie.loc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
	List<Location> findByStatus(String status);
//	Optional<Location> findById(String id);
}
