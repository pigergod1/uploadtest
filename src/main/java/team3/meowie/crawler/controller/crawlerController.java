package team3.meowie.crawler.controller;

import java.net.http.HttpTimeoutException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team3.meowie.crawler.model.TopMovielist;
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
	@ResponseBody
	@ExceptionHandler(java.net.http.HttpTimeoutException.class)
	public String handleError(){
		return "connection error";
	}	
	@GetMapping("crawler/comment/yahoo")
	public String autoCrawlerCommentsFromYahoo(@RequestParam(name = "moviename") String moviename) throws HttpTimeoutException {
		commentsService.autoCrawlerCommentsFromYahoo(moviename);
		return "crawler/test";
	}

	@GetMapping("crawler/comment/yahoo/toplist")
	public String autoCrawlerToplistMovieCommentsFromYahoo() throws HttpTimeoutException {
		commentsService.autoCrawlerTopMovieslistCommentsFromYahoo(topMovielistService.getTopMovielistAll());
		return "crawler/test";
	}

	@ResponseBody
	@GetMapping("crawler/toplist/yahoo")
	public List<TopMovielist> autoCrawlerTopMovielistFromYahoo() {
		return topMovielistService.autoCrawlerTopMovielistFromYahoo();
	}

}
