package com.himedia.hicinema.notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himedia.hicinema.movie.AdminMovieController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/notice")

public class AdminNoticeController {
	@GetMapping("/notice_list")
	public String eventList(Model model) {
		model.addAttribute("title", "공지사항 리스트");
		return "admin/notice/notice_form";
	}
	
	@GetMapping("/notice_form")
	public String eventForm(Model model) {
		model.addAttribute("title", "공지사항 등록");
		return "admin/notice/notice_list";
	}
	
	@GetMapping("/notice_detail")
	public String eventDetail(Model model) {
		model.addAttribute("title", "공지사항 수정");
		return "admin/notice/notice_detail";
	}
}
