package team3.meowie.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team3.meowie.crawler.service.CommentsService;
import team3.meowie.crawler.service.MovielistService;
import team3.meowie.crawler.service.TopMovielistService;

@Controller
public class crawlerController {
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private MovielistService movielistService;
	@Autowired
	private TopMovielistService topMovielistService;
	@GetMapping("crawler/comment/yahoo")
	public String autoCrawlerCommentsFromYahoo(@RequestParam(name = "moviename") String moviename) {
		commentsService.autoCrawlerCommentsFromYahoo(moviename);
		return "crawler/test";
	}
}
