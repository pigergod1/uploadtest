package team3.meowie.dic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.meowie.dic.model.PostRepository;
import team3.meowie.dic.model.Posts;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public void addPost(Posts posts) {
		postRepository.save(posts);
		
	}
	public Posts getLatest() {
		return postRepository.findFirstByOrderByPostDateDesc();
	}

}
