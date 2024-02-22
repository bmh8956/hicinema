package com.himedia.hicinema.theater;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminTheaterController {

	@GetMapping("")
	public String admin(Model model) {
		log.info("admin page");
		model.addAttribute("title", "관리자 메인");
		return "redirect:/admin/index";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("title", "관리자 메인");
		return "admin/index";
	}

	@GetMapping("/theater/theater_list")
	public String theaterList(Model model) {
		model.addAttribute("title", "영화관 리스트");
		return "admin/theater/theater_list";
	}

	@GetMapping("/theater/loc_list")
	public String locList(Model model) {
		model.addAttribute("title", "지역");
		return "admin/theater/loc_list";
	}

	@GetMapping("/theater/theater_detail")
	public String theaterDetail(Model model) {
		model.addAttribute("title", "영화관 상세");
		return "admin/theater/theater_detail";
	}

	@GetMapping("/theater/theater_form")
	public String theaterForm(Model model) {
		model.addAttribute("title", "영화관 등록");
		return "admin/theater/theater_form";
	}

	@GetMapping("/theater/theater_screen")
	public String theaterScreen(Model model) {
		model.addAttribute("title", "영화관 등록");
		return "admin/theater/theater_screen";
	}

	@GetMapping("/theater/movie_list")
	public String movieList(Model model) {
		model.addAttribute("title", "상영중");
		return "admin/theater/movie_list";
	}

	@GetMapping("/theater/movie_listSoon")
	public String movieList2(Model model) {
		model.addAttribute("title", "상영예정");
		return "admin/theater/movie_list2";
	}

	@GetMapping("/theater/movie_listEnd")
	public String movieList3(Model model) {
		model.addAttribute("title", "상영종료");
		return "admin/theater/movie_list3";
	}

	@GetMapping("/theater/movie_form")
	public String movieForm(Model model) {
		model.addAttribute("title", "영화 등록");
		return "admin/theater/movie_form";
	}

	@GetMapping("/theater/movie_detail")
	public String movieDetail(Model model) {
		model.addAttribute("title", "영화 상세");
		return "admin/theater/movie_detail";
	}
}
