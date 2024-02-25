package com.himedia.hicinema.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

	private final MovieRepository mvRepository;

	public void create(Movie mv) {
		mvRepository.save(mv);
	}

}
