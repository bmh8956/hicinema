package com.himedia.hicinema.movie;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.himedia.hicinema.Crawling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public String movieDetail(Model model) {
		model.addAttribute("title", "영화 상세");
		return "admin/movie/movie_detail";
	}
	
	@GetMapping("/movie_crawling")
	public String movieCrawling(Model model) {
		model.addAttribute("title", "영화 리스트 업데이트");
		return "admin/movie/movie_crawling";
	}

	@RequestMapping("/crawling/get_info")
	@ResponseBody
	public String get_info() throws InterruptedException {
		log.info("============crawling start==========");
		String data = Crawling.crawling_movie_list();
		log.info("============crawling end============");
//		System.out.println(data);
		return data;
	}

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
