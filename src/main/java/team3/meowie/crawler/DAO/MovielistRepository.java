package team3.meowie.crawler.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import team3.meowie.crawler.model.Movielist;

public interface MovielistRepository extends JpaRepository<Movielist, Integer> {

}
