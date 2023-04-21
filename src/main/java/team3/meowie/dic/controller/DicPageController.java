package team3.meowie.dic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DicPageController {

    @GetMapping("/dic/index")
    public String hello() {
        return "index";
    }
    
    @GetMapping("/dic/articleManagement")
    public String articleManagement() {
        return "admin-main/articleManagement";
    }
    @GetMapping("/dic/commentManagement")
    public String commentManagement() {
    	return "admin-main/commentManagement";	
    }
    @GetMapping("/dic/notificationManagement")
    public String notificationManagement() {
    	return "admin-main/notificationManagement";	
    }
    
}