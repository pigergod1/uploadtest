package team3.meowie.crawler.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.meowie.crawler.DAO.CommentsRepository;
import team3.meowie.crawler.model.Comments;

@Service
public class CommentsService {
	@Autowired
	private CommentsRepository commentsRepository;

	public void autoCrawlerCommentsFromYahoo(String moviename) {
		try {
			String url = "https://movies.yahoo.com.tw/moviesearch_result.html?keyword=";
			url += moviename;
			int pages = 1;
			String mainurl = null;
			HttpClient httpclient = HttpClient.newBuilder().connectTimeout(Duration.ofMillis(3000))
					.followRedirects(HttpClient.Redirect.NORMAL).build();
			HttpRequest.Builder reqBuilder = HttpRequest.newBuilder().version(Version.HTTP_2)
					.timeout(Duration.ofMillis(3500)).header("User-Agent",
							"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
			HttpRequest request = reqBuilder.uri(URI.create(url)).build();
			HttpResponse<String> response = null;
			response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200) {
				String html = response.body();
				Document doc = Jsoup.parse(html);
				url = doc.select(".release_movie_name a").attr("href");
				request = reqBuilder.uri(URI.create(url)).build();
				response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());
				if (response.statusCode() == 200) {
					html = response.body();
					doc = Jsoup.parse(html);
					url = doc.select(".usercom_more a").attr("href");
					mainurl = doc.select(".usercom_more a").attr("href");
					request = reqBuilder.uri(URI.create(url)).build();
					System.out.println(url);
					response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());
					if (response.statusCode() == 200) {
						html = response.body();
						doc = Jsoup.parse(html);
						Elements elements = doc.select(".usercom_inner");
						for (Element e : elements) {
							Comments moviebean = new Comments();
							moviebean.setRating(
									Integer.valueOf(e.getElementsByAttributeValue("name", "score").attr("value")));
							moviebean.setComment(e.select("span").text());
							Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.parse(e.select(".user_time").text().substring(5));
							moviebean.setAdded(date);
							moviebean.setUrl(url);
							commentsRepository.save(moviebean);
							System.out.println(moviebean);
						}
					}
					pages = Integer.valueOf(doc.select(".nexttxt").first().previousElementSibling().text());
					if (pages > 1) {
						for (int i = 2; i <= pages; i++) {
							url = mainurl + "?page=" + i;
							request = reqBuilder.uri(URI.create(url)).build();
							response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());
							if (response.statusCode() == 200) {
								html = response.body();
								doc = Jsoup.parse(html);
								Elements elements = doc.select(".usercom_inner");
								for (Element e : elements) {
									Comments moviebean = new Comments();
									moviebean.setRating(
											Integer.valueOf(e.getElementsByAttributeValue("name", "score").attr("value")));
									moviebean.setComment(e.select("span").text());
									Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
											.parse(e.select(".user_time").text().substring(5));
									moviebean.setAdded(date);
									moviebean.setUrl(url);
									commentsRepository.save(moviebean);
									System.out.println(moviebean);
								}
							}
						}
					}

				}

			} else {
				System.out.println("返回狀態200");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
