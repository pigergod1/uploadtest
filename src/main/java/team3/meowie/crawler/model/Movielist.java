package team3.meowie.crawler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "crawlerMovielist")
public class Movielist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "moviename", columnDefinition = "nvarchar(200)", nullable = false)
	private String moviename;

	@Column(name = "hot", columnDefinition = "integer", nullable = true)
	private Integer hot;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Movielist() {
	}

	@Override
	public String toString() {
		return "Movielist [id=" + id + ", moviename=" + moviename + ", hot=" + hot + "]";
	}

}
