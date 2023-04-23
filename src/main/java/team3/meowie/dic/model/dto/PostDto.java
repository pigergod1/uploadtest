package team3.meowie.dic.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostDto {
	private Integer userId;



	private String title;

	private String content;

	private MultipartFile image;

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return userId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

}
