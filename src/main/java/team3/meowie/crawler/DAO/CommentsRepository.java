package team3.meowie.crawler.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import team3.meowie.crawler.model.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

}
