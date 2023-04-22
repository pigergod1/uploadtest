package team3.meowie.crawler.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import team3.meowie.crawler.model.TopMovielist;

public interface ToplistRepository extends JpaRepository<TopMovielist, Integer> {

}
