package team3.meowie.dic.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  PostRepository extends JpaRepository<Posts, Integer> {

	
	public Posts findFirstByOrderByPostDateDesc();
	
}
