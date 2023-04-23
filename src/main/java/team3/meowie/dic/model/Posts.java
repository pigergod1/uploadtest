package team3.meowie.dic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="Posts")
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PostID")
	private Integer postID;
	
	@Column(name="UserID")
	private Integer userID; 
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Content")
	private String content;
	
//	@Column(name="PostDate")
//	private Date postDate;
	
	
	@Column(name="Image")
	private byte[] image;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss EEEE",timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "PostDate", columnDefinition = "datetime")
	private Date postDate;
	
	@PrePersist
	public void onCreate() {
		if(postDate == null) {
			postDate = new Date();
		}
	}

	public Date getAdded() {
		return postDate;
	}

	public void setAdded(Date added) {
		this.postDate = added;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

	
	public byte[] getImage() {
		return image;
	} 

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}