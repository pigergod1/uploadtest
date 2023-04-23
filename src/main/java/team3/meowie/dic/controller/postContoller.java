package team3.meowie.dic.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import team3.meowie.dic.model.Posts;
import team3.meowie.dic.model.dto.PostDto;
import team3.meowie.dic.service.PostService;

@Controller
public class postContoller {
	
	@Autowired
	private PostService postService;
	
	
	
	//POST 用於提交表單。
//	@PostMapping("/dic/submitArticle/post")
//	public String submitArticle(@ModelAttribute("posts")Posts posts,Model model) {
//		postService.addPost(posts);
//		model.addAttribute("posts",new Posts());
//		
//		Posts latest = postService.getLatest() ;//取得最新資料
//		model.addAttribute("latest",latest);
//		return"discussion-main/addArticle";
//		
//	}
	@GetMapping("/dic/submitArticle")
	public String displayForm(Model model) {
	    model.addAttribute("postForm", new PostDto());
	    return "discussion-main/addArticle";
	}
	@PostMapping("/dic/submitArticle/post")
	public String submitArticle(@ModelAttribute("postDto") PostDto postDto,Model model) {
		Posts posts = new Posts();
//		posts.setUserID(posts.getUserID());//Spring Security
		posts.setTitle(postDto.getTitle());
		posts.setContent(postDto.getContent());
		
		MultipartFile imageFile= postDto.getImage();
		byte[]imageData=null;
		if(imageFile!=null) {
			try {
				imageData=imageFile.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			posts.setImage(imageData);
		}
		postService.addPost(posts);
		model.addAttribute("postDto",new PostDto());
		
		Posts latest=postService.getLatest();
		model.addAttribute("latest",latest);
		return "discussion-main/addArticle";
		
		
		
		
		
		
		}
}
