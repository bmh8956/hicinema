package com.himedia.hicinema.movie.theater;

import com.himedia.hicinema.movie.loc.Location;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="theater_id")
	private Long id;

	private String name;

	private String zipcode;
	private String addr;
	private String addr_detail;
	private String addr_ref;

	private String file_id;   //여러개면 ,로 구분
	private String content;

	@ManyToOne
	@JoinColumn(name="loc_id")
	private Location location;
}
