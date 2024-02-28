package com.himedia.hicinema.slide;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himedia.hicinema.movie.AdminMovieController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/slide")
public class AdminSlideController {

	private final MainSlideRepository mainSlideRepository;


	//mainslide_list
	@GetMapping("/mainslide_list")
	public String mainSlideList(Model model) {
		List<MainSlide> mainSlideList = this.mainSlideRepository.findAll();
		model.addAttribute("title", "메인슬라이드 목록");
		return "admin/slide/mainslide_list";
	}

	@GetMapping("/mainslide_form")
	public String mainSlideForm(Model model) {
		model.addAttribute("title", "메인슬라이드 등록");
		return "admin/slide/mainslide_form";
	}

}
