package team3.meowie.dic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="posts")
public class Discussion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PostID")
	private Integer PostID;
	
	@Column(name="UserID")
	private Integer UserID;
	
	@Column(name="Title")
	private String Title;
	
	@Column(name="Content")
	private String Content;
	
	@Column(name="PostDate")
	private Date PostDate;
	
	@Column(name="Image")
	private byte[] Image;
	public Integer getPostID() {
		return PostID;
	}

	public void setPostID(Integer postID) {
		PostID = postID;
	}

	public Integer getUserID() {
		return UserID;
	}

	public void setUserID(Integer userID) {
		UserID = userID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getPostDate() {
		return PostDate;
	}

	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		Image = image;
	}


	// 省略 getter 和 setter 方法
}