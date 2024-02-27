package com.himedia.hicinema.movie.loc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LocationService {
	private final LocationRepository locationRepository;

	public List<Location> getList(String status) {
		return locationRepository.findByStatus(status);
	}

	public void create(Location loc) {
		locationRepository.save(loc);
	}

	public void delete(Location loc) {
		locationRepository.save(loc);
	}
}
