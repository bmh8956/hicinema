package com.himedia.hicinema.member;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/admin")
@RequiredArgsConstructor  
public class adminMemberController {

	private final MemberService memberService;

//	@GetMapping(value = {"", "/"})
//	public String admin(Model model) {
//		model.addAttribute("title", "관리자 메인");
//		return "admin/index";
//	}
//
//	@GetMapping("/index")
//	public String index(Model model) {
//		return "redirect:/admin";
//	}
//
//	@GetMapping("/error/505")
//	public String error_505(Model model) {
//		model.addAttribute("title", "error");
//		return "admin/505";
//	}
	
	 @GetMapping("/member/memberlist")
	 public String memberlist(Model model, @RequestParam(value="page", defaultValue="0") int page) {
	    Page<Member> paging = this.memberService.getList(page);
	        model.addAttribute("paging", paging);
	        return "admin/member/member_list";
	    }
	
	
}
