package com.himedia.hicinema.movie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.himedia.hicinema.Crawling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {
	private final MovieService movieService;

	@GetMapping("/theater_list")
	public String theaterList(Model model) {
		model.addAttribute("title", "영화관 리스트");
		return "admin/movie/theater_list";
	}

	@GetMapping("/loc_list")
	public String locList(Model model) {
		model.addAttribute("title", "지역");
		return "admin/movie/loc_list";
	}

	@GetMapping("/theater_detail")
	public String theaterDetail(Model model) {
		model.addAttribute("title", "영화관 상세");
		return "admin/movie/theater_detail";
	}

	@GetMapping("/theater_form")
	public String theaterForm(Model model) {
		model.addAttribute("title", "영화관 등록");
		return "admin/movie/theater_form";
	}

	@GetMapping("/theater_screen")
	public String theaterScreen(Model model) {
		model.addAttribute("title", "영화관 등록");
		return "admin/movie/theater_screen";
	}

	@GetMapping("/movie_list")
	public String movieList(Model model) {
		model.addAttribute("title", "상영중");
		return "admin/movie/movie_list";
	}

	@GetMapping("/list/get")
	@ResponseBody
	public ResponseEntity<String> getList(MovieSearchDto mv) throws JsonProcessingException {
		JsonArray ja = new JsonArray();
		System.out.println("get_list");
		System.out.println(mv);
		Pageable pageable = PageRequest.of(mv.getPage().isPresent() ? mv.getPage().get() : 0, 5);
		Page<ListMovieDto> movies = movieService.getAdminMoviePage(mv, pageable);

		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		String json = om.writeValueAsString(movies);
		log.info(json);
		ja.add(json);

		return new ResponseEntity<>(ja.toString(), HttpStatus.OK);
	}

	@GetMapping("/movie_listSoon")
	public String movieList2(Model model) {
		model.addAttribute("title", "상영예정");
		return "admin/movie/movie_list2";
	}

	@GetMapping("/movie_listEnd")
	public String movieList3(Model model) {
		model.addAttribute("title", "상영종료");
		return "admin/movie/movie_list3";
	}

	@GetMapping("/movie_form")
	public String movieForm(Model model) {
		model.addAttribute("title", "영화 등록");
		return "admin/movie/movie_form";
	}

	@GetMapping("/movie_detail")
	public String movieDetail(Model model, String movieCd) {
		model.addAttribute("title", "영화 상세");
		try {
			Movie mv = movieService.getAdminMovieDetail(movieCd);
			System.out.println(mv);
			model.addAttribute("movie", mv);
			return "admin/movie/movie_detail";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/admin/movie/movie_list";
		}

	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/movie_crawling")
	public String movieCrawling(Model model) {
		model.addAttribute("title", "영화 리스트 업데이트");
		return "admin/movie/movie_crawling";
	}

	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/crawling/get_info")
	@ResponseBody
	public String get_info() throws InterruptedException {
		log.info("============crawling start==========");
		String data = Crawling.crawling_movie_list();
		log.info("============crawling end============");
//		System.out.println(data);
		return data;
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/crawling/get_details")
	@ResponseBody
	public ResponseEntity<String> updateMovie(@RequestBody List<Movie> mvs) throws InterruptedException {
		JsonArray ja = new JsonArray();
		Gson gson = new Gson();
		String data = "";
		for(Movie mv : mvs) {
			System.out.println(mv.getMovieCd());
			Movie movie = Crawling.get_movie(mv);
			movieService.create(movie);
			ja.add(mv.getMovieCd());
		}
//		JsonObject jo = new JsonObject();
//		jo.addProperty("msg", "success");
//		jo.addProperty("list", String.valueOf(ja));
		return new ResponseEntity<>(ja.toString(), HttpStatus.OK);
	}
	
}
