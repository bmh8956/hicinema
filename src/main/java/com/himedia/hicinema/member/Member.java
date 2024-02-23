package com.himedia.hicinema.member;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	String name;
	String mb_id;
	String pw;
	String email;
	String phone;


	String status;
	LocalDateTime regdate;
	LocalDateTime delDate;


}
