package team3.meowie.crawler.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.meowie.crawler.DAO.ToplistRepository;
import team3.meowie.crawler.model.TopMovielist;

@Service
public class TopMovielistService {
	@Autowired
	private ToplistRepository toplistRepository;

	@Transactional
	public List<TopMovielist> autoCrawlerTopMovielistFromYahoo() {
		String url = "https://movies.yahoo.com.tw/chart.html";
		HttpResponse<String> response = null;
		String html = null;
		String moviename = null;
		List<TopMovielist> relist = new ArrayList<>();
		toplistRepository.deleteAll();
		toplistRepository.resetId();
		HttpClient httpclient = HttpClient.newBuilder().connectTimeout(Duration.ofMillis(3000))
				.followRedirects(HttpClient.Redirect.NORMAL).build();
		HttpRequest.Builder reqBuilder = HttpRequest.newBuilder().version(Version.HTTP_2)
				.timeout(Duration.ofMillis(3500)).header("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
		HttpRequest request = reqBuilder.uri(URI.create(url)).build();
		try {
			response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				html = response.body();
				Document doc = Jsoup.parse(html);
				moviename = doc.select("dd>h2").text();
				moviename += doc.select("dd>h3").text();
				TopMovielist list1 = new TopMovielist();
				list1.setMoviename(moviename);
				toplistRepository.save(list1);
				relist.add(list1);
				Elements elements = doc.select(".rank_txt");
				for (Element e : elements) {
					TopMovielist list = new TopMovielist();
					list.setMoviename(e.text());
					toplistRepository.save(list);
					relist.add(list);
				}
			}

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relist;
	}
}
