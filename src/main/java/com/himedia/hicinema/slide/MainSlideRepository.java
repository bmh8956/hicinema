package com.himedia.hicinema.slide;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MainSlideRepository  extends JpaRepository<MainSlide, Long> {
    MainSlide findByImgId(String imgId);

}
