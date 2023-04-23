package team3.meowie.dic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team3.meowie.dic.model.dto.PostDto;


@Controller
public class DicPageController {

    @GetMapping("/dic/index")
    public String hello() {
        return "discussion-main/index";
    }
    
//    @GetMapping("/dic/addArticle")
//    public String showAddArticleForm(Model model) {
//    	model.addAttribute("posts", new Posts());
//    	return "discussion-main/addArticle";
//    }
    @GetMapping("/dic/addArticle")
    public String showAddArticleForm(Model model) {
    	model.addAttribute("postDto", new PostDto());
    	return "discussion-main/addArticle";
    }
    @GetMapping("/dic/commentManagement")
    public String commentManagement() {
    	return "discussion-main/commentManagement";	
    }
    @GetMapping("/dic/notificationManagement")
    public String notificationManagement() {
    	return "discussion-main/notificationManagement";	
    }
    
}