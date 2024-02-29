package com.himedia.hicinema.movie.schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	List<Schedule> findByScreenIdAndScreeningDateAndStatusOrderByIdAsc(Long screenId, LocalDateTime screeningDate, String status);
}
