package com.himedia.hicinema.payment;

import com.himedia.hicinema.movie.schedule.Schedule;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PaymentMovie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_movie_id")
	private Long id;

	private String title;
	private int price;
	private String description;

	@ManyToOne
	@JoinColumn(name="schedule_id")
	private Schedule schedule;
}
