package com.himedia.hicinema.slide;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MainSlide {

    //메인 슬라이드 id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private long id;

    //메인 슬라이드 이미지 파일 id
    @Column(length = 200)
    private String imgId;

    //메인 슬라이드 영상 파일 id
    @Column(length = 200)
    private String videoId;


}