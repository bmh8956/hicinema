package com.himedia.hicinema.movie.loc;

import com.himedia.hicinema.movie.theater.Theater;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="loc_id")
	private long id;

	private String name;

	@Column(length = 1, nullable = false)
	private String status = "O";

	@OneToMany(mappedBy = "location")
	private List<Theater> theaters = new ArrayList<>();
}
