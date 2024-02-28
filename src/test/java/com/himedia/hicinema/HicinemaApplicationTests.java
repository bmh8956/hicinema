package com.himedia.hicinema;

import com.himedia.hicinema.slide.MainSlide;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.himedia.hicinema.slide.MainSlideRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

import java.util.Optional;
import java.util.Queue;

@SpringBootTest
class HicinemaApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private MainSlideRepository mainSlideRepository;


//	void testJpa() {
//		MainSlide m1 = new MainSlide();
//		m1.setImgId("1-1");
//		m1.setVideoId("1-2");
//		this.mainSlideRepository.save(m1);
//
//		MainSlide m2 = new MainSlide();
//		m2.setImgId("2-1");
//		m2.setVideoId("2-2");
//		this.mainSlideRepository.save(m2);
//	}


}
